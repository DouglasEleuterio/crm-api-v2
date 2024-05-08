package br.com.tresptecnologia.core.exporter.format;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@Component
public class RealFormat implements IExporterValueFormat {

    private static DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.CANADA_FRENCH);
    private static DecimalFormat decimalFormat = new DecimalFormat("#,###.00", symbols);

    @Override
    public Object format(Object value, String format) {
        if (value != null && "real".equals(format)) {
            return String.format("R$ %s", decimalFormat.format(value));
        }
        return value;
    }

    @Override
    public boolean apply(Object value) {
        return value instanceof BigDecimal;
    }
}
