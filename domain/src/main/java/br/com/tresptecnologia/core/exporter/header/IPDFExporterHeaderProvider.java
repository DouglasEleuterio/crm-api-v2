package br.com.tresptecnologia.core.exporter.header;

import br.com.tresptecnologia.core.exporter.ExporterConfig;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

public interface IPDFExporterHeaderProvider {
    /**
     * Função responsável por realizar a implementação da chamada para adicionar um header padrão na exportação
     * @param writer
     * @param document
     * @param exporterConfig
     */
    void addHeader(PdfWriter writer, Document document, ExporterConfig exporterConfig);
}