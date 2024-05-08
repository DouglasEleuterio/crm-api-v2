package br.com.tresptecnologia.core.repository.specification;

public record SelectionConstructor<T, Y>(Class<T> modelClass, SpecificationSelection<Y> specificationSelection) {
}
