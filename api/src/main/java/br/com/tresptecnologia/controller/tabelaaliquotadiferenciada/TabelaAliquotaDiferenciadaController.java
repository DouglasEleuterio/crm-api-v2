package br.com.tresptecnologia.controller.tabelaaliquotadiferenciada;


import br.com.tresptecnologia.core.controller.BaseActiveController;
import br.com.tresptecnologia.core.controller.BaseExporterController;
import br.com.tresptecnologia.core.controller.BaseJsonSelectController;
import br.com.tresptecnologia.core.controller.BaseRsqlController;
import br.com.tresptecnologia.core.exporter.IExporterService;
import br.com.tresptecnologia.entity.TabelaAliquotaDiferenciada;
import br.com.tresptecnologia.model.tabelaaliquotadiferenciada.TabelaAliquotaDiferenciadaMapper;
import br.com.tresptecnologia.model.tabelaaliquotadiferenciada.TabelaAliquotaDiferenciadaRequest;
import br.com.tresptecnologia.model.tabelaaliquotadiferenciada.TabelaAliquotaDiferenciadaResponse;
import br.com.tresptecnologia.service.tabelaaliquotadiferenciada.ITabelaAliquotaDiferenciadaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tabela-aliquota-diferenciada")
@Tag(name = "Tabela de Aliquota Diferenciada")
public class TabelaAliquotaDiferenciadaController extends BaseRsqlController<TabelaAliquotaDiferenciada, TabelaAliquotaDiferenciadaRequest,TabelaAliquotaDiferenciadaResponse>
        implements BaseActiveController<TabelaAliquotaDiferenciada>, BaseExporterController<TabelaAliquotaDiferenciada>,
        BaseJsonSelectController<TabelaAliquotaDiferenciada> {

    private final IExporterService exporterService;

    public TabelaAliquotaDiferenciadaController(final ITabelaAliquotaDiferenciadaService service,
                                                final TabelaAliquotaDiferenciadaMapper mapper,
                                                final IExporterService exporterService) {
        super(service, mapper);
        this.exporterService = exporterService;
    }

    @Override
    public IExporterService getExporterService() {
        return exporterService;
    }

    @Override
    public ITabelaAliquotaDiferenciadaService getService() {
        return (ITabelaAliquotaDiferenciadaService) super.getService();
    }

    @Override
    public TabelaAliquotaDiferenciadaMapper getMapper() {
        return (TabelaAliquotaDiferenciadaMapper) super.getMapper();
    }
}
