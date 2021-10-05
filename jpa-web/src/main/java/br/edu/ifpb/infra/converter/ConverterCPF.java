package br.edu.ifpb.infra.converter;

import br.edu.ifpb.domain.CPF;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ConverterCPF implements AttributeConverter<CPF, String> {

    @Override
    public String convertToDatabaseColumn(CPF cpf) {
        if(cpf == null) return null;
        return cpf.valor();
    }

    @Override
    public CPF convertToEntityAttribute(String s) {
        if(s == null) return null;
        return new CPF(s);
    }
}