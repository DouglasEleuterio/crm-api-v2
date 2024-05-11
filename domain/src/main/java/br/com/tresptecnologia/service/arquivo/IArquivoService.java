package br.com.tresptecnologia.service.arquivo;

import br.com.tresptecnologia.entity.Arquivo;

import java.util.List;

public interface IArquivoService {

    List<Arquivo> getAllNaoProcessado();
}
