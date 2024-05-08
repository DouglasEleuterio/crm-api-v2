package br.com.tresptecnologia.core.jpa.converter;

import org.apache.logging.log4j.util.Strings;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ZeroOrOneBooleanConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean value) {
        if (value != null) {
            return value ? "1" : "0";
        }

        return null;
    }

    @Override
    public Boolean convertToEntityAttribute(String value) {
        if (Strings.isNotEmpty(value)) {
            return value.equals("1");
        }

        return false;
    }
}
