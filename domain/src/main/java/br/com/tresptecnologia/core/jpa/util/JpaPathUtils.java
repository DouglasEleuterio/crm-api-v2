package br.com.tresptecnologia.core.jpa.util;

import jakarta.persistence.criteria.Path;
import org.springframework.lang.NonNull;

import java.util.Collections;
import java.util.List;

public final class JpaPathUtils {

    private JpaPathUtils() {
    }

    @NonNull
    public static List<Object> castArguments(final Path<?> path, final List<String> arguments) {

        final Class<?> type = path.getJavaType();

        return Collections.singletonList(arguments.stream().map(arg -> {
            if (arg == null || arg.equals("null")) {
                return null;
            } else if (isLike(arg)) {
                return arg;
            } else if (type.equals(Integer.class)) {
                return Integer.parseInt(arg);
            } else if (type.equals(Long.class)) {
                return Long.parseLong(arg);
            } else if (type.equals(Double.class)) {
                return Double.parseDouble(arg);
            } else {
                return arg;
            }
        }).toList());
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static Object getArgument(final Path<?> path, final List<?> args) {
        Object argument = args.get(0);

        if (argument != null && path.getJavaType().isEnum()) {
            return Enum.valueOf((Class) path.getJavaType(), (String) argument);
        }

        boolean isPathBoolean = argument != null
                && Boolean.class.getSimpleName().equalsIgnoreCase(path.getJavaType().getName());

        if (isPathBoolean && argument instanceof String argumentConverted) {
            if ("true".equalsIgnoreCase(argumentConverted) || "1".equalsIgnoreCase(argumentConverted)) {
                return true;
            }
            if ("false".equalsIgnoreCase(argumentConverted) || "0".equalsIgnoreCase(argumentConverted)) {
                return false;
            }
        }

        return argument;
    }

    public static boolean isLike(final Object argument) {
        if (argument instanceof String argumentString) {
            return argumentString.startsWith("*") || argumentString.endsWith("*");
        }

        return false;
    }
}
