package br.com.tresptecnologia.entity.atendimento;

import br.com.tresptecnologia.core.entity.BaseActiveEntity;
import br.com.tresptecnologia.entity.agendamento.Agendamento;
import br.com.tresptecnologia.entity.documento.Documento;
import br.com.tresptecnologia.entity.profissional.Profissional;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "atendimento")
public class Atendimento extends BaseActiveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ATENDIMENTO")
    @SequenceGenerator(name = "SQ_ATENDIMENTO", sequenceName = "SQ_ATENDIMENTO", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "data", nullable = false)
    private LocalDateTime data;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "documento_id", foreignKey = @ForeignKey(name = "fk_arquivo_on_atendimento"))
    private Documento observacao;

    @ManyToOne
    @JoinColumn(name = "agendamento_id", foreignKey = @ForeignKey(name = "fk_agendamento_on_atendimento"))
    private Agendamento agendamento;

    @ManyToMany
    @JoinTable(name = "profissional_atendimento",
            joinColumns = @JoinColumn(name = "atendimento_id", nullable = false, foreignKey = @ForeignKey(name = "fk_atendimento_on_profissional_atendimento")),
            inverseJoinColumns = @JoinColumn(name = "profissional_id", nullable = false, foreignKey = @ForeignKey(name = "fk_profissional_on_profissional_atendimento")))
    private List<Profissional> profissionais;
}
