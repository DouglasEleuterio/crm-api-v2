package br.com.tresptecnologia.service.auth;

import br.com.tresptecnologia.model.auth.AuthLogout;

public interface IOAuthLogoutStrategy {
    AuthLogout logout(String refreshToken, String redirectUri);
}
