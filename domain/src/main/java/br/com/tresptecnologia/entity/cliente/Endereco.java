package br.com.tresptecnologia.entity.cliente;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Endereco {
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private Cidade cidade;
    private String cep;
}
