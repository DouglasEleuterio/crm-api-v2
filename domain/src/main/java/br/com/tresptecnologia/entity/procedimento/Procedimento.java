package br.com.tresptecnologia.entity.procedimento;

import br.com.tresptecnologia.core.entity.BaseActiveEntity;
import br.com.tresptecnologia.enumeration.procedimento.ETipoProcedimento;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    @Column(name = "nome")
    private String nome;
    @Column(name = "valor")
    private Double valor;
    @Column(name = "quantidade_sessoes")
    private Integer quantidadeSessoes;
    @Column(name = "intervalo_entre_sessoes")
    private Integer intervaloEntreSessoes;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "procedimento")
    @JsonBackReference
    private List<Regiao> regioes;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_procedimento")
    private ETipoProcedimento tipoProcedimento;
}
