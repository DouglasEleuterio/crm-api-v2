package br.com.tresptecnologia.model.cliente;

import br.com.tresptecnologia.model.base.BaseModel;
import br.com.tresptecnologia.shared.validation.RequiredSize;
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
public class ClienteRequest extends BaseModel {

    @RequiredSize(label = "cliente.nome", min = 2, max = 255)
    private String nome;

    @RequiredSize(label = "cliente.telefone", min = 11, max = 12)
    private String telefone;
}