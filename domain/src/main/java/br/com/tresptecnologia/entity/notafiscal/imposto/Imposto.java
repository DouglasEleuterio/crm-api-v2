package br.com.tresptecnologia.entity.notafiscal.imposto;

import br.com.tresptecnologia.core.entity.BaseEntity;
import br.com.tresptecnologia.entity.notafiscal.imposto.cofins.Cofins;
import br.com.tresptecnologia.entity.notafiscal.imposto.icms.Icms;
import br.com.tresptecnologia.entity.notafiscal.imposto.ipi.Ipi;
import br.com.tresptecnologia.entity.notafiscal.imposto.pis.Pis;
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
@Table(name = "IMP_IMPOSTO")
public class Imposto extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_IMPOSTO")
    @Column(name = "IMP_ID", nullable = false)
    @SequenceGenerator(name = "SQ_IMPOSTO", sequenceName = "SQ_IMPOSTO", allocationSize = 1)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ICM_ID", foreignKey = @ForeignKey(name = "FK_ICM_IMP"))
    @JsonProperty( "ICMS")
    public Icms icms;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IPI_ID", foreignKey = @ForeignKey(name = "FK_IPI_IMP"))
    @JsonProperty( "IPI")
    public Ipi ipi;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COF_ID", foreignKey = @ForeignKey(name = "FK_COF_IMP"))
    @JsonProperty( "COFINS")
    public Cofins cofins;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PIS_ID", foreignKey = @ForeignKey(name = "FK_PIS_IMP"))
    @JsonProperty( "PIS")
    public Pis pis;
}