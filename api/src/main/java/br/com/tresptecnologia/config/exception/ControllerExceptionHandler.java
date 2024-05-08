package br.com.tresptecnologia.config.exception;

import br.com.tresptecnologia.core.config.ApplicationProperties;
import br.com.tresptecnologia.core.controller.model.AuthorityResponse;
import br.com.tresptecnologia.core.controller.model.ErrorResponse;
import br.com.tresptecnologia.core.controller.model.ValidationResponse;
import br.com.tresptecnologia.core.exception.AuthorityException;
import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.exception.ValidationBagException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.NonNull;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private final ApplicationProperties properties;

    public ControllerExceptionHandler(ApplicationProperties properties) {
        this.properties = properties;
    }

    @Override
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    protected ResponseEntity<Object> handleHttpMessageNotReadable(@NonNull HttpMessageNotReadableException ex,
                                                                  @NonNull HttpHeaders headers,
                                                                  @NonNull HttpStatusCode status,
                                                                  @NonNull WebRequest request) {
        log.debug("Erro ao realizar a leitura do payload para o request", ex);
        if ((ex.getCause() instanceof JsonMappingException && ex.getCause().getCause() instanceof InvalidFormatException)
                || ex.getCause() instanceof InvalidFormatException) {
            InvalidFormatException invalidFormatException = (InvalidFormatException) ex.getCause().getCause();
            return new ResponseEntity<>(ErrorResponse
                    .badRequest(String.format("Ocorreu um erro ao converter o valor '%s' para o tipo '%s'", invalidFormatException.getValue(), invalidFormatException.getTargetType().getSimpleName())),
                    HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(ErrorResponse.badRequest(ex.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleConstraintException(Exception ex, WebRequest request) {
        log.debug("Erro de integridade de dados", ex);
        HttpMethod method = ((ServletWebRequest) request).getHttpMethod();
        if (ex.getCause() instanceof ConstraintViolationException
                && method == HttpMethod.DELETE) {
            return new ResponseEntity<>(ErrorResponse.constraintException(ex), HttpStatus.BAD_REQUEST);
        }
        if (ex.getCause() instanceof DataException) {
            return new ResponseEntity<>(ErrorResponse.entityDataException(ex), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(ErrorResponse.notMappedException(ex), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidationBagException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleValidationBagException(ValidationBagException ex) {
        log.debug("Erro de validação de negocio", ex);
        return new ResponseEntity<>(ErrorResponse.validationBag(ex), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DomainException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleDomainException(Exception ex) {
        log.debug("Erro de validação de dominio", ex);
        return new ResponseEntity<>(ErrorResponse.badRequest(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<AuthorityResponse> accessDeniedException(AccessDeniedException ex) {
        log.debug("Erro de permissão", ex);
        return new ResponseEntity<>(AuthorityResponse.withoutPermission(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(AuthorityException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<AuthorityResponse> authorityException(AuthorityException ex) {
        log.debug("Erro de permissão", ex);
        if (ex.getAuthorities() != null && ex.getAuthorities().length > 0) {
            return new ResponseEntity<>(AuthorityResponse.withoutPermission(ex.getMessage(), ex.getAuthorities()),
                    HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(AuthorityResponse.withoutPermission(ex.getMessage()), HttpStatus.FORBIDDEN);
    }

    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  @NonNull HttpHeaders headers,
                                                                  @NonNull HttpStatusCode status,
                                                                  @NonNull WebRequest request) {
        final List<ValidationResponse> errors = new ArrayList<>();
        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(new ValidationResponse(error.getField(), error.getDefaultMessage()));
        }
        for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(new ValidationResponse(error.getObjectName(), error.getDefaultMessage()));
        }
        final ErrorResponse apiError = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), null, errors);
        return handleExceptionInternal(ex, apiError, headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex) {
        log.debug("Erro não mapeado", ex);
        if (!properties.isExibirStacktrace()) {
            return new ResponseEntity<>(ErrorResponse.notMappedException(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(ErrorResponse.notMappedException(ex), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
