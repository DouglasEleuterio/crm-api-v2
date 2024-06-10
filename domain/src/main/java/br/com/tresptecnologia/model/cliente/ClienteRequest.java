package br.com.tresptecnologia.model.cliente;

import br.com.tresptecnologia.entity.cliente.Endereco;
import br.com.tresptecnologia.shared.validation.Required;
import br.com.tresptecnologia.shared.validation.RequiredSize;
import br.com.tresptecnologia.shared.validation.RequiredType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {

    private Long id;

    @RequiredSize(label = "cliente.nome", min = 2, max = 255)
    private String nome;

    @RequiredSize(label = "cliente.telefone", min = 11, max = 12)
    private String telefone;

    @RequiredSize(label = "cliente.cpf", min = 11)
    private String cpf;

    @RequiredSize(label = "cliente.email", min = 5)
    private String email;

    @RequiredSize(label = "cliente.data-nascimento", min = 5)
    private LocalDate dataNascimento;

    @Required(label = "endereco", type = RequiredType.ALL)
    private Endereco endereco;

    private Boolean situacao;
}