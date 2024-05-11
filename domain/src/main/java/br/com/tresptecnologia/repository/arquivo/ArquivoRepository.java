package br.com.tresptecnologia.repository.arquivo;

import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.entity.Arquivo;
import br.com.tresptecnologia.enumeration.EnumSituacaoArquivo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArquivoRepository extends BaseRepository<Arquivo> {

//    @Query(value = "from Arquivo arq where arq.situacaoArquivo =:situacao")
    List<Arquivo> findAllBySituacaoArquivo(EnumSituacaoArquivo situacaoArquivo);
}
