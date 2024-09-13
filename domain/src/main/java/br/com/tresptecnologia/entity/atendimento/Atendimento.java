package br.com.tresptecnologia.entity.atendimento;

import br.com.tresptecnologia.core.entity.BaseActiveEntity;
import br.com.tresptecnologia.entity.Arquivo;
import br.com.tresptecnologia.entity.agendamento.Agendamento;
import br.com.tresptecnologia.entity.profissional.Profissional;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    @JoinColumn(name = "arquivo_id", foreignKey = @ForeignKey(name = "arquivo_on_atendimento"))
    private Arquivo observacao;

    @ManyToOne
    @JoinColumn(name = "agendamento_id", foreignKey = @ForeignKey(name = "agendamento_on_atendimento"))
    private Agendamento agendamentos;

    @OneToMany
    @JoinColumn(name = "profissional_id", foreignKey = @ForeignKey(name = "profissional_on_atendimento"))
    private List<Profissional> profissionais;
}
