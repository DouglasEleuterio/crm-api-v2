package br.com.tresptecnologia.entity.historico;

import br.com.tresptecnologia.core.entity.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "auditoria")
public class Auditoria extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_AUDITORIA")
    @SequenceGenerator(name = "SQ_AUDITORIA", sequenceName = "SQ_AUDITORIA", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "situacao_registro", nullable = false)
    private ESituacaoRegistro situacaoRegistro;
    @Column(name = "dado", nullable = false, length = 2000)
    private String dado;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "historico_id")
    private Historico historico;
}
