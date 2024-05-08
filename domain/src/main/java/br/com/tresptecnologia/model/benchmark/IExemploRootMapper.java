package br.com.tresptecnologia.model.benchmark;

import br.com.tresptecnologia.entity.benchmark.ExemploRoot;
import br.com.tresptecnologia.core.mapper.IBaseResponseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IExemploRootMapper extends IBaseResponseMapper<ExemploRoot, ExemploRootBaseResponse> {

    ExemploRootWithManyIdResponse toMany(ExemploRoot entity);

}
