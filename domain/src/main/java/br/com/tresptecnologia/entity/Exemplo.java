package br.com.tresptecnologia.entity;

import br.com.tresptecnologia.core.entity.BaseActiveEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "exemplo")
public class Exemplo extends BaseActiveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EXEMPLO")
    @SequenceGenerator(name = "SQ_EXEMPLO", sequenceName = "SQ_EXEMPLO", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_relacao")
    private ExemploRelacao relacao;

}
