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
@Table(name = "EDT_ENDERECO_EMITENTE")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnderEmit extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EDT")
    @SequenceGenerator(name = "SQ_EDT", sequenceName = "SQ_EDT", allocationSize = 1)
    @Column(name = "EDT_ID", nullable = false)
    private Long id;

    @Column(name = "EDT_xLgr")
    public String xLgr;
    @Column(name = "EDT_nro")
    public String nro;
    @Column(name = "EDT_xBairro")
    public String xBairro;
    @Column(name = "EDT_cMun")
    public String cMun;
    @Column(name = "EDT_xMun")
    public String xMun;
    @Column(name = "EDT_UF")
    public String UF;
    @Column(name = "EDT_CEP")
    public String CEP;
    @Column(name = "EDT_cPais")
    public String cPais;
    @Column(name = "EDT_xPais")
    public String xPais;
    @Column(name = "EDT_fone")
    public String fone;
}
