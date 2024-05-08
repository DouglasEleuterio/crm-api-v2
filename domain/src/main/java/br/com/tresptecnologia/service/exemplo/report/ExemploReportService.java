package br.com.tresptecnologia.service.exemplo.report;

import br.com.tresptecnologia.core.message.Message;
import br.com.tresptecnologia.core.report.IReportService;
import br.com.tresptecnologia.core.report.ReportData;
import br.com.tresptecnologia.core.report.ReportType;
import br.com.tresptecnologia.core.report.exception.ReportException;
import br.com.tresptecnologia.entity.Exemplo;
import br.com.tresptecnologia.repository.exemplo.ExemploRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

@Service
public class ExemploReportService implements IExemploReportService {

    private static final String REPORT_JASPER_FILE = "exemplo/exemplo_relatorio.jasper";

    private final IReportService reportService;
    private final ExemploRepository exemploRepository;

    public ExemploReportService(final IReportService reportService,
                                final ExemploRepository exemploRepository) {
        this.reportService = reportService;
        this.exemploRepository = exemploRepository;
    }

    @Override
    public ReportData relatorioExemplo(final ReportType reportType) throws ReportException {
        final String reportFileName = "exemplo-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy-HHmm"));
        final List<Exemplo> exemplos = exemploRepository.findAll();

        if (exemplos.isEmpty()) {
            throw new ReportException(Message.toLocale("exemplo.relatorio.vazio"));
        }

        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("PARAMETRO_EXEMPLO", "Parametro de exemplo!");

        return reportService
                .generate(REPORT_JASPER_FILE,
                        exemplos,
                        reportType,
                        reportFileName, parameters);

    }

}
