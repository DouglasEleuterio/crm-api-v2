package br.com.tresptecnologia.core.jpa.converter;

import org.apache.logging.log4j.util.Strings;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class StringToIntegerConverter implements AttributeConverter<Integer, String> {
    @Override
    public String convertToDatabaseColumn(Integer value) {
    	if (value != null) {
    		return String.valueOf(value);
    	}
    	
    	return null;
    }

    @Override
    public Integer convertToEntityAttribute(String value) {
    	if (Strings.isNotEmpty(value)) {
    		return Integer.valueOf(value);
    	}
    	
    	return null;	    
	}
}
