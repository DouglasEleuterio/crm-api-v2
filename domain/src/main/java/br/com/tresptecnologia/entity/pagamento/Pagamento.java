package br.com.tresptecnologia.entity.pagamento;

import br.com.tresptecnologia.core.entity.BaseActiveEntity;
import br.com.tresptecnologia.entity.aquisicao.Aquisicao;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Aquisicao aquisicao;

    @OneToMany(mappedBy = "pagamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ParcelaPagamento> pagamentos;
}
