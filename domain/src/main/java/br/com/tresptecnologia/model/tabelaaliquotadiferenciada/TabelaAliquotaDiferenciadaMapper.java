package br.com.tresptecnologia.model.tabelaaliquotadiferenciada;

import br.com.tresptecnologia.core.mapper.IBaseMapper;
import br.com.tresptecnologia.entity.TabelaAliquotaDiferenciada;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TabelaAliquotaDiferenciadaMapper extends IBaseMapper<TabelaAliquotaDiferenciada, TabelaAliquotaDiferenciadaRequest, TabelaAliquotaDiferenciadaResponse > {
}
