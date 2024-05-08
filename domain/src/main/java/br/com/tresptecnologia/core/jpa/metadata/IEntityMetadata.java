package br.com.tresptecnologia.core.jpa.metadata;

public interface IEntityMetadata {
    <T> PropertyMetadata get(Class<T> clazz, String property);
}
