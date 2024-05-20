package br.com.tresptecnologia.entity.notafiscal.imposto.pis;

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
@Table(name = "PIA_PISAliq")
public class PISAliq extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PISAliq")
    @Column(name = "PIA_ID", nullable = false)
    @SequenceGenerator(name = "SQ_PISAliq", sequenceName = "SQ_PISAliq", allocationSize = 1)
    private Long id;

    @Column(name = "PIA_vPIS")
    public Double vPIS;

    @Column(name = "PIA_CST")
    @JsonProperty( "CST")
    public String cst;

    @Column(name = "PIA_vBC")
    public Double vBC;

    @Column(name = "PIA_pPIS")
    public Double pPIS;
}
