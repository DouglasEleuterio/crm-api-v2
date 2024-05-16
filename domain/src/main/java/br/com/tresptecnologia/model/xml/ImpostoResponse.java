package br.com.tresptecnologia.model.xml;

import br.com.tresptecnologia.entity.notafiscal.imposto.cofins.Cofins;
import br.com.tresptecnologia.entity.notafiscal.imposto.icms.Icms;
import br.com.tresptecnologia.entity.notafiscal.imposto.ipi.Ipi;
import br.com.tresptecnologia.entity.notafiscal.imposto.pis.Pis;

public class ImpostoResponse {

    public Icms ICMS;
    public Ipi IPI;
    public Cofins COFINS;
    public Pis PIS;
}
