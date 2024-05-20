package br.com.tresptecnologia.model.xml;

import br.com.tresptecnologia.model.entity.BaseResponse;

public class EmitResponse implements BaseResponse {

    public Long id;
    public String cnpj;
    public String xNome;
    public String xFant;
    public String ie;
    public String crt;
    public EnderEmitResponse enderEmit;
}
