package br.com.tresptecnologia.entity.procedimento;

import br.com.tresptecnologia.entity.profissional.Profissional;
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
@Table(name = "regiao")
public class Regiao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_REGIAO")
    @SequenceGenerator(name = "SQ_REGIAO", sequenceName = "SQ_REGIAO", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "quantidade_sessoes")
    private int quantidadeSessoes;
    @Column(name = "intervalo_entre_sessoes")
    private int intervaloEntreSessoes;
    @Column(name = "duracao")
    private Integer duracao;
    @Column(name = "valor", nullable = false)
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "procedimento_id")
    private Procedimento procedimento;

    @ManyToOne
    @JoinColumn(name = "profissional_id", nullable = false)
    private Profissional profissional;

}
