package br.com.tresptecnologia.core.exporter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExporterConfig {

    String title;
    String fileName;
    ExporterProperties properties;
    List<ExporterColumn> columns;
    Integer paginationSize;
}
