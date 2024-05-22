package br.com.tresptecnologia.enumeration;

import lombok.Getter;

@Getter
public enum EnumSituacao {
    ATIVO("Ativo"), INATIVO("Inativo");

    private static String descricao;

    EnumSituacao(String inativo) {

    }
}
