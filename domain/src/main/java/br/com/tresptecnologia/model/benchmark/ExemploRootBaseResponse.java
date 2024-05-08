package br.com.tresptecnologia.model.benchmark;

import br.com.tresptecnologia.model.exemplo.ExemploListResponse;

import java.util.List;

public record ExemploRootBaseResponse(
        String id,
        String nome,
        List<ExemploListResponse> responses
) {
}
