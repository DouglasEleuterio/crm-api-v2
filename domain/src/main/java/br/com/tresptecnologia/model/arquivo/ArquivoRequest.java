package br.com.tresptecnologia.model.arquivo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArquivoRequest {

    private String id;
    private String nome;
    private String path;
    private String contentType;
    private long size;
    private String bucket;
    private String usuarioId;
    private String usuarioNome;
    private LocalDateTime dataCriacao;
}
