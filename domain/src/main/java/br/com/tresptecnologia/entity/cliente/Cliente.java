package br.com.tresptecnologia.entity.cliente;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Data
@Builder
public class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Endereco endereco;
    private LocalDate dataNascimento;
}
