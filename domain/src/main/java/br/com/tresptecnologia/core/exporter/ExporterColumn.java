package br.com.tresptecnologia.core.exporter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExporterColumn {
    String field;
    String label;
    String format;

    public ExporterColumn(String field, String label) {
        this.field = field;
        this.label = label;
    }

    public boolean hasFormat(){
        return StringUtils.isNotBlank(format);
    }
}
