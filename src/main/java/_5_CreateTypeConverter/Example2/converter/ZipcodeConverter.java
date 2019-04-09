package _5_CreateTypeConverter.Example2.converter;

import _5_CreateTypeConverter.Example2.model.GermanZipcode;
import _5_CreateTypeConverter.Example2.model.SwissZipcode;
import _5_CreateTypeConverter.Example2.model.Zipcode;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ZipcodeConverter implements AttributeConverter<Zipcode, String> {
    @Override
    public String convertToDatabaseColumn(Zipcode attribute) {
        return attribute.getValue();
    }

    @Override
    public Zipcode convertToEntityAttribute(String dbData) {
        if (dbData.length() == 4) {
            return new SwissZipcode(dbData);
        } else if (dbData.length() == 5) {
            return new GermanZipcode(dbData);
        }

        throw new IllegalArgumentException("Unsupported zipcode in database: " + dbData);
    }
}
