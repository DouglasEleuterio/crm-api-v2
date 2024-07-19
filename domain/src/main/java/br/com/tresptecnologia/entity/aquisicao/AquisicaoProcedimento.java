package br.com.tresptecnologia.entity.aquisicao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "aquisicao_procedimento")
public class AquisicaoProcedimento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_AQUISICAO_PROCEDIMENTO")
    @SequenceGenerator(name = "SQ_AQUISICAO_PROCEDIMENTO", sequenceName = "SQ_AQUISICAO_PROCEDIMENTO", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "procedimento_origem_id")
    private Long procedimentoOrigemId;

    @OneToMany(mappedBy = "procedimento", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<RegiaoProcedimentoAquisicao> regioes;

    @ManyToOne
    @JoinColumn(name = "aquisicao_id", nullable = false)
    private Aquisicao aquisicao;
}
