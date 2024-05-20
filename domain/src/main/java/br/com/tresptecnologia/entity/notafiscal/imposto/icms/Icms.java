package br.com.tresptecnologia.entity.notafiscal.imposto.icms;

import br.com.tresptecnologia.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "ICM_ICMS")
public class Icms extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ICMS")
    @Column(name = "ICM_ID", nullable = false)
    @SequenceGenerator(name = "SQ_ICMS", sequenceName = "SQ_ICMS", allocationSize = 1)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IC6_ID", foreignKey = @ForeignKey(name = "FK_IC6_ICM"))
    @JsonProperty("ICMS60")
    public Icms60 icms60 ;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IC0_ID", foreignKey = @ForeignKey(name = "FK_IC0_ICM"))
    @JsonProperty("ICMS00")
    public Icms00 icms00 ;
}
