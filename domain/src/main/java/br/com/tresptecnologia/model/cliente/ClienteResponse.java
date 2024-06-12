package br.com.tresptecnologia.model.cliente;

import br.com.tresptecnologia.entity.cliente.Endereco;
import br.com.tresptecnologia.model.endereco.EnderecoResponse;
import br.com.tresptecnologia.model.entity.BaseResponse;
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
public class ClienteResponse implements BaseResponse {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private EnderecoResponse endereco;
    private LocalDate dataNascimento;
}
