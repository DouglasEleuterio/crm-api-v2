package br.com.tresptecnologia.entity.notafiscal.imposto.ipi;

import br.com.tresptecnologia.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "IPT_IPITrib")
public class IPITrib extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_IPITrib")
    @Column(name = "IPT_ID", nullable = false)
    @SequenceGenerator(name = "SQ_IPITrib", sequenceName = "SQ_IPITrib", allocationSize = 1)
    private Long id;

    @Column(name = "IPT_CST")
    public String CST;

    @Column(name = "IPT_qUnid")
    public Integer qUnid;

    @Column(name = "IPT_vIPI")
    public Double vIPI;

    @Column(name = "IPT_vUnid")
    public Double vUnid;

}
