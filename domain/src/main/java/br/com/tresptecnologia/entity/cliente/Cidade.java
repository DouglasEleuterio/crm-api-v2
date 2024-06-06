package br.com.tresptecnologia.entity.cliente;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cidade {

    private String nome;
    private Estado estado;
    private String codigoIBGE;
}
