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
@Table(name = "FAT_FAT")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fat extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_FAT")
    @SequenceGenerator(name = "SQ_FAT", sequenceName = "SQ_FAT", allocationSize = 1)
    @Column(name = "FAT_ID", nullable = false)
    private Long id;

    @Column(name = "FAT_vOrig")
    public Double vOrig;

    @Column(name = "FAT_nFat")
    @JsonProperty("nFat")
    public String numeroFatura;

    @Column(name = "FAT_vDesc")
    public Double vDesc;

    @Column(name = "FAT_vLiq")
    public Double vLiq;

}
