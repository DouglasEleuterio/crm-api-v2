package br.com.tresptecnologia.controller.xml;

import br.com.tresptecnologia.core.controller.BaseJsonSelectController;
import br.com.tresptecnologia.core.controller.BaseRsqlFindController;
import br.com.tresptecnologia.core.controller.constants.BaseControllerConstants;
import br.com.tresptecnologia.core.controller.swagger.annotation.SwaggerGenericResponseType;
import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.jpa.util.SpecificationUtils;
import br.com.tresptecnologia.entity.notafiscal.XML;
import br.com.tresptecnologia.model.entity.BaseResponse;
import br.com.tresptecnologia.model.xml.XmlMapper;
import br.com.tresptecnologia.model.xml.XmlResponse;
import br.com.tresptecnologia.service.xml.IXmlService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.SortDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xml")
@Tag(name = "XML")
public class XmlController extends BaseRsqlFindController<XML, XmlResponse> implements BaseJsonSelectController<XML> {

    private final XmlMapper mapper;

    protected XmlController(IXmlService service,
                            XmlMapper mapper, IXmlService service1, XmlMapper mapper1) {
        super(service, mapper);
        this.mapper = mapper1;
    }

    @Override
    public IXmlService getService() {
        return (IXmlService) super.getService();
    }

    @GetMapping(path = "/json/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public XML getXml(@PathVariable(name = "id") Long id) throws DomainException {
        return getService().findById(id);
    }

    @SwaggerGenericResponseType
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Consulta os dados paginando e filtrando utilizando o padrão **RSQL**")
    public Iterable<? extends BaseResponse> findPage(
            @Parameter(description = BaseControllerConstants.FIND_PAGE_DOC)
            @RequestParam(required = false) String search,
            @SortDefault(sort = "id")
            Sort sort,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {

        final Specification<XML> spec = SpecificationUtils.rsqlToSpecification(search);
        return getService().findAll(spec, page, size, sort, mapper::toTableResponse);
    }
}
