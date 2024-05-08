package br.com.tresptecnologia.model.exemplo;

import br.com.tresptecnologia.model.exemplo.relacao.ExemploRelacaoResponse;
import br.com.tresptecnologia.core.jpa.annotation.JpaSelectMapper;
import br.com.tresptecnologia.model.entity.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JpaSelectMapper
public class ExemploResponse implements BaseResponse {

    private Long id;
    private String nome;
    private String descricao;
    private Boolean situacao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private ExemploRelacaoResponse relacao;

}