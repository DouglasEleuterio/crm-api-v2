package br.com.tresptecnologia.entity.aquisicao;

import br.com.tresptecnologia.entity.Cliente;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class Aquisicao {
    private LocalDateTime dataAquisicao;
    private Double valorAquisicao;
    private Double valorDesconto;
    private Cliente cliente;
    private AquisicaoProcedimento aquisicaoProcedimento;
}
