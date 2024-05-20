package br.com.tresptecnologia.entity.notafiscal.imposto.icms;

import br.com.tresptecnologia.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "IC6_ICMS60")
public class Icms60 extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ICMS60")
    @Column(name = "IC6_ID", nullable = false)
    @SequenceGenerator(name = "SQ_ICMS60", sequenceName = "SQ_ICMS60", allocationSize = 1)
    private Long id;

    @Column(name = "IC6_pST")
    public Double pST;

    @Column(name = "IC6_ORIGG")
    public String orig;

    @Column(name = "IC6_CST")
    public String cst;

    @Column(name = "IC6_vBCSTRet")
    public Double vBCSTRet;

    @Column(name = "IC6_vICMSSubstituto")
    public Double vICMSSubstituto;

    @Column(name = "IC6_vICMSSTRet")
    public Double vICMSSTRet;
}
