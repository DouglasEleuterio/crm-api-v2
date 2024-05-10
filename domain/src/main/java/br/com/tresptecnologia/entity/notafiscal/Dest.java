package br.com.tresptecnologia.entity.notafiscal;

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
import jakarta.persistence.ManyToOne;
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
@Table(name = "DST_DST")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dest extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DST")
    @SequenceGenerator(name = "SQ_DST", sequenceName = "SQ_DST", allocationSize = 1)
    @Column(name = "DST_ID", nullable = false)
    private Long id;

    @Column(name = "DST_CNPJ")
    public String CNPJ;
    @Column(name = "DST_xNome")
    public String xNome;
    @Column(name = "DST_indIEDest")
    public String indIEDest;
    @Column(name = "DST_IE")
    public String IE;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "END_ID", foreignKey = @ForeignKey(name = "FK_END_DST"))
    public EnderDest enderDest;
}
