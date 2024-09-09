package br.com.tresptecnologia.repository.termo;

import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.entity.termo.Termo;

public interface TermoRepository extends BaseRepository<Termo> {

    Integer countByProcedimento_Id(long procedimento_id);
}