package br.com.tresptecnologia.entity.aquisicao;

import br.com.tresptecnologia.enumeration.EProcedimento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
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
@Table(name = "procedimento_aquisicao")
public class ProcedimentoAquisicao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PROCEDIMENTO_AQUISICAO")
    @SequenceGenerator(name = "SQ_PROCEDIMENTO_AQUISICAO", sequenceName = "SQ_PROCEDIMENTO_AQUISICAO", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "nome", nullable = false)
    private EProcedimento nome;
    @Column(name = "regiao")
    private String regioao;
    @Column(name = "quantidade_sessoes")
    private int quantidadeSessoes;
    @Column(name = "intervalo_entre_sessoes")
    private int intervaloEntreSessoes;
    @Column(name = "valor", nullable = false)
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "aqs_id", foreignKey = @ForeignKey(name = "FK_AQUISICAOPROCEDIMENTO_AQUISICAO"), nullable = false)
    private Aquisicao aquisicao;
}
