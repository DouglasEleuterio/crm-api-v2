package br.com.tresptecnologia.core.jpa.util;

import jakarta.persistence.criteria.Path;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public final class JpaArgumentConverter {

    private JpaArgumentConverter() {
    }

    public static Object convert(final Path<?> path, final List<?> args) {
        if (args.size() > 1) {
            var arrayObjects = args.stream().map(x -> convert(path, x)).toArray();
            return new ArrayList<>(Arrays.asList(arrayObjects));
        }

        return convert(path, args.get(0));
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static Object convert(final Path<?> path, final Object argument) {
        if (argument == null || argument.equals("null")) {
            return argument;
        }

        if (path.getJavaType().isEnum()) {
            return Enum.valueOf((Class) path.getJavaType(), (String) argument);
        }

        if ((path.getJavaType().isAssignableFrom(Boolean.class)
                || path.getJavaType().isAssignableFrom(boolean.class))) {
            return Boolean.valueOf((String) argument);
        }

        if (path.getJavaType().isAssignableFrom(Date.class)) {
            return toDate((String) argument);
        }

        if (path.getJavaType().isAssignableFrom(LocalDate.class)) {
            return toLocalDate((String) argument);
        }

        if (path.getJavaType().isAssignableFrom(LocalDateTime.class)) {
            return toLocalDateTime((String) argument);
        }

        if (path.getJavaType().isAssignableFrom(Integer.class)) {
            return Integer.parseInt((String) argument);
        }
        return argument;
    }

    public static boolean isType(final Path<?> path, String type) {
        return type.equals(path.getJavaType().getName());
    }

    public static Date toDate(String argument) {
        return Date.from(LocalDateTime.parse(argument)
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    public static LocalDate toLocalDate(String argument) {
        LocalDateTime localDateTime = LocalDateTime.parse(argument);
        return LocalDate.of(localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth());
    }

    public static LocalDateTime toLocalDateTime(String argument) {
        return LocalDateTime.parse(argument);
    }
}

