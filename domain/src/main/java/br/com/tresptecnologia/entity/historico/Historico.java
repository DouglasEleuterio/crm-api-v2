package br.com.tresptecnologia.entity.historico;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Historico {
    private EEvento tipoEvento;
    private LocalDateTime dataCcorrencia;
    private String idUsuario;
    private String nomeUsuario;
    private String idEntidadeGeradora;
}
