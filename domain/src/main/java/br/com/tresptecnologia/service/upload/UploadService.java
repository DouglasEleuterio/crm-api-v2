package br.com.tresptecnologia.service.upload;

import br.com.tresptecnologia.core.audit.AuditRevisionInfo;
import br.com.tresptecnologia.core.config.ApplicationProperties;
import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.message.Message;
import br.com.tresptecnologia.enumeration.EnumSituacaoArquivo;
import br.com.tresptecnologia.model.arquivo.ArquivoMapper;
import br.com.tresptecnologia.model.upload.AnexoUploadResponse;
import br.com.tresptecnologia.model.upload.ArquivoUploadResponse;
import br.com.tresptecnologia.repository.arquivo.ArquivoRepository;
import br.com.tresptecnologia.service.storage.IStorageService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class UploadService implements IUploadService {

    private final IStorageService storageService;
    private final ApplicationProperties applicationProperties;
    private final ArquivoRepository arquivoRepository;
    private final ArquivoMapper arquivoMapper;

    public UploadService(final IStorageService storageService,
                         final ApplicationProperties applicationProperties,
                         final ArquivoRepository arquivoRepository,
                         final ArquivoMapper arquivoMapper) {
        this.storageService = storageService;
        this.applicationProperties = applicationProperties;
        this.arquivoRepository = arquivoRepository;
        this.arquivoMapper = arquivoMapper;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public AnexoUploadResponse upload(MultipartFile file) throws DomainException {
        validarAnexo(file);
        var userInfo = AuditRevisionInfo.obterInfo();
        try {
            log.debug("Iniciando o envio do arquivo ao MinIO");

            final var arquivoResponse = ArquivoUploadResponse.of(file, applicationProperties.getMiniIOProperties());
            var nomeOriginal = file.getOriginalFilename();

            storageService.upload(applicationProperties.getMiniIOProperties().getBucket(),
                    applicationProperties.getMiniIOProperties().getPath(),
                    nomeOriginal, arquivoResponse.getContentType(), arquivoResponse.getSize(), file.getInputStream());

            log.debug("Finalizado o envio do arquivo ao MinIO");

            var toSave = arquivoMapper.fromRequest(arquivoResponse);
            toSave.setNome(nomeOriginal);
            toSave.setUsuarioId(userInfo.getUserId());
            toSave.setUsuarioNome(userInfo.getUserName());
            toSave.setSituacaoArquivo(EnumSituacaoArquivo.PENDENTE);

            arquivoRepository.save(toSave);

            return AnexoUploadResponse.builder().arquivo(arquivoMapper.toRequest(toSave)).build();
        } catch (DomainException ex) {
            throw ex;
        } catch (Exception ex) {
            log.debug("Falha ao realizar o envio do arquivo");
            throw new DomainException(ex.getMessage());
        }
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public List<AnexoUploadResponse> upload(List<MultipartFile> files) throws DomainException {
        var filesList = new ArrayList<AnexoUploadResponse>();
        for (MultipartFile file : files) {
            filesList.add(upload(file));
        }

        return filesList;
    }

    @Override
    public Long getQuantiadeArquivosXML() {
        return arquivoRepository.count();
    }

    //todo: Validar se arquivo é xml
    private void validarAnexo(MultipartFile file) throws DomainException {
        if (file.getSize() > applicationProperties.getTamanhoMaximoAnexo()) {
            throw new DomainException(Message.toLocale("error-tamanho-anexo"));
        }
        if (Objects.nonNull(file.getContentType()) && !file.getContentType().equals("text/xml"))
            throw new DomainException(Message.toLocale("error-tipo-arquivo-anexo"));
    }

}
