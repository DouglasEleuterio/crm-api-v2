package br.com.tresptecnologia.core.jpa.converter;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ListToStringConverter implements AttributeConverter<List<String>, String> {

	@Override
	public String convertToDatabaseColumn(List<String> attribute) {
		if (Objects.nonNull(attribute)) {
			return String.join(";", attribute);
		}

		return null;
	}

	@Override
	public List<String> convertToEntityAttribute(String dbData) {
		if (Objects.nonNull(dbData)) {
			return Stream.of(dbData.split(";")).toList();
		}

		return Collections.emptyList();
	}

}
