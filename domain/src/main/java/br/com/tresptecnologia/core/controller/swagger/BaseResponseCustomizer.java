package br.com.tresptecnologia.core.controller.swagger;

import br.com.tresptecnologia.core.controller.swagger.annotation.SwaggerGenericResponseType;
import br.com.tresptecnologia.core.controller.BaseRsqlController;
import br.com.tresptecnologia.core.controller.BaseRsqlFindController;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.responses.ApiResponse;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import java.util.Collection;
import java.util.Objects;

@Slf4j
@Getter
@Component
public class BaseResponseCustomizer implements OperationCustomizer {

    private final SchemaStoreSingleton schemaStoreSingleton;

    public BaseResponseCustomizer(SchemaStoreSingleton schemaStoreSingleton) {
        this.schemaStoreSingleton = schemaStoreSingleton;
    }

    @Override
    public Operation customize(Operation operation, HandlerMethod handlerMethod) {
        if (handlerMethod.hasMethodAnnotation(SwaggerGenericResponseType.class)) {

            ApiResponse response = operation.getResponses().get(String.valueOf(HttpStatus.OK.value()));
            if (response == null) {
                return operation;
            }

            final TypeFactory typeFactory = TypeFactory.defaultInstance();

            JavaType type = typeFactory.constructType(handlerMethod.getBeanType());
            JavaType typeResponse = getBinding(type.getSuperClass());
            if (typeResponse != null && handlerMethod.getReturnType().getMethod() != null) {
                try {
                    Objects.requireNonNull(handlerMethod.getReturnType());
                    Objects.requireNonNull(handlerMethod.getReturnType().getMethod());
                    if (Collection.class.isAssignableFrom(Objects.requireNonNull(handlerMethod.getReturnType()
                            .getMethod().getReturnType()))) {
                        configureArraySchema(typeResponse, response);
                    } else if (Objects.requireNonNull(handlerMethod.getReturnType().getMethod().getReturnType())
                            .isAssignableFrom(Page.class)) {
                        JavaType pageType = typeFactory.constructParametricType(Page.class, typeResponse.getRawClass());
                        configureSchema(pageType, response);
                    } else {
                        configureSchema(typeResponse, response);
                    }
                } catch (NullPointerException ex) {
                    log.debug("error ao gerar o swagger", ex);
                }

            }

        }
        return operation;
    }

    private JavaType getBinding(JavaType javaType) {
        if (javaType.getRawClass().equals(BaseRsqlController.class)) {
            return javaType.getBindings().getBoundType(2);
        } else if (javaType.getRawClass().equals(BaseRsqlFindController.class)) {
            return javaType.getBindings().getBoundType(1);
        }
        return null;
    }

    private void configureSchema(JavaType typeResponse, ApiResponse response) {
        final var resolvedSchema = ModelConverters.getInstance().readAllAsResolvedSchema(typeResponse);
        schemaStoreSingleton.add(resolvedSchema);
        final var content = response.getContent();
        final var media = content.get(MediaType.APPLICATION_JSON_VALUE);
        if (media != null) {
            media.setSchema(resolvedSchema.schema);
        }
    }

    private void configureArraySchema(JavaType typeResponse, ApiResponse response) {
        final var resolvedSchema = ModelConverters.getInstance().readAllAsResolvedSchema(typeResponse);
        schemaStoreSingleton.add(resolvedSchema);
        final var schema = new ArraySchema();
        schema.addAllOfItem(resolvedSchema.schema);
        final var content = response.getContent();
        final var media = content.get(MediaType.APPLICATION_JSON_VALUE);
        if (media != null) {
            media.getSchema().items(resolvedSchema.schema);
        }
    }

}
