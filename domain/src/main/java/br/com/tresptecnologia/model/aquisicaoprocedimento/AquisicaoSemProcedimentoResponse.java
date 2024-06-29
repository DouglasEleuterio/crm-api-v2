package br.com.tresptecnologia.model.aquisicaoprocedimento;

import br.com.tresptecnologia.model.cliente.ClienteResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AquisicaoSemProcedimentoResponse {
    public Long id;
    public LocalDateTime dataAquisicao;
    public Double valorAquisicao;
    public Double valorDesconto;
    public ClienteResponse cliente;

}
