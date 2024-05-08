package br.com.tresptecnologia.service.auth.converter;

import br.com.tresptecnologia.model.auth.AuthUser;
import br.com.tresptecnologia.model.auth.JwtClaims;
import br.com.tresptecnologia.model.auth.OAuthToken;
import br.com.tresptecnologia.service.auth.IJwtUserConverter;
import br.com.tresptecnologia.service.auth.IOAuthUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class JwtUserConverter implements IJwtUserConverter {

    private final IOAuthUserService oAuthUserService;

    public JwtUserConverter(final IOAuthUserService oAuthUserService) {
        this.oAuthUserService = oAuthUserService;
    }

    @Override
    public AuthUser user(OAuthToken token) throws JsonProcessingException {
        final var mapClaims = JwtClaims.getClaimsMap(token.getAccessToken());
        final var user = AuthUser.createFromJwtToken(token, mapClaims);

        // Salva o cria um usuário na tabela de usuários
        oAuthUserService.saveOrUpdate(user);

        //Carrega as permissões do usuário
        user.setPermissions(permissions(mapClaims));

        return user;
    }

    @Override
    public Collection<String> permissions(Map<String, Object> claims) {
        final var permissions = new ArrayList<String>();

        if (Objects.isNull(claims) || claims.isEmpty()) {
            return Collections.emptyList();
        }
        if(claims.containsKey("roles") && claims.get("roles").getClass().isAssignableFrom(ArrayList.class)) {
            //noinspection unchecked
            permissions.addAll((ArrayList<String>) claims.get("roles"));
        }
        return permissions;
    }

    @Override
    public Collection<GrantedAuthority> jwtAuthorities(Map<String, Object> claims) {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (String authority : permissions(claims)) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority));
        }
        return grantedAuthorities;
    }
}
