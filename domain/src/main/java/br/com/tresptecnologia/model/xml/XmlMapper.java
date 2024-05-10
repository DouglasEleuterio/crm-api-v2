package br.com.tresptecnologia.model.xml;

import br.com.tresptecnologia.core.mapper.IBaseResponseMapper;
import br.com.tresptecnologia.entity.notafiscal.XML;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface XmlMapper extends IBaseResponseMapper<XML, XmlResponse> {
}
