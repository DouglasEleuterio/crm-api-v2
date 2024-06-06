package br.com.tresptecnologia.entity.cliente;

import br.com.tresptecnologia.core.entity.BaseEntity;
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
@Table(name = "estado")
public class Estado extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ESTADO")
    @SequenceGenerator(name = "SQ_ESTADO", sequenceName = "SQ_ESTADO", allocationSize = 1)
    @Column(name = "id", nullable = false, length = 36)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "codigo_ibge")
    private String codigoIBGE;
    @Column(name = "uf", nullable = false)
    private String uf;
}


