package br.com.tresptecnologia.exporter;


import br.com.tresptecnologia.core.config.IPathRelatorioResolver;
import br.com.tresptecnologia.core.exporter.ExporterConfig;
import br.com.tresptecnologia.core.exporter.header.IXLSXExporterHeaderProvider;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


@Slf4j
@Service
public class XLSXExporterHeaderProvider implements IXLSXExporterHeaderProvider {

    private final IPathRelatorioResolver pathResolver;

    private final ResourceLoader resourceLoader;

    public XLSXExporterHeaderProvider(final IPathRelatorioResolver pathResolver,
                                      final ResourceLoader resourceLoader) {
        this.pathResolver = pathResolver;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public int addHeader(int startRow, Workbook workbook, Sheet sheet, ExporterConfig exporterConfig) {

        try {
            // Criação do Header
            Row headerRow = sheet.createRow(startRow);
            headerRow.setHeightInPoints(60);

            // Célula do Título
            headerRow.createCell(0);
            headerRow.createCell(1);
            Cell titleCell = headerRow.createCell(2);
            titleCell.setCellStyle(getHeaderCellStyle(workbook, (short) 14, true));
            titleCell.setCellValue(exporterConfig.getTitle());
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 2, exporterConfig.getColumns().size() - 2));

            int pictureIndex = loadLogoImage(workbook);

            // Adicionar a imagem na célula
            Drawing<?> drawing = sheet.createDrawingPatriarch();
            ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 0, 2, 1);
            drawing.createPicture(anchor, pictureIndex);

            //sheet.setColumnWidth(0, 60);


            // Linha de Data/Hora
            Row infoRow2 = sheet.createRow(3);
            Cell dateTimeCell = infoRow2.createCell(0);
            dateTimeCell.setCellStyle(infoCellStyle(workbook, (short) 10, true));

            dateTimeCell.setCellValue("Data/Hora:");

            Cell valueCell2 = infoRow2.createCell(1);
            valueCell2.setCellValue(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
            valueCell2.setCellStyle(infoCellStyle(workbook, (short) 10, false));
            return 5;
        } catch (IOException e) {
            return 0;
        }
    }

    private CellStyle getHeaderCellStyle(Workbook workbook, short size, boolean bold) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontHeightInPoints(size);
        font.setBold(bold);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        return style;
    }

    private CellStyle infoCellStyle(Workbook workbook, short size, boolean bold) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontHeightInPoints(size);
        font.setBold(bold);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        return style;
    }

    private int loadLogoImage(Workbook workbook) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:" + pathResolver.getBaseReportDir() + "assets" + File.separator + "images" + File.separator + "logo-TRE.png");

        InputStream inputStream = resource.getInputStream();
        Objects.requireNonNull(inputStream);
        byte[] imageBytes = IOUtils.toByteArray(inputStream);
        inputStream.close();
        return workbook.addPicture(imageBytes, Workbook.PICTURE_TYPE_PNG);
    }
}
