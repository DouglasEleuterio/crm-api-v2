package br.com.tresptecnologia.core.exporter.provider;

import br.com.tresptecnologia.core.exporter.exception.ExporterException;
import br.com.tresptecnologia.core.exporter.header.IXLSXExporterHeaderProvider;
import br.com.tresptecnologia.core.exporter.ExporterColumn;
import br.com.tresptecnologia.core.exporter.ExporterConfig;
import br.com.tresptecnologia.core.exporter.ExporterData;
import br.com.tresptecnologia.core.exporter.ExporterType;
import br.com.tresptecnologia.core.exporter.IExporterPagination;
import br.com.tresptecnologia.core.exporter.IExporterProviderService;
import br.com.tresptecnologia.core.exporter.IExporterValue;
import br.com.tresptecnologia.core.exporter.format.ExporterValueFormatFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@Qualifier("xlsx")
public class XlsxExporterProviderService implements IExporterProviderService {
    private static final Logger logger = Logger.getLogger("CSVExporterService");

    private final IExporterPagination exporterPagination;
    private final ExporterValueFormatFactory exporterValueFormatFactory;
    private final ObjectProvider<IXLSXExporterHeaderProvider> exporterHeaderProvider;

    public XlsxExporterProviderService(final IExporterPagination exporterPagination,
                                       final ExporterValueFormatFactory exporterValueFormatFactory,
                                       final ObjectProvider<IXLSXExporterHeaderProvider> exporterHeaderProvider) {
        this.exporterPagination = exporterPagination;
        this.exporterValueFormatFactory = exporterValueFormatFactory;
        this.exporterHeaderProvider = exporterHeaderProvider;
    }

    @Override
    public <T> ExporterData export(final ExporterConfig config,
                                   final Specification<T> specification,
                                   final Sort sort,
                                   final Class<T> clazz) throws ExporterException {
        try (Workbook workbook = new SXSSFWorkbook()) {
            Sheet sheet = workbook.createSheet(config.getTitle());

            AtomicReference<Integer> atomicReference = new AtomicReference<>();

            exporterHeaderProvider.ifAvailable(service -> atomicReference.set(service.addHeader(0, workbook, sheet, config)));

            int rowIndex = atomicReference.get();

            addColumns(workbook, rowIndex, sheet, config);
            ++rowIndex;

            int first = 0;
            boolean exit = false;

            int paginationSize = config.getPaginationSize();

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
                        addRow(sheet, rowIndex, value, config);
                        ++rowIndex;
                    }
                }
                first += paginationSize;
            }
            this.autoFit((SXSSFSheet) sheet, config);

            ByteArrayOutputStream byteArrayStream = new ByteArrayOutputStream();
            workbook.write(byteArrayStream);

            byte[] bytes = byteArrayStream.toByteArray();
            byteArrayStream.close();

            return new ExporterData(config.getFileName(), ExporterType.EXCEL, bytes);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
            throw new ExporterException("Falha o realizar a exportação para XLSX");
        }
    }

    private void addColumns(final Workbook workbook, final int rowIndex, final Sheet sheet, final ExporterConfig config) {
        Row header = sheet.createRow(rowIndex);

        for (int headerIndex = 0; headerIndex < config.getColumns().size(); headerIndex++) {
            Cell headerCell = header.createCell(headerIndex);
            headerCell.setCellValue(config.getColumns().get(headerIndex).getLabel());
        }
    }

    private void autoFit(final SXSSFSheet sheet, final ExporterConfig config) {
        sheet.trackAllColumnsForAutoSizing();
        for (int headerIndex = 0; headerIndex < config.getColumns().size(); headerIndex++) {
            sheet.autoSizeColumn(headerIndex);
        }
    }

    private void addRow(final Sheet sheet, int rowIndex, IExporterValue value,
                        final ExporterConfig config) {
        Row valueRow = sheet.createRow(rowIndex);
        for (int headerIndex = 0; headerIndex < config.getColumns().size(); headerIndex++) {
            Cell rowCell = valueRow.createCell(headerIndex);
            ExporterColumn column = config.getColumns().get(headerIndex);
            Object rowValue = exporterValueFormatFactory.getValue(column, value);
            rowCell.setCellValue(rowValue.toString());
        }
    }
}
