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
    public String vBC;
    @Column(name = "ICT_vICMS")
    public String vICMS;
    @Column(name = "ICT_vICMSDeson")
    public String vICMSDeson;
    @Column(name = "ICT_vFCP")
    public String vFCP;
    @Column(name = "ICT_vBCST")
    public String vBCST;
    @Column(name = "ICT_vST")
    public String vST;
    @Column(name = "ICT_vFCPST")
    public String vFCPST;
    @Column(name = "ICT_vFCPSTRet")
    public String vFCPSTRet;
    @Column(name = "ICT_vProd")
    public String vProd;
    @Column(name = "ICT_vFrete")
    public String vFrete;
    @Column(name = "ICT_vSeg")
    public String vSeg;
    @Column(name = "ICT_vDesc")
    public String vDesc;
    @Column(name = "ICT_vII")
    public String vII;
    @Column(name = "ICT_vIPI")
    public String vIPI;
    @Column(name = "ICT_vIPIDevol")
    public String vIPIDevol;
    @Column(name = "ICT_vPIS")
    public String vPIS;
    @Column(name = "ICT_vCOFINS")
    public String vCOFINS;
    @Column(name = "ICT_vOutro")
    public String vOutro;
    @Column(name = "ICT_vNF")
    public String vNF;
}
