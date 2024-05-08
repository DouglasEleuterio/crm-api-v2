package br.com.tresptecnologia.core.repository;

import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.Getter;

@Getter
public class PaginatedQuery {
    CriteriaQuery<Tuple> query;
    boolean isSubqueryPaginated;

    public PaginatedQuery(CriteriaQuery<Tuple> query, boolean isSubqueryPaginated) {
        this.query = query;
        this.isSubqueryPaginated = isSubqueryPaginated;
    }
}
