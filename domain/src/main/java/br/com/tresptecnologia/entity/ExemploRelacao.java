package br.com.tresptecnologia.entity;

import br.com.tresptecnologia.core.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "exemplo_relacao")
public class ExemploRelacao extends BaseEntity {

    @Id
    @Column(name = "id", nullable = false, length = 36)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

}
