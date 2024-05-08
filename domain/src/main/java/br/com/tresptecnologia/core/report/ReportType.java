package br.com.tresptecnologia.core.report;

import lombok.Getter;

@Getter
public enum ReportType {
    WORD("application/msword", ".docx"),
    EXCEL("application/excel", ".xlsx"),
    PDF("application/pdf", ".pdf");

    private final String name;
    private final String mimeType;

    ReportType(String mimeType, String name) {
        this.name = name;
        this.mimeType = mimeType;
    }
}
