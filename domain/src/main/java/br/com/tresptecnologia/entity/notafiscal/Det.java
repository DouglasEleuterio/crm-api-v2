package br.com.tresptecnologia.entity.notafiscal;

import br.com.tresptecnologia.core.entity.BaseEntity;
import br.com.tresptecnologia.entity.notafiscal.imposto.Imposto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "DET_DET")
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Det extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DET")
    @SequenceGenerator(name = "SQ_DET", sequenceName = "SQ_DET", allocationSize = 1)
    @Column(name = "DET_ID", nullable = false)
    private Long id;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "INF_ID", foreignKey = @ForeignKey(name = "FK_INF_DET"))
    private InfNFe infNFe;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRD_ID", foreignKey = @ForeignKey(name = "FK_PRD_DET"))
    public Prod prod ;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IMP_ID", foreignKey = @ForeignKey(name = "FK_IMP_DET"))
    public Imposto imposto ;
}
