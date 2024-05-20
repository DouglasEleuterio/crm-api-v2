package br.com.tresptecnologia.entity.notafiscal;

import br.com.tresptecnologia.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

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
@Table(name = "PRD_PROD")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Prod extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRD")
    @SequenceGenerator(name = "SQ_PRD", sequenceName = "SQ_PRD", allocationSize = 1)
    @Column(name = "PRD_ID", nullable = false)
    private Long id;

    @Column(name = "PRD_cProd")
    public String cProd;
    @Column(name = "PRD_cEAN")
    public String cEAN;
    @Column(name = "PRD_xProd")
    public String xProd;
    @Column(name = "PRD_NCM")
    @JsonProperty( "NCM")
    public String ncm;
    @Column(name = "PRD_CFOP")
    @JsonProperty( "CFOP")
    public String cfop;
    @Column(name = "PRD_uCom")
    public String uCom;
    @Column(name = "PRD_qCom")
    public String qCom;
    @Column(name = "PRD_vUnCom")
    public String vUnCom;
    @Column(name = "PRD_vProd")
    public String vProd;
    @Column(name = "PRD_cEANTrib")
    public String cEANTrib;
    @Column(name = "PRD_uTrib")
    public String uTrib;
    @Column(name = "PRD_qTrib")
    public String qTrib;
    @Column(name = "PRD_vUnTrib")
    public String vUnTrib;
    @Column(name = "PRD_indTot")
    public String indTot;
}
