package br.com.tresptecnologia.entity.cliente;

import br.com.tresptecnologia.core.entity.BaseEntity;
import jakarta.persistence.CascadeType;
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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "endereco")
public class Endereco extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ENDERECO")
    @SequenceGenerator(name = "SQ_ENDERECO", sequenceName = "SQ_ENDERECO", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "logradouro", nullable = false)
    private String logradouro;
    @Column(name = "numero", nullable = false)
    private String numero;
    @Column(name = "complemento", nullable = false)
    private String complemento;
    @Column(name = "bairro", nullable = false)
    private String bairro;
    @JoinColumn(name = "cidade_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Cidade cidade;
    @Column(name = "cep", nullable = false)
    private String cep;
}
