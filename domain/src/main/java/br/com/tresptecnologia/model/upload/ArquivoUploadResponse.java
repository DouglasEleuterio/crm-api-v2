package br.com.tresptecnologia.model.upload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArquivoUploadResponse {
    private String id;
    private String nome;
    private String path;
    private String contentType;
    private long size;
    private String bucket;
    private LocalDateTime dataCriacao;

    public static ArquivoUploadResponse of(MultipartFile multipartFile, MiniIOProperties miniIOProperties) {
        return ArquivoUploadResponse.builder()
                .id(UUID.randomUUID().toString())
                .nome(multipartFile.getOriginalFilename())
                .contentType(multipartFile.getContentType())
                .size(multipartFile.getSize())
                .path(miniIOProperties.getPath())
                .bucket(miniIOProperties.getBucket())
                .dataCriacao(LocalDateTime.now())
                .build();
    }

}
