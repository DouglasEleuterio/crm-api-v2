package br.com.tresptecnologia.model.aquisicao;

import br.com.tresptecnologia.model.cliente.ClienteResponse;
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
public class AquisicaoClienteResponse implements BaseResponse {

    private ClienteResponse cliente;
}
