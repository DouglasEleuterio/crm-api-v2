package br.com.tresptecnologia.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(name="BaseEntityReesponse", description="Modelo padrão para representar o id de um determinado registro.")
public class BaseEntityResponse {

    private Long id;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

}
