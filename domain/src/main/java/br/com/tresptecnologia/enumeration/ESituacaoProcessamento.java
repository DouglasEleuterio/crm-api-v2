package br.com.tresptecnologia.enumeration;

import lombok.Getter;

@Getter
public enum ESituacaoProcessamento {

    FINALIZADO("Finalizado"),
    PROCESSANDO("Processando");

    private static String label;

    ESituacaoProcessamento(String label) {
    }
}
