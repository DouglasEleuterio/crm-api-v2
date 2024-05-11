package br.com.tresptecnologia.enumeration;

import lombok.Getter;

@Getter
public enum ESituacaoFinalizacao {

    SUCESSO("Sucesso"),
    INATIVIDADE("Inatividade");

    private static String label;

    ESituacaoFinalizacao(String label) {
    }
}
