package br.com.tresptecnologia.exporter;

import br.com.tresptecnologia.core.exporter.ExporterColumn;
import br.com.tresptecnologia.core.exporter.IExporterDefaultColumns;
import br.com.tresptecnologia.core.message.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExporterDefaultColumns implements IExporterDefaultColumns {

    @Override
    public <T> List<ExporterColumn> get(List<ExporterColumn> existingColumns, Class<T> entity, boolean isExcelOrCsv) {

        final List<ExporterColumn> exporterColumns = new ArrayList<>();

        if(isExcelOrCsv) {
            validateIfExists(existingColumns, new ExporterColumn("dataCriacao", Message.toLocale("shared.dataCriacao"), "dd/MM/yyyy"))
                    .ifPresent(exporterColumns::add);

            validateIfExists(existingColumns, new ExporterColumn("dataAtualizacao", Message.toLocale("shared.dataAtualizacao"), "dd/MM/yyyy"))
                    .ifPresent(exporterColumns::add);
        }

        return exporterColumns;
    }

    private Optional<ExporterColumn> validateIfExists(List<ExporterColumn> existingColumns, ExporterColumn column) {
        if (existingColumns.stream().filter(x -> x.getField().equalsIgnoreCase(column.getField())).findFirst().isEmpty()) {
            return Optional.of(column);
        }
        return Optional.empty();
    }

}
