package br.com.tresptecnologia.service.xml;

import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.service.BaseService;
import br.com.tresptecnologia.entity.notafiscal.XML;
import br.com.tresptecnologia.repository.xml.XmlRepository;
import org.springframework.stereotype.Service;

@Service
public class XmlService extends BaseService<XML> implements IXmlService {

    private final JsonMapper jsonMapper;

    protected XmlService(XmlRepository repository, final JsonMapper jsonMapper) {
        super(repository);
        this.jsonMapper = jsonMapper;

    }

    @Override
    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }

}
