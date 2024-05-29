package br.com.tresptecnologia.model.tabelavaloresmonofasicosnf;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TabelaValoresMonofasicosNF {
        private String numeroNF;
        private String numeroNCM;
        private String nomeProduto;
        private Double pia_vpis;
        private Double cfa_vcofins;
        private Double prd_v_un_com;
        private Double prd_q_com;
        private Double prd_v_prod;
}
