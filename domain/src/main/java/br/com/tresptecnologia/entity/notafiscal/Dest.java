package br.com.tresptecnologia.entity.notafiscal;

import br.com.tresptecnologia.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
import jakarta.persistence.OneToOne;
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
@Table(name = "DST_DST")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dest extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DST")
    @SequenceGenerator(name = "SQ_DST", sequenceName = "SQ_DST", allocationSize = 1)
    @Column(name = "DST_ID", nullable = false)
    private Long id;

    @Column(name = "DST_CNPJ")
    @JsonProperty("CNPJ")
    public String cnpj;
    @Column(name = "DST_xNome")
    public String xNome;
    @Column(name = "DST_indIEDest")
    public String indIEDest;
    @Column(name = "DST_IE")
    @JsonProperty("IE")
    public String ie;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "END_ID", foreignKey = @ForeignKey(name = "FK_END_DST"))
    public EnderDest enderDest;

    @JsonBackReference
    @OneToOne(mappedBy = "dest", cascade = CascadeType.ALL)
    private InfNFe infNFe;

}
