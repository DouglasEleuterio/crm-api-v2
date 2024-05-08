package br.com.tresptecnologia.core.exporter.provider;


import br.com.tresptecnologia.core.exporter.exception.ExporterException;
import br.com.tresptecnologia.core.exporter.ExporterColumn;
import br.com.tresptecnologia.core.exporter.ExporterConfig;
import br.com.tresptecnologia.core.exporter.ExporterData;
import br.com.tresptecnologia.core.exporter.ExporterType;
import br.com.tresptecnologia.core.exporter.IExporterPagination;
import br.com.tresptecnologia.core.exporter.IExporterProviderService;
import br.com.tresptecnologia.core.exporter.IExporterValue;
import br.com.tresptecnologia.core.exporter.format.ExporterValueFormatFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@Qualifier("csv")
public class CsvExporterProviderService implements IExporterProviderService {

    private static final Logger logger = Logger.getLogger("CSVExporterService");

    private final IExporterPagination exporterPagination;
    private final ExporterValueFormatFactory exporterValueFormatFactory;

    public CsvExporterProviderService(final IExporterPagination exporterPagination,
                                      final ExporterValueFormatFactory exporterValueFormatFactory) {
        this.exporterPagination = exporterPagination;
        this.exporterValueFormatFactory = exporterValueFormatFactory;
    }

    @Override
    public <T> ExporterData export(final ExporterConfig config,
                                   final Specification<T> specification,
                                   final Sort sort,
                                   final Class<T> clazz) throws ExporterException {
        int first = 0;
        boolean exit = false;
        ObjectMapper objectMapper = new CsvMapper();
        CsvSchema.Builder schemaBuilder = new CsvSchema.Builder();
        config.getColumns()
                .forEach(exporterColumn -> schemaBuilder.addColumn(exporterColumn.getLabel()));

        String separator = ";";
        int paginationSize = config.getPaginationSize();

        try (StringWriter strW = new StringWriter()) {
            SequenceWriter seqW = objectMapper.writer(schemaBuilder.build()
                    .withColumnSeparator(separator.toCharArray()[0])).writeValues(strW);

            seqW.write(config.getColumns().stream().map(ExporterColumn::getLabel).toList());

            while (!exit) {
                List<IExporterValue> values = exporterPagination.fetch(
                        specification,
                        config.getColumns(),
                        first,
                        paginationSize,
                        sort,
                        clazz);
                exit = values == null || values.isEmpty() || values.size() < paginationSize;
                if (values != null) {
                    for (IExporterValue value : values) {
                        seqW.write(config.getColumns().stream().map(
                                column -> {
                                    Object rowValue = exporterValueFormatFactory.getValue(column, value);
                                    return rowValue.toString();
                                }
                        ).toList());
                    }
                }
                first += paginationSize;
            }
            seqW.close();
            return new ExporterData(config.getFileName(),
                    ExporterType.CSV,
                    strW.toString().getBytes(getCharsetEncoding(config)));
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

    private Charset getCharsetEncoding(final ExporterConfig config) {
        if ("ISO_8859_1".equalsIgnoreCase(config.getProperties().getEncoding())) {
            return StandardCharsets.ISO_8859_1;
        }
        return StandardCharsets.UTF_8;
    }
}
