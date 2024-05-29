package br.com.tresptecnologia.model.produto;

import java.time.LocalDate;

class Ide {
    public String cUF;
    public String cNF;
    public String natOp;
    public String mod;
    public String serie;
    public Long nNF;
    private LocalDate dhEmiDT;
    public String dhEmi;
    public String dhSaiEnt;
    public String tpNF;
    public String idDest;
    public String cMunFG;
    public String tpImp;
    public String tpEmis;
    public String cDV;
    public String tpAmb;
    public String finNFe;
    public String indFinal;
    public String indPres;
    public String indInterme;
    public String procEmi;
    public String verProc;
}

class Emit {
    public String cnpj;
    public String xNome;
    public String xFant;
    public String ie;
    public String crt;
}

class Dest {
    public String cnpj;
    public String xNome;
    public String indIEDest;
    public String ie;
}

class InfNFe {
    public Ide ide;
    public Emit emit;
    public Dest dest;

}

class COFINSAliq {
    public Double vCOFINS;
    public String cst;
    public Double vBC;
    public Double pCOFINS;
}

class Cofins {
    public COFINSAliq cofinsaliq;
}

class PISAliq {
    public Double vPIS;
    public String cst;
    public Double vBC;
    public Double pPIS;
}

class Pis {
    public PISAliq pisaliq;
}

class Imposto {
    public Cofins cofins;
    public Pis pis;
}

class Det {
    public Imposto imposto;
    public InfNFe infnf;
}

public class ProdIncidenciaMonoResponse {

    public String cProd;
    public String cEAN;
    public String xProd;
    public String ncm;
    public String cfop;
    public String uCom;
    public String qCom;
    public String vUnCom;
    public String vProd;
    public String cEANTrib;
    public String uTrib;
    public String qTrib;
    public String vUnTrib;
    public String indTot;
    public Det det;
}
