package br.com.tresptecnologia.shared.util;

import java.util.UUID;

public class NomeArquivoUtils {

    public static String getExtension(String documentName) {
        // retorna a extensão com ponto Ex.: '.pdf'
        return documentName.substring(documentName.lastIndexOf('.'));
    }

    public static String getName(String documentName) {
        return documentName.substring(0, documentName.lastIndexOf('.'));
    }

    public static String getNovoNomeOriginal(String documentName) {
        return UUID.randomUUID().toString().concat(getExtension(documentName));
    }
}
