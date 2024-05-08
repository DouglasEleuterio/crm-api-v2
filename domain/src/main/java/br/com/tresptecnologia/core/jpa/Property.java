package br.com.tresptecnologia.core.jpa;

import br.com.tresptecnologia.core.jpa.metadata.IEntityMetadata;
import br.com.tresptecnologia.core.jpa.metadata.PropertyMetadata;
import jakarta.persistence.criteria.Fetch;
import jakarta.persistence.criteria.From;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Path;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

import static java.util.Objects.nonNull;

public class Property implements Serializable {

    private String name;

    private String alias;

    private Property joinProperty;
    private String[] properties;

    private transient IEntityMetadata entityMetadata;

    public Property(String property) {
        verifyJoin(property);
    }

    public Property(String property, IEntityMetadata entityMetadata) {
        verifyJoin(property, entityMetadata);
        this.entityMetadata = entityMetadata;
    }

    public Property(String property, String[] properties) {
        verifyJoin(property);
        this.properties = properties;
    }

    private boolean isFetch() {
        return nonNull(properties) && Arrays.stream(properties).anyMatch(cf -> cf.equals(this.name));
    }

    private <T, Y> Fetch<T, Y> getActualFetch(From<T, Y> root) {

        final Optional<Fetch<Y, ?>> optionalFetch = root.getFetches().stream().filter(x -> x.getAttribute().getName()
                .equals(name)).findFirst();

        if (optionalFetch.isPresent()) {

            return (Fetch<T, Y>) optionalFetch.get();

        }

        return root.fetch(name, JoinType.LEFT);

    }

    public <T, Y> Fetch<T, Y> getFetch(From<T, Y> root) {
        return root.getFetches() == null ?
                root.fetch(name, JoinType.LEFT) : getActualFetch(root);
    }

    private void verifyJoin(String property) {
        if (property.contains(".")) {
            String[] split = property.split("\\.", 2);
            this.name = split[0];
            this.joinProperty = new Property(split[1]);
        } else {
            this.name = property;
        }
    }

    private void verifyJoin(String property, IEntityMetadata entityMetadata) {
        if (property.contains(".")) {
            String[] split = property.split("\\.", 2);
            this.name = split[0];
            this.joinProperty = new Property(split[1], entityMetadata);
        } else {
            this.name = property;
        }
    }

    public <T> Path<T> getPath(From<?, ?> root) {
        Path<T> pathProperty = root.get(name);
        boolean hasEntityMetadata = Objects.nonNull(entityMetadata);

        if (hasEntityMetadata) {
            this.alias = getAlias(root.getJavaType(), name);
        }

        if (joinProperty != null) {
            Path<T> joinPath = joinProperty.getPath(isFetch() ? (From<?, ?>) getFetch(root) : getJoin(root));
            if (hasEntityMetadata) {
                this.alias = alias + "." + joinProperty.getAlias();
            }
            return joinPath;
        } else {
            return pathProperty;
        }
    }

    public String getAlias() {
        return alias;
    }

    public Join<?, ?> getJoin(From<?, ?> root) {
        return root.getJoins() == null ?
                root.join(name, JoinType.LEFT) : getActualJoin(root);
    }

    private Join<?, ?> getActualJoin(From<?, ?> root) {
        Optional<?> join = root.getJoins().stream().filter(x -> x.getAttribute().getName()
                .equals(name)).findFirst();
        if (join.isPresent()) {
            return (Join<?, ?>) join.get();
        }
        return root.join(name, JoinType.LEFT);
    }

    private <T> String getAlias(Class<T> clazz, String name) {
        PropertyMetadata metadata = entityMetadata.get(clazz, name);
        if (metadata.isCollection()) {
            return name + "[]";
        } else if (metadata.isId()) {
            return name + "*";
        }
        return name;
    }

}
