package br.com.tresptecnologia.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumSituacaoArquivo {

    PENDENTE("Pendente"),
    PROCESSADO("Processado"),
    ERRO_NO_PROCESSAMENTO("Erro no processamento");

    private static String label;

    EnumSituacaoArquivo(String label) {
    }
}
