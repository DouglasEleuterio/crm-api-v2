package br.com.tresptecnologia.core.exporter;

import lombok.Getter;

@Getter
public enum ExporterType {

    EXCEL("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", ".xlsx"),
    CSV("text/csv", ".csv"),
    PDF("application/pdf", ".pdf");

    private final String name;
    private final String mimeType;

    ExporterType(String mimeType, String name) {
        this.name = name;
        this.mimeType = mimeType;
    }
}
