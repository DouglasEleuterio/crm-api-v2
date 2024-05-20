package br.com.tresptecnologia.entity.notafiscal;

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
import jakarta.persistence.ManyToOne;
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
@Table(name = "EMT_EMT")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
public class Emit extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EMT")
    @SequenceGenerator(name = "SQ_EMT", sequenceName = "SQ_EMT", allocationSize = 1)
    @Column(name = "EMT_ID", nullable = false)
    private Long id;

    @Column(name = "EMT_CNPJ")
    @JsonProperty("CNPJ")
    public String cnpj;
    @Column(name = "EMT_xNome")
    public String xNome;
    @Column(name = "EMT_xFant")
    public String xFant;
    @Column(name = "EMT_IE")
    @JsonProperty("IE")
    public String ie;
    @Column(name = "EMT_CRT")
    @JsonProperty("CRT")
    public String crt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EDT_ID", foreignKey = @ForeignKey(name = "FK_EDT_EMT"))
    public EnderEmit enderEmit;

}
