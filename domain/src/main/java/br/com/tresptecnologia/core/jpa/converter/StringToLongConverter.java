package br.com.tresptecnologia.core.jpa.converter;

import org.apache.logging.log4j.util.Strings;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class StringToLongConverter implements AttributeConverter<Long, String> {

    @Override
    public String convertToDatabaseColumn(Long value) {
    	if (value != null) {
    		return String.valueOf(value);
    	}
    	
    	return null;
    }

    @Override
    public Long convertToEntityAttribute(String value) {
    	if (Strings.isNotEmpty(value)) {
    		return Long.valueOf(value);
    	}
    	
    	return null;	    
	}
}
