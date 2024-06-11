package br.com.tresptecnologia.model.endereco;

import br.com.tresptecnologia.model.entity.BaseEntityRequest;
import br.com.tresptecnologia.shared.validation.Required;
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
public class EnderecoRequest {

    private Long id;
    @Required(label = "endereco.logradouro")
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    @Required(label = "endereco.cidade")
    private BaseEntityRequest cidade;
    @Required(label = "endereco.cep")
    private String cep;
}
