package br.com.tresptecnologia.service.upload;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.model.upload.AnexoUploadResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface IUploadService {
    AnexoUploadResponse upload(MultipartFile file) throws DomainException;

    List<AnexoUploadResponse> upload(List<MultipartFile> files) throws DomainException;

    Long getQuantiadeArquivosXML();
}
