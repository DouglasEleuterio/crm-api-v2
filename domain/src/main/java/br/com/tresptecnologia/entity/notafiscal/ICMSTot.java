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
@Table(name = "ICT_ICMSTot")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ICMSTot extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ICT")
    @SequenceGenerator(name = "SQ_ICT", sequenceName = "SQ_ICT", allocationSize = 1)
    @Column(name = "ICT_ID", nullable = false)
    private Long id;

    @Column(name = "ICT_vBC")
    public Double vBC;
    @Column(name = "ICT_vICMS")
    public Double vICMS;
    @Column(name = "ICT_vICMSDeson")
    public Double vICMSDeson;
    @Column(name = "ICT_vFCP")
    public Double vFCP;
    @Column(name = "ICT_vBCST")
    public Double vBCST;
    @Column(name = "ICT_vST")
    public Double vST;
    @Column(name = "ICT_vFCPST")
    public Double vFCPST;
    @Column(name = "ICT_vFCPSTRet")
    public Double vFCPSTRet;
    @Column(name = "ICT_vProd")
    public Double vProd;
    @Column(name = "ICT_vFrete")
    public Double vFrete;
    @Column(name = "ICT_vSeg")
    public Double vSeg;
    @Column(name = "ICT_vDesc")
    public Double vDesc;
    @Column(name = "ICT_vII")
    public Double vII;
    @Column(name = "ICT_vIPI")
    public Double vIPI;
    @Column(name = "ICT_vIPIDevol")
    public Double vIPIDevol;
    @Column(name = "ICT_vPIS")
    public Double vPIS;
    @Column(name = "ICT_vCOFINS")
    public Double vCOFINS;
    @Column(name = "ICT_vOutro")
    public Double vOutro;
    @Column(name = "ICT_vNF")
    public Double vNF;
}
