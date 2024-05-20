package br.com.tresptecnologia.entity.notafiscal.imposto.cofins;

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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "CFA_COFINSAliq")
public class COFINSAliq extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_COFINSAliq")
    @Column(name = "CFA_ID", nullable = false)
    @SequenceGenerator(name = "SQ_COFINSAliq", sequenceName = "SQ_COFINSAliq", allocationSize = 1)
    private Long id;

    @Column(name = "CFA_vCOFINS")
    public Double vCOFINS;

    @Column(name = "CFA_CST")
    @JsonProperty("CST")
    public String cst;

    @Column(name = "CFA_vBC")
    public Double vBC;

    @Column(name = "CFA_pCOFINS")
    public Double pCOFINS;
}
