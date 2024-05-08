package br.com.tresptecnologia.model.arquivo;

import br.com.tresptecnologia.core.mapper.IBaseMapper;
import br.com.tresptecnologia.entity.Arquivo;
import br.com.tresptecnologia.model.upload.ArquivoUploadResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArquivoMapper extends IBaseMapper<Arquivo, ArquivoUploadResponse, ArquivoRequest> {

}
