package br.com.tresptecnologia.entity.aquisicao;

import br.com.tresptecnologia.core.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "aquisicao_procedimento")
public class AquisicaoProcedimento extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_AQUISICAO_PROCEDIMENTO")
    @SequenceGenerator(name = "SQ_AQUISICAO_PROCEDIMENTO", sequenceName = "SQ_AQUISICAO_PROCEDIMENTO", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "valor", nullable = false)
    private Double valor;
    @Column(name = "quantidade_sessoes")
    private Integer quantidadeSessoes;
    @Column(name = "intervalo_entre_sessoes")
    private Integer intervaloEntreSessoes;
    @Column(name = "procedimento_origem_id")
    private Long procedimentoOrigemId;

    @ManyToOne
    @JoinColumn(name = "aquisicao_id", nullable = false)
    private Aquisicao aquisicao;
}
