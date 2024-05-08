package br.com.tresptecnologia.core.exporter.provider;

import br.com.tresptecnologia.core.exporter.exception.ExporterException;
import br.com.tresptecnologia.core.exporter.format.ExporterValueFormatFactory;
import br.com.tresptecnologia.core.exporter.header.IPDFExporterHeaderProvider;
import br.com.tresptecnologia.core.exporter.ExporterColumn;
import br.com.tresptecnologia.core.exporter.ExporterConfig;
import br.com.tresptecnologia.core.exporter.ExporterData;
import br.com.tresptecnologia.core.exporter.ExporterProperties;
import br.com.tresptecnologia.core.exporter.ExporterType;
import br.com.tresptecnologia.core.exporter.IExporterPagination;
import br.com.tresptecnologia.core.exporter.IExporterProviderService;
import br.com.tresptecnologia.core.exporter.IExporterValue;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@Qualifier("pdf")
public class PdfExporterProviderService implements IExporterProviderService {

    private static final float SIZE_FONT_DEFAULT = 10f;
    private static final Logger logger = Logger.getLogger("CSVExporterService");

    private final IExporterPagination exporterPagination;
    private final ExporterValueFormatFactory exporterValueFormatFactory;
    private final ObjectProvider<IPDFExporterHeaderProvider> pdfExporterHeaderProvider;



    public PdfExporterProviderService(final IExporterPagination exporterPagination,
                                      final ExporterValueFormatFactory exporterValueFormatFactory,
                                      final ObjectProvider<IPDFExporterHeaderProvider> pdfExporterHeaderProvider) {
        this.exporterPagination = exporterPagination;
        this.exporterValueFormatFactory = exporterValueFormatFactory;
        this.pdfExporterHeaderProvider = pdfExporterHeaderProvider;
    }

    @Override
    public <T> ExporterData export(final ExporterConfig config,
                                   final Specification<T> specification,
                                   final Sort sort,
                                   final Class<T> clazz) throws ExporterException {
        Rectangle orientation = PageSize.A4;

        ExporterProperties properties = config.getProperties();

        if (properties != null && properties.getOrientation() != null &&
                properties.getOrientation().equalsIgnoreCase("PORTRAIT")) {
            orientation = PageSize.A4.rotate();
        }

        try (Document document = new Document(orientation)) {
            try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
                final byte[] bytes = export(config, specification, sort, clazz, document, byteArrayOutputStream);
                return new ExporterData(config.getFileName(), ExporterType.PDF, bytes);
            } catch (Exception ex) {
                logger.log(Level.SEVERE, ex.getMessage());
                throw new ExporterException("Falha ao exportar para pdf");
            }
        }
    }

    private <T> byte[] export(final ExporterConfig config,
                              final Specification<T> specification,
                              final Sort sort,
                              final Class<T> clazz,
                              final Document document,
                              final ByteArrayOutputStream byteArrayOutputStream) {

        final ExporterProperties properties = config.getProperties();

        final PdfWriter writer = PdfWriter.getInstance(document, byteArrayOutputStream);
        document.setMargins(32, 32, 32, 32);
        document.open();

        pdfExporterHeaderProvider.ifAvailable(x -> x.addHeader(writer, document, config));

        PdfPTable table = new PdfPTable(config.getColumns().size());
        table.setWidthPercentage(100);

        float sizeFont = SIZE_FONT_DEFAULT;
        if (properties != null && properties.getFontSize() != null) {
            sizeFont = properties.getFontSize().floatValue();
        }

        final Font fontHeader = FontFactory.getFont(FontFactory.TIMES_BOLD, sizeFont);
        final Font fontRow = FontFactory.getFont(FontFactory.TIMES, sizeFont);

        configureColumn(config, fontHeader, table);

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
                    for (int headerIndex = 0; headerIndex < config.getColumns().size(); headerIndex++) {
                        table.addCell(addRow(
                                config, headerIndex, value, fontRow
                        ));
                    }
                }
            }
            first += paginationSize;
        }

        document.add(table);
        document.close();
        return byteArrayOutputStream.toByteArray();
    }

    private void configureColumn(final ExporterConfig config,
                                 final Font fontHeader,
                                 final PdfPTable table) {
        config.getColumns().forEach(column -> {
            Paragraph para = new Paragraph(column.getLabel(), fontHeader);
            PdfPCell cell = new PdfPCell(para);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setGrayFill(0.9f);
            cell.setPadding(10f);
            table.addCell(cell);
        });
    }

    private PdfPCell addRow(final ExporterConfig config,
                            final int headerIndex,
                            final IExporterValue value,
                            final Font fontRow) {
        ExporterColumn column = config.getColumns().get(headerIndex);
        Object rowValue = exporterValueFormatFactory.getValue(column, value);
        Paragraph para = new Paragraph(rowValue.toString(), fontRow);
        PdfPCell cell = new PdfPCell(para);
        cell.setPadding(10f);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        return cell;

    }
}
