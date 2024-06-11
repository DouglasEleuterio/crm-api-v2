package br.com.tresptecnologia.entity.pagamento;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "parcela_pagamento")
public class ParcelaPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PARCELA_PAGAMENTO")
    @SequenceGenerator(name = "SQ_PARCELA_PAGAMENTO", sequenceName = "SQ_PARCELA_PAGAMENTO", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
        @Column(name = "data_credito", nullable = false)
    private LocalDate dataCredito;
    @Column(name = "valor_credito", nullable = false)
    private Double valorCredito;
    @Column(name = "valor_taxa", nullable = false)
    private Double valorTaxa;
    @Column(name = "recebido", nullable = false)
    private Boolean isRecebido;
    @Column(name = "numero_parcela", nullable = false)
    private Integer numeroParcela;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pagamento_id")
    private Pagamento pagamento;
}