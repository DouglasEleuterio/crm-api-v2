package br.com.tresptecnologia.entity.aquisicao;

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
@Table(name = "regiao_procedimento_aquisicao")
public class RegiaoProcedimentoAquisicao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_REGIAO_PROCEDIMENTO_AQUISICAO")
    @SequenceGenerator(name = "SQ_REGIAO_PROCEDIMENTO_AQUISICAO", sequenceName = "SQ_REGIAO_PROCEDIMENTO_AQUISICAO", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "quantidade_sessoes")
    private int quantidadeSessoes;
    @Column(name = "intervalo_entre_sessoes")
    private int intervaloEntreSessoes;
    @Column(name = "valor", nullable = false)
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "aquisicao_procedimento")
    private AquisicaoProcedimento procedimento;
}
