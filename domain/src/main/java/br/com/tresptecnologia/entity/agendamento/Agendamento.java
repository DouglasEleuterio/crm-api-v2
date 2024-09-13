package br.com.tresptecnologia.entity.agendamento;

import br.com.tresptecnologia.core.entity.BaseActiveEntity;
import br.com.tresptecnologia.entity.aquisicao.AquisicaoProcedimento;
import br.com.tresptecnologia.entity.profissional.Profissional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "agendamento")
public class Agendamento extends BaseActiveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_AGENDAMENTO")
    @SequenceGenerator(name = "SQ_AGENDAMENTO", sequenceName = "SQ_AGENDAMENTO", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "dia_todo", nullable = false)
    private Boolean allDay;
    @Column(name = "titulo", nullable = false)
    private String title;
    @Column(name = "inicio", nullable = false)
    private LocalDateTime start;
    @Column(name = "fim", nullable = false)
    private LocalDateTime end;
    @Column(name = "cor", nullable = false)
    private String backgroundColor;

    @Column(name = "confirmado", nullable = false)
    private boolean confirmado;

    @Column(name = "executado", nullable = false)
    private boolean executado;

    @ManyToOne
    @JoinColumn(name = "aquisicao_procedimento_id")
    private AquisicaoProcedimento aquisicaoProcedimento;

    @ManyToOne
    @JoinColumn(name = "profissional_id", nullable = false)
    private Profissional profissional;

    @Override
    public String toString() {
        return "Evento{" +
               "id=" + id +
               ", allDay=" + allDay +
               ", title='" + title + '\'' +
               ", start=" + start +
               ", end=" + end +
               ", backgroundColor='" + backgroundColor + '\'' +
               ", confirmado=" + confirmado +
               '}';
    }
}
