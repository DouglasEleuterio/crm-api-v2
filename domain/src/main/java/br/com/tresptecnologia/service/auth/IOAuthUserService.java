package br.com.tresptecnologia.service.auth;

import br.com.tresptecnologia.model.auth.AuthUser;

import java.util.Collection;

public interface IOAuthUserService {
    void saveOrUpdate(AuthUser user);
    Collection<String> getPermissions(String jti, String sub);
}
