package br.com.tresptecnologia.model.xml;

import br.com.tresptecnologia.entity.notafiscal.imposto.icms.Icms;
import br.com.tresptecnologia.entity.notafiscal.imposto.ipi.Ipi;
import br.com.tresptecnologia.model.xml.imposto.CofinsResponse;
import br.com.tresptecnologia.model.xml.imposto.IcmsResponse;
import br.com.tresptecnologia.model.xml.imposto.PisResponse;

public class ImpostoResponse {

    public IcmsResponse icms;
    public Ipi ipi;
    public CofinsResponse cofins;
    public PisResponse pis;
}
