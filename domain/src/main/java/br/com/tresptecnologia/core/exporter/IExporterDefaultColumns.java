package br.com.tresptecnologia.core.exporter;

import java.util.List;

public interface IExporterDefaultColumns {
    /**
     * Função responsável por adicionar colunas padrões na aplicação sem a necessidade do frontend enviar
     * a configuração. Exemplos: Data de Criação, Data de Atualização e etc
     * @param existingColumns
     * @param entity
     * @return
     * @param <T>
     */
    <T> List<ExporterColumn> get(List<ExporterColumn> existingColumns, Class<T> entity, boolean isExcelOrCsv);
}
