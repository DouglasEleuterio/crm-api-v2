package br.com.tresptecnologia.core.jpa.rsql;

import br.com.tresptecnologia.core.jpa.util.SpecificationUtils;
import org.springframework.data.jpa.domain.Specification;

public class RsqlSpecificationModel {

    private final String[] fetchProperties;
    private final String search;

    public RsqlSpecificationModel(RsqlSpecificationModel model) {
        if (model == null) {
            fetchProperties = null;
            search = null;
        } else {
            this.fetchProperties = model.fetchProperties;
            this.search = model.search;
        }
    }

    public RsqlSpecificationModel(String search, String... fetchProperties) {
        this.fetchProperties = fetchProperties;
        this.search = search;
    }

    public <T> Specification<T> toSpecification() {
        return SpecificationUtils.rsqlToSpecification(search);
    }

    public <T> Specification<T> toSpecificationWithFetchProperties() {
        return SpecificationUtils.rsqlToSpecificationWithFetchProperties(search, fetchProperties);
    }


}
