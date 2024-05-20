package br.com.tresptecnologia.model.xml.imposto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PisResponse {
    @JsonProperty(value = "pisaliq")
    public PISAliqResponse pisaliq;
}
