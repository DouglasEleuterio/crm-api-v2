package br.com.tresptecnologia.core.jpa.metadata;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.metamodel.Attribute;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;

public class DefaultEntityMetadata implements IEntityMetadata {

    private final EntityManagerFactory entityManagerFactory;

    public DefaultEntityMetadata(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public <T> PropertyMetadata get(Class<T> clazz, String property) {
        EntityType<T> entityType = entityManagerFactory.getMetamodel().entity(clazz);

        Attribute<?, ?> entityAttribute = entityType.getAttribute(property);

        PropertyMetadata metadata = new PropertyMetadata();

        if (entityAttribute instanceof SingularAttribute<?, ?>) {
            metadata.setId(((SingularAttribute<?, ?>) entityAttribute).isId());
        } else {
            metadata.setCollection(entityAttribute.isCollection());
        }
        return metadata;
    }
}