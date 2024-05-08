package br.com.tresptecnologia.entity;

import br.com.tresptecnologia.core.entity.BaseActiveEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "item_de_pedido")
public class ItemDePedido extends BaseActiveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_item_pedido")
    @SequenceGenerator(name = "sq_item_pedido", sequenceName = "sq_item_pedido", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "quantidade")
    private Long quantidade;

    @Column(name = "valor_unitario")
    private Double valorUnitario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id")
    @JsonBackReference
    private Pedido pedido;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "produto_id")
    @JsonBackReference
    private Produto produto;
}
