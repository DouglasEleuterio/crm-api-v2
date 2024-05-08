package br.com.tresptecnologia.core.exporter.format;

import org.springframework.stereotype.Component;

@Component
public class BooleanFormat implements IExporterValueFormat {

    @Override
    public Object format(Object value, String format) {
        if (value instanceof Boolean isBool) {
            if (format != null) {
                String[] str = format.split(",");
                if (str.length == 2) {
                    return Boolean.TRUE.equals(isBool) ? str[0] : str[1];
                }
            }
            return Boolean.TRUE.equals(isBool) ? "Sim" : "Não";
        }
        return "-";
    }

    @Override
    public boolean apply(Object value) {
        return value instanceof Boolean;
    }
}
