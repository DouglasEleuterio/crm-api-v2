package br.com.tresptecnologia.model.xml;

import br.com.tresptecnologia.model.entity.BaseResponse;

import java.util.List;

public class InfNFeResponse implements BaseResponse {

    public String versao;
    public String id;
    public IdeResponse ide;
    public EmitResponse emit;
    public DestResponse dest;
    public List<DetResponse> det;
    public TotalResponse total;
    public InfAdicResponse infAdic;

}
