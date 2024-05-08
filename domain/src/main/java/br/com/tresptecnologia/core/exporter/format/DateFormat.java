package br.com.tresptecnologia.core.exporter.format;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class DateFormat implements IExporterValueFormat {

    @Override
    public Object format(Object value, String format) {
        if(value instanceof  Date){
            return new SimpleDateFormat(format).format(value);
        }

        if(value instanceof LocalDate localdate){
            return localdate.format(DateTimeFormatter.ofPattern(format));
        }

        if(value instanceof LocalDateTime localDateTime){
            return localDateTime.format(DateTimeFormatter.ofPattern(format));
        }

        return value;
    }

    @Override
    public boolean apply(Object value) {
        return value instanceof Date || value instanceof LocalDate || value instanceof LocalDateTime;
    }
}
