package br.com.tresptecnologia.service.xml;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.report.ReportData;
import br.com.tresptecnologia.core.report.ReportType;
import br.com.tresptecnologia.core.service.BaseService;
import br.com.tresptecnologia.entity.notafiscal.XML;
import br.com.tresptecnologia.repository.xml.XmlRepository;
import br.com.tresptecnologia.service.storage.IStorageService;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class XmlService extends BaseService<XML> implements IXmlService {

    private final JsonMapper jsonMapper;
    private final IStorageService storageService;

    protected XmlService(XmlRepository repository, final JsonMapper jsonMapper, IStorageService storageService) {
        super(repository);
        this.jsonMapper = jsonMapper;
        this.storageService = storageService;
    }

    @Override
    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }

    @Override
    public ReportData downloadXmlFile(String id) throws DomainException, IOException {
        var xmlEntity = super.findById(Long.parseLong(id));

        var arquivoIS = storageService.get(xmlEntity.getArquivo().getBucket(), xmlEntity.getArquivo().getPath(), xmlEntity.getArquivo().getNome());

        return new ReportData(xmlEntity.getArquivo().getNome(), ReportType.XML, arquivoIS.readAllBytes());
    }
}
