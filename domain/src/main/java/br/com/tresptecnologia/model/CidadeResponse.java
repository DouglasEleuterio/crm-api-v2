package br.com.tresptecnologia.model;

import br.com.tresptecnologia.entity.cliente.Estado;
import br.com.tresptecnologia.model.entity.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CidadeResponse implements BaseResponse {

    private Long id;
    private String nome;
    private Estado estado;
    private String codigoIBGE;
}
