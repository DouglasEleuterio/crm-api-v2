package br.com.tresptecnologia.entity.notafiscal;

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
@Table(name = "END_DST")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnderDest extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_END")
    @SequenceGenerator(name = "SQ_END", sequenceName = "SQ_END", allocationSize = 1)
    @Column(name = "END_ID", nullable = false)
    private Long id;

    @Column(name = "END_xLgr")
    public String xLgr;
    @Column(name = "END_nro")
    public String nro;
    @Column(name = "END_xCpl")
    public String xCpl;
    @Column(name = "END_xBairro")
    public String xBairro;
    @Column(name = "END_cMun")
    public String cMun;
    @Column(name = "END_xMun")
    public String xMun;
    @Column(name = "END_UF")
    public String UF;
    @Column(name = "END_CEP")
    public String CEP;
    @Column(name = "END_cPais")
    public String cPais;
    @Column(name = "END_xPais")
    public String xPais;
    @Column(name = "END_fone")
    public String fone;
}
