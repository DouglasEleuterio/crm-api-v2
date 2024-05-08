package br.com.tresptecnologia.model.produto;


import br.com.tresptecnologia.model.base.BaseModel;
import br.com.tresptecnologia.shared.validation.Required;
import br.com.tresptecnologia.shared.validation.RequiredSize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoRequest extends BaseModel {
    @RequiredSize(label = "produto.nome", min = 2, max = 255)
    private String nome;

    @Required(label = "produto.preco")
    private Double preco;
}
