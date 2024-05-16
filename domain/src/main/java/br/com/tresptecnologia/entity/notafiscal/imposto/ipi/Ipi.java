package br.com.tresptecnologia.entity.notafiscal.imposto.ipi;

import br.com.tresptecnologia.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "IPI_IPI")
public class Ipi extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_IPI")
    @Column(name = "IPI_ID", nullable = false)
    @SequenceGenerator(name = "SQ_IPI", sequenceName = "SQ_IPI", allocationSize = 1)
    private Long id;

    @Column(name = "IC6_cEnq")
    public String cEnq;

    @JoinColumn(name = "IPT_ID", foreignKey = @ForeignKey(name = "FK_IPT_IPI"))
    @OneToOne(cascade = CascadeType.ALL)
    private IPITrib IPITrib;

    @JoinColumn(name = "IPN_ID", foreignKey = @ForeignKey(name = "FK_IPN_IPI"))
    @OneToOne(cascade = CascadeType.ALL)
    public IPINT IPINT;
}
