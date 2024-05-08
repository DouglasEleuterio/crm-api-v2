package br.com.tresptecnologia.core.exporter.header;


import br.com.tresptecnologia.core.exporter.ExporterConfig;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public interface IXLSXExporterHeaderProvider {
    /**
     * Função responsável por adicionar o header customizado nas exportações
     *
     * @param startRow       - Linha de inicio
     * @param workbook       - Workbook do apache poi
     * @param sheet          - Planilha no qual será adicionada
     * @param exporterConfig - Configurações de exportações
     * @return a proxima linha após as informações terem sido inseridas
     */
    int addHeader(int startRow, Workbook workbook, Sheet sheet, ExporterConfig exporterConfig);
}
