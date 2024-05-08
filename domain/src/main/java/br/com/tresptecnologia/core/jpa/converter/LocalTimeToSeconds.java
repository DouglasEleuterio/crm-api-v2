package br.com.tresptecnologia.core.jpa.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.time.LocalTime;

@Converter
public class LocalTimeToSeconds implements AttributeConverter<LocalTime, Integer> {
    @Override
    public Integer convertToDatabaseColumn(LocalTime localTime) {
        return localTime.toSecondOfDay();
    }

    @Override
    public LocalTime convertToEntityAttribute(Integer integer) {
        return LocalTime.ofSecondOfDay(integer);
    }

}
