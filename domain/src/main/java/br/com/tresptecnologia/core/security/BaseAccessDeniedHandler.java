package br.com.tresptecnologia.core.security;

import br.com.tresptecnologia.core.controller.model.AuthorityResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BaseAccessDeniedHandler implements AccessDeniedHandler {

    private final ObjectMapper objectMapper;

    public BaseAccessDeniedHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException exception
    ) throws IOException {

        final HttpStatus httpStatus = HttpStatus.FORBIDDEN;

        response.setStatus(httpStatus.value());
        response.addHeader("content-type", "application/json;uft-8");

        response.getOutputStream()
                .write(objectMapper.writeValueAsBytes(AuthorityResponse.withoutPermission()));
    }
}
