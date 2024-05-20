package br.com.tresptecnologia.model.xml;

import br.com.tresptecnologia.entity.notafiscal.imposto.cofins.Cofins;
import br.com.tresptecnologia.entity.notafiscal.imposto.icms.Icms;
import br.com.tresptecnologia.entity.notafiscal.imposto.ipi.Ipi;
import br.com.tresptecnologia.entity.notafiscal.imposto.pis.Pis;

public class ImpostoResponse {

    public Icms icms;
    public Ipi ipi;
    public Cofins cofins;
    public Pis pis;
}
