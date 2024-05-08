package br.com.tresptecnologia.core.exporter.format;

import br.com.tresptecnologia.core.exporter.ExporterColumn;
import br.com.tresptecnologia.core.exporter.IExporterValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class ExporterValueFormatFactory {
    private final ApplicationContext context;

    public ExporterValueFormatFactory(ApplicationContext context) {
        this.context = context;
    }

    public Object getValue(final ExporterColumn column, final IExporterValue value) {
        Object columnValue = value.get(column.getField());
        if (column.hasFormat() && columnValue != null) {
            Optional<IExporterValueFormat> formatOptional = get(columnValue);
            if (formatOptional.isPresent()) {
                return formatOptional.get().format(columnValue, column.getFormat());
            }
        }
        return columnValue != null ? columnValue.toString() : "";
    }

    public Optional<IExporterValueFormat> get(Object obj) {
        try {
            Map<String, IExporterValueFormat> beans = context.getBeansOfType(IExporterValueFormat.class);
            return beans.values().stream().filter(x -> x.apply(obj)).findFirst();
        } catch (Exception ex) {
            log.error("Error ao consultar os beans de formatação de dados para a exportação", ex);
        }
        return Optional.empty();
    }
}
