package br.com.tresptecnologia.entity;

import br.com.tresptecnologia.core.entity.BaseActiveEntity;
import br.com.tresptecnologia.model.pagamento.Pagamento;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "pedido")
public class Pedido extends BaseActiveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_pedido")
    @SequenceGenerator(name = "sq_pedido", sequenceName = "sq_pedido", allocationSize = 1)
    @Column(name = "id")
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Cliente cliente;
    @Column(name = "valor_total", nullable = false)
    private Double valorTotal;
    @Column(name = "desconto", nullable = false)
    private Double desconto;
    @Column(name = "valor_total_itens", nullable = false)
    private Double valorTotalItens;

    @Transient
    Set<Pagamento> pagamentos;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Set<ItemDePedido> itens;
}
