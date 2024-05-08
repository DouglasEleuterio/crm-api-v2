package br.com.tresptecnologia.entity.benchmark;

import br.com.tresptecnologia.core.entity.BaseActiveEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "exemplo_root_filho_many")
public class ExemploFilhoMany extends BaseActiveEntity {

    @Id
    @Column(name = "id", nullable = false, length = 36)
    private Long id;


    @Column(name = "descricao", nullable = false, length = 36)
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_root")
    private ExemploRoot root;

}
