package br.com.tresptecnologia.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseActiveEntity extends BaseEntity {

    @Column(name = "situacao", nullable = false)
    private Boolean situacao;

    @Override
    protected void prePersist() {
        super.prePersist();
        this.situacao = true;
    }

}
