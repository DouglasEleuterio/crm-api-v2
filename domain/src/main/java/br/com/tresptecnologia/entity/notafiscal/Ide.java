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
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "IDE_IDE")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
public class Ide extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_IDE")
    @SequenceGenerator(name = "SQ_IDE", sequenceName = "SQ_IDE", allocationSize = 1)
    @Column(name = "IDE_ID", nullable = false)
    private Long id;

    @Column(name = "IDE_cUF")
    public String cUF;
    @Column(name = "IDE_cNF")
    public String cNF;
    @Column(name = "IDE_natOp")
    public String natOp;
    @Column(name = "IDE_mod")
    public String mod;
    @Column(name = "IDE_serie")
    public String serie;
    @Column(name = "IDE_nNF")
    public Long nNF;
    @Column(name = "IDE_dhEmi")
    private String dhEmi;
    @Column(name = "IDE_dhEmiDT")
    private LocalDate dhEmiDT;
    @Column(name = "IDE_dhSaiEnt")
    public String dhSaiEnt;
    @Column(name = "IDE_tpNF")
    public String tpNF;
    @Column(name = "IDE_idDest")
    public String idDest;
    @Column(name = "IDE_cMunFG")
    public String cMunFG;
    @Column(name = "IDE_tpImp")
    public String tpImp;
    @Column(name = "IDE_tpEmis")
    public String tpEmis;
    @Column(name = "IDE_cDV")
    public String cDV;
    @Column(name = "IDE_tpAmb")
    public String tpAmb;
    @Column(name = "IDE_finNFe")
    public String finNFe;
    @Column(name = "IDE_indFinal")
    public String indFinal;
    @Column(name = "IDE_indPres")
    public String indPres;
    @Column(name = "IDE_indInterme")
    public String indInterme;
    @Column(name = "IDE_procEmi")
    public String procEmi;
    @Column(name = "IDE_verProc")
    public String verProc;
}
