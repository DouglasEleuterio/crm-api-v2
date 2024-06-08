package br.com.tresptecnologia.entity.historico;

import br.com.tresptecnologia.core.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "historico")
public class Historico extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_HISTORICO")
    @SequenceGenerator(name = "SQ_HISTORICO", sequenceName = "SQ_HISTORICO", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento")
    private EEvento tipoEvento;
    @Column(name = "data_ocorrencia", nullable = false)
    private LocalDateTime dataOcorrencia;
    @Column(name = "usuario_id", nullable = false)
    private String idUsuario;
    @Column(name = "usuario_nome", nullable = false)
    private String nomeUsuario;
    @Column(name = "entidade_geradora_id")
    private Long idEntidadeGeradora;
    @Column(name = "tipo_entidade", nullable = false)
    @Enumerated(EnumType.STRING)
    private ETipoEntidade tipoEntidade;
}
