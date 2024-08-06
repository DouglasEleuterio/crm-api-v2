package br.com.tresptecnologia.entity.profissional;

import br.com.tresptecnologia.core.entity.BaseActiveEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "profissional")
public class Profissional extends BaseActiveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PROFISSIONAL")
    @SequenceGenerator(name = "SQ_PROFISSIONAL", sequenceName = "SQ_PROFISSIONAL", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;
}
