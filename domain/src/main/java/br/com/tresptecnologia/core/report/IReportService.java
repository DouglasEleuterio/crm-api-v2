package br.com.tresptecnologia.core.report;

import br.com.tresptecnologia.core.report.exception.ReportException;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface IReportService {

    /**
     *
     * @param jasperFile
     * @param dataset
     * @param reportType
     * @param reportFileName
     * @param parameters
     * @return
     * @param <T>
     * @throws ReportException
     */
    <T> ReportData generate(final String jasperFile,
                            final List<T> dataset,
                            final ReportType reportType,
                            final String reportFileName,
                            final Map<String, Object> parameters) throws ReportException;
}
