package br.com.tresptecnologia.core.util;

import br.com.tresptecnologia.core.entity.BaseEntity;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

@Slf4j
public final class EntityUtil {
    private EntityUtil() {
    }

    public static boolean isValid(BaseEntity entity) {
        return entity != null && entity.getId() > 0;
    }

    public static <T> Collection<T> mergeCollection(Collection<T> source, Collection<T> target) {
        if (source == null) {
            return target;
        } else {
            source.clear();
            source.addAll(target);
            return source;
        }
    }

    public static <T extends BaseEntity> Optional<T> findCollectionId(Collection<T> source, Predicate<? super T> predicate) {
        if (source == null || source.isEmpty()) {
            return Optional.empty();
        }
        return source.stream().filter(predicate).findFirst();
    }
}
