package br.com.tresptecnologia.service.exemplo.report;


import br.com.tresptecnologia.core.report.ReportData;
import br.com.tresptecnologia.core.report.ReportType;
import br.com.tresptecnologia.core.report.exception.ReportException;

public interface IExemploReportService {
    ReportData relatorioExemplo(ReportType reportType) throws ReportException;
}
