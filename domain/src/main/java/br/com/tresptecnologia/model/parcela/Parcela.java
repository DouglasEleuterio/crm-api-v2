package br.com.tresptecnologia.model.parcela;

import br.com.tresptecnologia.shared.validation.Required;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Parcela {
    @Required
    private LocalDate data;
    @Required
    private Double valor;
}
