package br.com.tresptecnologia.core.repository.specification;

import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;

import java.util.List;

@FunctionalInterface
public interface SpecificationSelection<T> {

    List<Selection<T>> get(Root<?> root);
}
