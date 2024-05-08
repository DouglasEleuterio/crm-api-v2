package br.com.tresptecnologia.core.config;

public interface IPathRelatorioResolver {

    ApplicationProperties getApplicationProperties();

    default String getDirReports() {
        if(getApplicationProperties().getResourceReportFolder() != null) {
            return "/" + getApplicationProperties().getResourceReportFolder() + "/";
        }
        return "/reports" + "/";
    }

    default String getBaseReportDir() {
        if(getApplicationProperties().getResourceReportFolder() != null) {
            return getApplicationProperties().getResourceReportFolder() + "/";
        }
        return "reports" + "/";
    }
}
