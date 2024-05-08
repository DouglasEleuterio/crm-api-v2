package br.com.tresptecnologia.entity.benchmark;

import br.com.tresptecnologia.core.entity.BaseActiveEntity;
import br.com.tresptecnologia.core.jpa.annotation.JpaSelectMapper;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "exemplo_root")
@JpaSelectMapper
public class ExemploRoot extends BaseActiveEntity {

    @Id
    @Column(name = "id", nullable = false, length = 36)
    private Long id;

    @Column(name = "nome", nullable = false, length = 36)
    private String nome;

    @OneToOne
    @JoinColumn(name = "fk_filho_one")
    private ExemploFilhoOne filhoOne;

    @OneToMany(mappedBy = "root", fetch = FetchType.LAZY)
    private List<ExemploFilhoMany> filhosMany;

}
