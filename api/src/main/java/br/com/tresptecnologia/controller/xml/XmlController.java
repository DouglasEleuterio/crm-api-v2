package br.com.tresptecnologia.controller.xml;

import br.com.tresptecnologia.core.controller.BaseJsonSelectController;
import br.com.tresptecnologia.core.controller.BaseRsqlFindController;
import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.entity.notafiscal.XML;
import br.com.tresptecnologia.model.xml.XmlMapper;
import br.com.tresptecnologia.model.xml.XmlResponse;
import br.com.tresptecnologia.service.xml.IXmlService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xml")
@Tag(name = "XML")
public class XmlController extends BaseRsqlFindController<XML, XmlResponse> implements BaseJsonSelectController<XML> {


    protected XmlController(IXmlService service,
                            XmlMapper mapper, IXmlService service1) {
        super(service, mapper);
    }

    @Override
    public IXmlService getService() {
        return (IXmlService) super.getService();
    }

    @GetMapping(path = "/json/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public XML getXml(@PathVariable(name = "id") Long id) throws DomainException {
        return getService().findById(id);
    }
}
