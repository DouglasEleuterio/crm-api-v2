package br.com.tresptecnologia.core.exporter;

import br.com.tresptecnologia.core.exporter.builder.ExporterColumnBuilder;
import br.com.tresptecnologia.core.exporter.exception.ExporterException;
import br.com.tresptecnologia.core.exporter.model.ExporterRequest;
import br.com.tresptecnologia.core.jpa.util.SpecificationUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class ExporterService implements IExporterService {

    @Value("${application.export-pagination-size}")
    private Integer exportPaginationSize;

    private final IExporterProviderService pdfExporterProviderService;
    private final IExporterProviderService csvExporterProviderService;
    private final IExporterProviderService xlsxExporterProviderService;
    private final ObjectProvider<IExporterDefaultColumns> exportDefaultColumns;

    public ExporterService(@Qualifier("pdf") final IExporterProviderService pdfExporterProviderService,
                           @Qualifier("csv") final IExporterProviderService csvExporterProviderService,
                           @Qualifier("xlsx") final IExporterProviderService xlsxExporterProviderService,
                           final ObjectProvider<IExporterDefaultColumns> exportDefaultColumns) {
        this.pdfExporterProviderService = pdfExporterProviderService;
        this.csvExporterProviderService = csvExporterProviderService;
        this.xlsxExporterProviderService = xlsxExporterProviderService;
        this.exportDefaultColumns = exportDefaultColumns;
    }

    @Override
    public <T> ExporterData export(final Class<T> clazz,
                                   final ExporterRequest request,
                                   final ExporterType exporterType) throws ExporterException {

        final var exporter = getExporterProvider(exporterType);

        final var filename = StringUtils.isNotBlank(request.getFileName()) ? request.getFileName() : clazz.getSimpleName().toLowerCase(Locale.ROOT) + "-"
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy-HHmm"));

        final var exporterConfig = new ExporterConfig(request.getTitle(), filename,
                request.getProperties(), ExporterColumnBuilder.builder()
                .parse(request.getColumns(), ";")
                .build(),
                exportPaginationSize
        );

        final boolean isExcelOrCsv = exporterType.getMimeType().equalsIgnoreCase(ExporterType.CSV.getMimeType())
                || exporterType.getMimeType().equalsIgnoreCase(ExporterType.EXCEL.getMimeType());

        exportDefaultColumns.ifUnique(defaultColumn -> exporterConfig.getColumns().addAll(
                defaultColumn.get(exporterConfig.getColumns(), clazz, isExcelOrCsv)));

        Specification<T> specification = SpecificationUtils.rsqlToSpecification(request.getSearch());
        return exporter.export(exporterConfig, specification, request.getSpringSort(), clazz);
    }

    private IExporterProviderService getExporterProvider(ExporterType type) {
        return switch (type) {
            case CSV -> csvExporterProviderService;
            case EXCEL -> xlsxExporterProviderService;
            case PDF -> pdfExporterProviderService;
        };

    }
}
