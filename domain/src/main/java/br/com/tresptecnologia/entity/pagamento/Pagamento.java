package br.com.tresptecnologia.entity.pagamento;

import br.com.tresptecnologia.entity.aquisicao.Aquisicao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
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

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PAGAMENTO")
    @SequenceGenerator(name = "SQ_PAGAMENTO", sequenceName = "SQ_PAGAMENTO", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "data_pagamento", nullable = false)
    private LocalDateTime dataPagamento;
    @Column(name = "valor_pagamento", nullable = false)
    private Double valorPagamento;
    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pagamento")
    private EFormaPagamento formaPagamento;
    @Column(name = "taxa", nullable = false)
    private Double taxa;
    @ManyToOne
    @JoinColumn(name = "aquisicao_id", foreignKey = @ForeignKey(name = "FK_AQUISICAO_PAGAMENTO"), nullable = false)
    private Aquisicao aquisicao;
}
