package br.com.tresptecnologia.model.exemplo;

import br.com.tresptecnologia.model.entity.BaseResponse;

public record ExemploListResponse(Long id, String nome, String relacaoNome) implements BaseResponse {

    public static ExemploListResponse of(Long id, String nome, String relacaoNome) {
        return new ExemploListResponse(id, nome, relacaoNome);
    }

}
