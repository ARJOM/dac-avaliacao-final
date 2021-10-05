package br.edu.ifpb.infra.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDate;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter <LocalDate, Date>{
    @Override
    public Date convertToDatabaseColumn(LocalDate localDate) {
        if(localDate ==null) return null;
        return Date.valueOf(localDate);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        if(date ==null) return null;
        return date.toLocalDate();
    }
}