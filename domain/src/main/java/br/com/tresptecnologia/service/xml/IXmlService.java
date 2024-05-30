package br.com.tresptecnologia.service.xml;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.report.ReportData;
import br.com.tresptecnologia.core.service.IBaseFetchMapperService;
import br.com.tresptecnologia.core.service.IBaseService;
import br.com.tresptecnologia.entity.notafiscal.XML;

import java.io.IOException;

public interface IXmlService extends IBaseService<XML>, IBaseFetchMapperService<XML> {
    ReportData downloadXmlFile(String id) throws DomainException, IOException;

    Long getQuantiadeXml();
}
