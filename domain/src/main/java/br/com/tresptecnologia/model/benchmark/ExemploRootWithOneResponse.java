package br.com.tresptecnologia.model.benchmark;

public record ExemploRootWithOneResponse(
        Long id,
        String nome,
        ExemploRootOneResponse filhoOne
) {
    record ExemploRootOneResponse(Long id, String descricao){}
}
