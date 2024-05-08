package br.com.tresptecnologia.exporter;


import br.com.tresptecnologia.core.config.IPathRelatorioResolver;
import br.com.tresptecnologia.core.exporter.ExporterConfig;
import br.com.tresptecnologia.core.exporter.header.IPDFExporterHeaderProvider;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static com.lowagie.text.Rectangle.NO_BORDER;


@Slf4j
@Service
public class PDFExporterHeaderService implements IPDFExporterHeaderProvider {

    private static final Font TITLE_FONT = FontFactory.getFont(FontFactory.TIMES_BOLD, 14);
    private static final Font INFO_FONT = FontFactory.getFont(FontFactory.TIMES_BOLD, 12);
    private static final Font VALUE_INFO_FONT = FontFactory.getFont(FontFactory.TIMES, 12);

    private final IPathRelatorioResolver pathResolver;

    private final ResourceLoader resourceLoader;

    public PDFExporterHeaderService(final IPathRelatorioResolver pathResolver,
                                    final ResourceLoader resourceLoader) {
        this.pathResolver = pathResolver;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void addHeader(PdfWriter writer, Document document, ExporterConfig exporterConfig) {
        Resource resource = resourceLoader.getResource("classpath:" + pathResolver.getBaseReportDir() + "assets" + File.separator + "images" + File.separator + "logo-TRE.png");

        try (InputStream inputStream = resource.getInputStream()) {
            Objects.requireNonNull(inputStream);

            byte[] imageBytes = IOUtils.toByteArray(inputStream);

            // Criação da tabela para o header
            PdfPTable headerTable = new PdfPTable(2);
            float[] columnWidths = {10f, 80f}; // Definir larguras das colunas em porcentagem

            headerTable.setWidthPercentage(100); // Definir a largura da tabela em relação à página
            headerTable.setWidths(columnWidths);
            headerTable.setSpacingAfter(10);

            // Adicionar logotipo
            Image logo = Image.getInstance(imageBytes);
            logo.scaleToFit(100, 100);
            logo.setBorder(NO_BORDER);
            PdfPCell logoCell = new PdfPCell(logo);
            logoCell.setBorder(NO_BORDER);
            logoCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            logoCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            headerTable.addCell(logoCell);

            // Adicionar título
            PdfPCell titleCell = new PdfPCell();
            Paragraph title = new Paragraph(exporterConfig.getTitle(), TITLE_FONT);
            title.setAlignment(Element.ALIGN_CENTER);
            titleCell.addElement(title);
            titleCell.setBorder(NO_BORDER);
            titleCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            titleCell.setPaddingRight(40f);
            headerTable.addCell(titleCell);

            headerTable.getDefaultCell().setBorder(NO_BORDER);

            // Adicionar header ao documento
            document.add(headerTable);

            // Cria tabela para as informações do usuário logado e data e hora da geração
            PdfPTable infoTable = new PdfPTable(2);
            infoTable.getDefaultCell().setBorder(NO_BORDER);
            float[] infoColumnWidths = {8f, 80f};

            infoTable.setWidthPercentage(100);
            infoTable.setWidths(infoColumnWidths);
            infoTable.setSpacingAfter(10);

            createReportInfo(infoTable, "Data/Hora:", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));

            // Adicionar info ao documento
            document.add(infoTable);
        } catch (IOException | DocumentException e) {
            log.error("Error ao gerar o HEADER do documento de exportação", e);
        }
    }

    private void createReportInfo(PdfPTable table, String stringTitle, String stringValue) {
        createCell(table, stringTitle, INFO_FONT);
        createCell(table, stringValue, VALUE_INFO_FONT);
    }

    private void createCell(PdfPTable table, String stringTitle, Font infoFont) {
        PdfPCell titleCell = new PdfPCell();
        Paragraph title = new Paragraph(stringTitle, infoFont);
        title.setAlignment(Element.ALIGN_LEFT);
        titleCell.addElement(title);
        titleCell.setBorder(NO_BORDER);
        titleCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        titleCell.setHorizontalAlignment(Element.ALIGN_LEFT);

        table.addCell(titleCell);
    }
}
