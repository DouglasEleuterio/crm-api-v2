package br.com.tresptecnologia.service.auth;

import br.com.tresptecnologia.model.auth.AuthUser;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class DefaultOAuthUserService implements IOAuthUserService{
    @Override
    public void saveOrUpdate(AuthUser user) {
        //TODO: Implementar se necessário
    }

    @Override
    public Collection<String> getPermissions(String jti, String sub) {
        //TODO: Implementar o carregamento de permissões se necessário
        return Collections.emptyList();
    }
}
