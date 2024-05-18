package br.com.tresptecnologia.service.arquivo;

import br.com.tresptecnologia.entity.Arquivo;
import br.com.tresptecnologia.service.storage.IStorageService;
import br.com.tresptecnologia.service.storage.exception.StorageException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ApagarArquivoService implements IApagarArquivoService {

    private final IStorageService storageService;

    @Transactional(rollbackFor = Exception.class)
    public void apagarArquivo(Arquivo arquivo) throws StorageException {
        storageService.delete(arquivo.getBucket(), arquivo.getPath(), arquivo.getNome());
    }
}
