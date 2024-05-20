package br.com.tresptecnologia.entity.notafiscal;

import br.com.tresptecnologia.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "INF_INFNFE")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InfNFe extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_INF")
    @SequenceGenerator(name = "SQ_INF", sequenceName = "SQ_INF", allocationSize = 1)
    @Column(name = "INF_ID", nullable = false)
    private Long id;

    @Column(name = "INF_VERSAO")
    public String versao;

    @Column(name = "INF_IDNF")
    public String idnf;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDE_ID", foreignKey = @ForeignKey(name = "FK_IDE_INF"))
    public Ide ide;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EMT_ID", foreignKey = @ForeignKey(name = "FK_EMT_INF"))
    public Emit emit;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DST_ID", foreignKey = @ForeignKey(name = "FK_DST_INF"))
    public Dest dest;

    @JacksonXmlElementWrapper(useWrapping = false)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infnf", orphanRemoval = true)
    public List<Det> det;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TOT_ID", foreignKey = @ForeignKey(name = "FK_TOT_INF"))
    public Total total;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IFD_ID", foreignKey = @ForeignKey(name = "FK_IFD_INF"))
    public InfAdic infAdic;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COB_ID", foreignKey = @ForeignKey(name = "FK_COB_INF"))
    public Cobr cobr;

    public void setDet(List<Det> det) {
        this.det = det;
        this.det.forEach(d -> d.setInfnf(this));
    }
}
