package br.com.tresptecnologia.model.xml;

import br.com.tresptecnologia.core.mapper.IBaseResponseMapper;
import br.com.tresptecnologia.entity.notafiscal.XML;
import br.com.tresptecnologia.model.xml.table.XmlTable;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface XmlMapper extends IBaseResponseMapper<XML, XmlResponse> {

    XmlTable toTableResponse(XML entity);
}
