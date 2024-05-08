package br.com.tresptecnologia.core.report.jasper;

import br.com.tresptecnologia.core.report.ReportData;
import br.com.tresptecnologia.core.report.exception.ReportException;
import br.com.tresptecnologia.core.config.IPathRelatorioResolver;
import br.com.tresptecnologia.core.report.IReportService;
import br.com.tresptecnologia.core.report.ReportType;
import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JRRewindableDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class JasperReportService implements IReportService {

    private static final Logger logger = Logger.getLogger(JasperReportService.class.getName());

    private final IPathRelatorioResolver pathRelatorioResolver;

    public JasperReportService(IPathRelatorioResolver pathRelatorioResolver) {
        this.pathRelatorioResolver = pathRelatorioResolver;
    }

    @Override
    public <T> ReportData generate(String jasperFile, List<T> dataset, ReportType reportType, String reportFileName, Map<String, Object> parameters) throws ReportException {
        parameters.put("BASEREPORT_DIR", pathRelatorioResolver.getBaseReportDir());
        var reportOutputStream = export(dataset, parameters, reportType, jasperFile);
        return new ReportData(reportFileName, reportType, reportOutputStream.toByteArray());
    }

    private <T> ByteArrayOutputStream export(final List<T> dataset, final Map<String, Object> parameters, final ReportType exportType,
                                             final String reportFile) throws ReportException {
        try {
            switch (exportType) {
                case EXCEL:
                    JRXlsxExporter exporter = new JRXlsxExporter();
                    SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
                    configuration.setDetectCellType(true);
                    configuration.setCollapseRowSpan(false);
                    exporter.setConfiguration(configuration);
                    return export(exporter, createJasperPrint(dataset, parameters, reportFile));
                case WORD:
                    return export(new JRDocxExporter(), createJasperPrint(dataset, parameters, reportFile));
                case PDF:
                default:
                    var reportByteArrayOutputStream = new ByteArrayOutputStream();
                    JasperExportManager.exportReportToPdfStream(createJasperPrint(dataset, parameters, reportFile), reportByteArrayOutputStream);
                    return reportByteArrayOutputStream;
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Falha ao exportar o relatório", e);
            throw new ReportException("Error ao exportar o relatório");
        }

    }

    private ByteArrayOutputStream export(JRAbstractExporter<?, ?, OutputStreamExporterOutput, ?> exporter, JasperPrint print) throws JRException {
        var reportByteArrayOutputStream = new ByteArrayOutputStream();
        exporter.setExporterInput(new SimpleExporterInput(print));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(reportByteArrayOutputStream));
        exporter.exportReport();
        return reportByteArrayOutputStream;
    }

    private <T> JasperPrint createJasperPrint(final List<T> dataset, final Map<String, Object> parameters, final String reportFile) throws JRException {
        parameters.put(JRParameter.REPORT_LOCALE, new Locale("pt", "BR"));
        JRRewindableDataSource dataSource = dataset != null && !dataset.isEmpty() ? new JRBeanCollectionDataSource(dataset)
                : new JREmptyDataSource();
        return JasperFillManager.fillReport(readJasperFile(reportFile),
                parameters, dataSource);
    }

    private InputStream readJasperFile(final String reportFile) {
        return getClass().getResourceAsStream(pathRelatorioResolver.getDirReports() + reportFile);
    }
}
