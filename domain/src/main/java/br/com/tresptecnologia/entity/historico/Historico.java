package br.com.tresptecnologia.entity.historico;

import br.com.tresptecnologia.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

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

    @OneToMany(mappedBy = "historico", cascade = CascadeType.ALL)
    private Set<Auditoria> auditorias;
}
