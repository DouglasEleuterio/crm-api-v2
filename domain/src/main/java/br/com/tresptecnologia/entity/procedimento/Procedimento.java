package br.com.tresptecnologia.entity.procedimento;

import br.com.tresptecnologia.core.entity.BaseActiveEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procedimento")
    @JsonBackReference
    private List<Regiao> regioes;
}
