package br.com.tresptecnologia.controller.auth;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.model.auth.AuthRequest;
import br.com.tresptecnologia.model.auth.OAuthToken;
import br.com.tresptecnologia.service.auth.IOAuthService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller responsável pela autenticação OAuth
 * Se o projeto não for utilizar o OAuth, ele deve ser removido.
 */
@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticação")
public class AuthController {

    private final IOAuthService authService;

    public AuthController(final IOAuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Operation(description = "Autenticação OAuth")
    public OAuthToken token(@RequestParam MultiValueMap<String, String> paramMap) throws DomainException, JsonProcessingException {
        return authService.token(AuthRequest.fromMultiValueMap(paramMap));
    }

    @PostMapping(value = "/logout", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Logout")
    public ResponseEntity<Object> logout(@RequestParam MultiValueMap<String, String> paramMap) throws DomainException {
        var logout = authService.logout(paramMap.getFirst("refresh_token"), paramMap.getFirst("redirect_uri"));
        return ResponseEntity.ok(logout);
    }

}
