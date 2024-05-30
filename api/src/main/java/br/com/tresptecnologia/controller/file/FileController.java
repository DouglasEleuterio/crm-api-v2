package br.com.tresptecnologia.controller.file;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.model.upload.AnexoUploadResponse;
import br.com.tresptecnologia.service.ParseService;
import br.com.tresptecnologia.service.upload.IUploadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/upload")
@Tag(name = "Upload de Arquivos")
public class FileController {

    private final IUploadService uploadService;
    private final ParseService parseService;

    public FileController(IUploadService uploadService, ParseService parseService) {
        this.uploadService = uploadService;
        this.parseService = parseService;
    }

    @PostMapping
    @Operation(description = "Enviar arquivo para Upload")
    public List<AnexoUploadResponse> upload(@RequestParam("file") MultipartFile[] file) throws DomainException {
        return uploadService.upload(Arrays.stream(file).toList());
    }

    @PostMapping("/list")
    @Operation(description = "Enviar arquivo para Upload")
    public List<AnexoUploadResponse> uploadList(@RequestParam("files") List<MultipartFile> file) throws DomainException {
        return uploadService.upload(file);
    }

    @GetMapping(path = "/quantidade")
    @Operation(description = "Retorna quantidade de Arquivos XML enviado")
    public Long getQuantidade() {
        return uploadService.getQuantiadeArquivosXML();
    }

}
