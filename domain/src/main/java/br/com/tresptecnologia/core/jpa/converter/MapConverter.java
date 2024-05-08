package br.com.tresptecnologia.core.jpa.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Collections;
import java.util.Map;

@Converter
public class MapConverter implements AttributeConverter<Map<String, Object>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<String, Object> value) {
        try {
            return this.objectMapper.writeValueAsString(value);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String value) {
        try {
            return this.objectMapper.readValue(value, new TypeReference<>() {
            });
        } catch (Exception ex) {
            return Collections.emptyMap();
        }
    }
}
