package br.com.tresptecnologia.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumSituacaoArquivo {

    PENDENTE,
    ATIVO,
    MARCADO_PARA_EXPURGO,
    ERRO_EXPURGO
}
