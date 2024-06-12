package br.com.tresptecnologia.model.endereco;

import br.com.tresptecnologia.entity.cliente.Cidade;
import br.com.tresptecnologia.model.entity.BaseResponse;
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
public class EnderecoResponse implements BaseResponse {

    private Long id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private Cidade cidade;
    private String cep;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
}
