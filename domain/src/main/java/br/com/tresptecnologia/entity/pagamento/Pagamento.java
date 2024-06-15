package br.com.tresptecnologia.entity.pagamento;

import br.com.tresptecnologia.core.entity.BaseActiveEntity;
import br.com.tresptecnologia.entity.aquisicao.Aquisicao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "pagamento")
public class Pagamento extends BaseActiveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PAGAMENTO")
    @SequenceGenerator(name = "SQ_PAGAMENTO", sequenceName = "SQ_PAGAMENTO", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "data_pagamento", nullable = false)
    private LocalDateTime dataPagamento;
    @Column(name = "valor_taxa", nullable = false)
    private Double valorPagamento;
    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pagamento")
    private EFormaPagamento formaPagamento;
    @Column(name = "quantidade_parcelas", nullable = false)
    private Integer quantidadeParcelas;
    @Column(name = "taxa", nullable = false)
    private Double taxa;
    @ManyToOne
    @JoinColumn(name = "aquisicao_id")
    @JsonIgnore
    private Aquisicao aquisicao;

    @OneToMany(mappedBy = "pagamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ParcelaPagamento> pagamentos;
}
