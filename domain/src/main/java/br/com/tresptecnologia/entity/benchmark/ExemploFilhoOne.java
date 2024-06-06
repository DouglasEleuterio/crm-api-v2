package br.com.tresptecnologia.entity.benchmark;

import br.com.tresptecnologia.core.entity.BaseActiveEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "exemplo_root_filho_one")
public class ExemploFilhoOne extends BaseActiveEntity {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "descricao", nullable = false)
    private String descricao;
}
