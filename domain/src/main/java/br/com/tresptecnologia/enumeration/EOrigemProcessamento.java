package br.com.tresptecnologia.enumeration;

import lombok.Getter;

@Getter
public enum EOrigemProcessamento {

    JOB("Job"),
    USUARIO("Usuário");

    private static String label;

    EOrigemProcessamento(String label) {
    }
}
