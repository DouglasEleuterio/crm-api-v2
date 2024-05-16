package br.com.tresptecnologia.entity.notafiscal.imposto.icms;

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
@Table(name = "IC0_ICMS00")
public class Icms00 extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ICMS00")
    @Column(name = "IC0_ID", nullable = false)
    @SequenceGenerator(name = "SQ_ICMS00", sequenceName = "SQ_ICMS00", allocationSize = 1)
    private Long id;

    @Column(name = "IC0_orig")
    public String orig;

    @Column(name = "IC0_CST")
    public String CST;

    @Column(name = "IC0_modBC")
    public Integer modBC;

    @Column(name = "IC0_vBC")
    public Double vBC;

    @Column(name = "IC0_pICMS")
    public Double pICMS;

    @Column(name = "IC0_vICMS")
    public Double vICMS;
}
