package br.com.tresptecnologia.model.upload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnexoUploadResponse {

    private String id;
    private ArquivoUploadResponse arquivo;
}
