package br.com.tresptecnologia.entity;

import br.com.tresptecnologia.core.entity.BaseEntity;
import br.com.tresptecnologia.enumeration.EnumSituacaoArquivo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "arq_arquivo")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Arquivo extends BaseEntity {

    @Id
    @Column(name = "arq_id", nullable = false, length = 36)
    private Long id;

    @Column(name = "arq_nm_nome", nullable = false, length = 1000)
    private String nome;

    @Column(name = "arq_an_caminho", nullable = false, length = 1000)
    private String path;

    @Column(name = "arq_an_tipo_conteudo", nullable = false)
    private String contentType;

    @Column(name = "arq_nu_tamanho", nullable = false)
    private long size;

    @Column(name = "arq_an_pasta", nullable = false)
    private String bucket;

    @Column(name = "arq_cd_usuario")
    private String usuarioId;

    @Column(name = "arq_nm_usuario")
    private String usuarioNome;

    @Column(name = "arq_dh_criacao")
    private LocalDateTime dataCriacao;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "arq_cd_situacao", nullable = false, length = 20)
    private EnumSituacaoArquivo situacaoArquivo = EnumSituacaoArquivo.PENDENTE;

    public static Arquivo of(MultipartFile multipartFile, String bucket, String path) {
        return Arquivo.builder()
                .nome(multipartFile.getOriginalFilename())
                .contentType(multipartFile.getContentType())
                .size(multipartFile.getSize())
                .path(path)
                .bucket(bucket)
                .dataCriacao(LocalDateTime.now())
                .build();
    }
}
