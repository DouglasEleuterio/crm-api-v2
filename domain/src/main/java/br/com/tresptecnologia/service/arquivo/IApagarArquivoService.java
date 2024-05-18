package br.com.tresptecnologia.service.arquivo;

import br.com.tresptecnologia.entity.Arquivo;
import br.com.tresptecnologia.service.storage.exception.StorageException;

public interface IApagarArquivoService {
    void apagarArquivo(Arquivo arquivo) throws StorageException;
}
