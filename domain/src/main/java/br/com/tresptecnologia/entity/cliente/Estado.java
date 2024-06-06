package br.com.tresptecnologia.entity.cliente;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Estado {

    private String nome;
    private String codigoIBGE;
    private String uf;

}
