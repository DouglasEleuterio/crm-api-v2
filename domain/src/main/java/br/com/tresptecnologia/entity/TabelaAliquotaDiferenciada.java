package br.com.tresptecnologia.entity;

import br.com.tresptecnologia.core.entity.BaseActiveEntity;
import br.com.tresptecnologia.enumeration.EnumSituacao;
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

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "TAD_TAB_ALIQUOTA_DIFERENCIADA")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TabelaAliquotaDiferenciada extends BaseActiveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TAD")
    @SequenceGenerator(name = "SQ_TAD", sequenceName = "SQ_TAD", allocationSize = 1)
    @Column(name = "TAD_ID", nullable = false)
    private Long id;

    @Column(name = "TAD_NU_NCM", nullable = false, length = 9)
    private String ncm;
    @Column(name = "TAD_DT_INICIO_VIGENCIA", nullable = false)
    private LocalDate inicioVigencia;
    @Column(name = "TAD_DT_FIM_VIGENCIA")
    private LocalDate fimVigencia;
    @Column(name = "TAD_ST_SITUACAO")
    @Enumerated(EnumType.STRING)
    private EnumSituacao enumSituacao;
}
