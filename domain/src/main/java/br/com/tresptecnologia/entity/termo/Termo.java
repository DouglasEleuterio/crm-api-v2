package br.com.tresptecnologia.entity.termo;

import br.com.tresptecnologia.core.entity.BaseActiveEntity;
import br.com.tresptecnologia.entity.documento.Documento;
import br.com.tresptecnologia.entity.procedimento.Procedimento;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "termo")
public class Termo extends BaseActiveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TERMO")
    @SequenceGenerator(name = "SQ_TERMO", sequenceName = "SQ_TERMO", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "versao", nullable = false)
    private Integer versao;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "documento_id", nullable = false, foreignKey = @ForeignKey(name = "FK_DOCUMENTO_IN_TERMO"))
    private Documento documento;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "procedimento_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PROCEDIMENTO_IN_TERMO"))
    private Procedimento procedimento;

}
