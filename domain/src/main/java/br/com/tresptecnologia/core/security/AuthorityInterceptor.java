package br.com.tresptecnologia.core.security;

import br.com.tresptecnologia.core.exception.AuthorityException;
import br.com.tresptecnologia.core.config.ApplicationProperties;
import br.com.tresptecnologia.core.message.Message;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Nonnull;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component
public class AuthorityInterceptor implements HandlerInterceptor {

    private final ApplicationProperties properties;

    public AuthorityInterceptor(ApplicationProperties properties) {
        this.properties = properties;
    }

    @Override
    public boolean preHandle(@Nonnull HttpServletRequest request,
                             @Nonnull HttpServletResponse response,
                             @Nonnull Object handler) throws AuthorityException {

        if (isAbleToCheckPermission(handler)) {
            checkPermission(((HandlerMethod) handler).getMethod());
        }

        return true;
    }

    private boolean isAbleToCheckPermission(@Nonnull Object handler) {
        boolean isHandlerMethod = handler instanceof HandlerMethod;
        return isHandlerMethod && ((HandlerMethod) handler).getMethod().isAnnotationPresent(AuthorityAllowed.class)
                && !properties.isIgnorarAutorizacao();
    }

    private void checkPermission(Method method) throws AuthorityException {
        AuthorityAllowed permissionAnnotation = method.getAnnotation(AuthorityAllowed.class);
        String[] permissions = permissionAnnotation.value();
        Set<String> permissionSet = new HashSet<>(Arrays.asList(permissions));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Set<String> authoritiesSet = AuthorityUtils.authorityListToSet(authorities);

        final boolean hasPermission = hasAnyAuthorities(permissionSet, authoritiesSet);

        if (!hasPermission) {
            if (properties.isExibirAutorizacao()) {
                throw new AuthorityException(getMessage(method), permissions);
            }

            throw new AuthorityException(getMessage(method));
        }
    }

    private boolean hasAnyAuthorities(Set<String> permissionSet, Set<String> authoritiesSet) {
        for (String permission : permissionSet) {
            if (authoritiesSet.contains(permission)) {
                return true;
            }
        }
        return false;
    }

    private String getMessage(final Method method) {
        if (method.isAnnotationPresent(Operation.class)) {
            final Operation operationAnnotation = method.getAnnotation(Operation.class);
            final String description = operationAnnotation.description();
            if (StringUtils.isNotBlank(description))
                return Message.toLocale("error.forbidden.resource", description);
        }
        return Message.toLocale("error.forbidden");
    }
}
