package br.com.tresptecnologia.model.xml.imposto;

import br.com.tresptecnologia.entity.notafiscal.imposto.cofins.COFINSAliq;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CofinsResponse {
    @JsonProperty(value = "cofinsaliq")
    public COFINSAliq cofinsaliq;
}
