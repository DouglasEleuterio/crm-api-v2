package br.com.tresptecnologia.entity.pagamento;

import lombok.Getter;

@Getter
public enum EFormaPagamento {
    CARTAO_DEBITO("Cartão Débito"), CARTAO_CREDITO("Cartão Crédito"), PIX("PIX"), ESPECIE("Especie"), BOLETO("Boleto");

    private final String label;

    EFormaPagamento(String label) {
        this.label = label;
    }
}
