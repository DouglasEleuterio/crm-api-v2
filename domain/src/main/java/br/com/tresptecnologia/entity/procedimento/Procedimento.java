package br.com.tresptecnologia.entity.procedimento;

import br.com.tresptecnologia.core.entity.BaseActiveEntity;
import br.com.tresptecnologia.enumeration.EProcedimento;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "procedimento")
public class Procedimento extends BaseActiveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PROCEDIMENTO")
    @SequenceGenerator(name = "SQ_PROCEDIMENTO", sequenceName = "SQ_PROCEDIMENTO", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "nome", nullable = false)
    private EProcedimento nome;
    @Column(name = "regiao")
    private String regiao;
    @Column(name = "quantidade_sessoes")
    private int quantidadeSessoes;
    @Column(name = "intervalo_entre_sessoes")
    private int intervaloEntreSessoes;
    @Column(name = "valor", nullable = false)
    private Double valor;
}
