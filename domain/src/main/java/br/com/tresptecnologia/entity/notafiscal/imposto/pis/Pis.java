package br.com.tresptecnologia.entity.notafiscal.imposto.pis;

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
@Table(name = "PIS_PIS")
public class Pis extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PIS")
    @Column(name = "PIS_ID", nullable = false)
    @SequenceGenerator(name = "SQ_PIS", sequenceName = "SQ_PIS", allocationSize = 1)
    private Long id;

    @JoinColumn(name = "PIA_ID", foreignKey = @ForeignKey(name = "FK_PIA_PIS"))
    @OneToOne(cascade = CascadeType.ALL)
    private PISAliq PISAliq;
}
