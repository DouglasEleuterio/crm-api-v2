package br.com.tresptecnologia.model.profissional;

import br.com.tresptecnologia.core.mapper.IBaseMapper;
import br.com.tresptecnologia.entity.profissional.Profissional;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfissionalMapper extends IBaseMapper<Profissional, ProfissionalRequest, ProfissionalResponse> {
}
