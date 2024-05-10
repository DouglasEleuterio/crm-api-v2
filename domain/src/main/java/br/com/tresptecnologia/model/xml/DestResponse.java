package br.com.tresptecnologia.model.xml;

import br.com.tresptecnologia.model.entity.BaseResponse;

public class DestResponse implements BaseResponse {

    public Long id;
    public String CNPJ;
    public String xNome;
    public String indIEDest;
    public String IE;
    public EnderDestResponse enderDest;
}
