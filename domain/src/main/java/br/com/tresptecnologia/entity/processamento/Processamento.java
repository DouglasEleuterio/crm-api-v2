package br.com.tresptecnologia.entity.processamento;

import br.com.tresptecnologia.core.entity.BaseEntity;
import br.com.tresptecnologia.enumeration.ESituacaoFinalizacao;
import br.com.tresptecnologia.enumeration.ESituacaoProcessamento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "PRC_PROCESSAMENTO")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Processamento extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PROCESSAMENTO")
    @SequenceGenerator(name = "SQ_PROCESSAMENTO", sequenceName = "SQ_PROCESSAMENTO", allocationSize = 1)
    @Column(name = "PRC_ID", nullable = false)
    private Long id;
    @Column(name = "PRC_DH_INICIO", nullable = false)
    private LocalDateTime inicio;
    @Column(name = "PRC_DH_FIM")
    private LocalDateTime fim;
    @Column(name = "PRC_DH_ULTIMO_PROCESSAMENTO")
    private LocalDateTime ultimoProcessamento;
    @Enumerated(EnumType.STRING)
    @Column(name = "PRC_CD_SITUACAO_PROCESSAMENTO", nullable = false)
    private ESituacaoProcessamento situacaoProcessamento;
    @Enumerated(EnumType.STRING)
    @Column(name = "PRC_CD_SITUACAO_FINALIZACAO", nullable = false)
    private ESituacaoFinalizacao situacaoFinalizacao;
}
