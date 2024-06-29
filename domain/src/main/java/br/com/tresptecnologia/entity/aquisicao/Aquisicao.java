package br.com.tresptecnologia.entity.aquisicao;

import br.com.tresptecnologia.core.entity.BaseActiveEntity;
import br.com.tresptecnologia.entity.cliente.Cliente;
import br.com.tresptecnologia.entity.pagamento.Pagamento;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "aquisicao")
public class Aquisicao extends BaseActiveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_AQUISICAO")
    @SequenceGenerator(name = "SQ_AQUISICAO", sequenceName = "SQ_AQUISICAO", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "data_aquisicao", nullable = false)
    private LocalDateTime dataAquisicao;
    @Column(name = "valor_aquisicao", nullable = false)
    private Double valorAquisicao;
    @Column(name = "valor_desconto", nullable = false)
    private Double valorDesconto;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aquisicao")
    @JsonBackReference
    private List<AquisicaoProcedimento> procedimentos;
    @OneToMany(mappedBy = "aquisicao", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Pagamento> pagamentos;
}
