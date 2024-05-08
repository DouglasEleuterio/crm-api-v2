package br.com.tresptecnologia.model.benchmark;

import java.util.List;

public record ExemploRootWithManyIdResponse(
        String id,
        String nome,
        ExemploRootOneResponse filhoOne,
        List<ExemploRootManyResponse> filhosMany
) {
    record ExemploRootOneResponse(Long id, String descricao){}
    record ExemploRootManyResponse(Long id){}
}
