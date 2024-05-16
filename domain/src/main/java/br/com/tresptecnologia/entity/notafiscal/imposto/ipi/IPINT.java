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
@Table(name = "IPN_IPINT")
public class IPINT extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_IPINT")
    @Column(name = "IPN_ID", nullable = false)
    @SequenceGenerator(name = "SQ_IPINT", sequenceName = "SQ_IPINT", allocationSize = 1)
    private Long id;

    @Column(name = "IPN_CST")
    public String CST;
}
