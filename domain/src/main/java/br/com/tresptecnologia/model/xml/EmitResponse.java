package br.com.tresptecnologia.model.xml;

import br.com.tresptecnologia.model.entity.BaseResponse;

public class EmitResponse implements BaseResponse {

    public Long id;
    public String CNPJ;
    public String xNome;
    public String xFant;
    public String IE;
    public String CRT;
    public EnderEmitResponse enderEmit;
}
