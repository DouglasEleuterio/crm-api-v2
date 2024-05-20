package br.com.tresptecnologia.entity.notafiscal;

import br.com.tresptecnologia.core.entity.BaseEntity;
import br.com.tresptecnologia.entity.Arquivo;
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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "XML_XML")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class XML extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_XML")
    @SequenceGenerator(name = "SQ_XML", sequenceName = "SQ_XML", allocationSize = 1)
    @Column(name = "XML_ID", nullable = false)
    private Long id;

    @Column(name = "XML_VERSAO")
    public String versao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NFE_ID", foreignKey = @ForeignKey(name = "XML_NFE_XML"))
    @JsonProperty("NFe")
    public NFe nfe;

    @JoinColumn(name = "ARQ_ID", foreignKey = @ForeignKey(name = "XML_ARQ_XML"))
    @OneToOne(cascade = CascadeType.ALL)
    public Arquivo arquivo;

//    public String protNFe;
}
