package be.groept.ie4.entities.types;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;



@Converter(autoApply = true)
public class PasswordConverter implements AttributeConverter<Password,String> {

    @Override
    public String convertToDatabaseColumn(Password password){
        return password.getClearText();
    }

    @Override
    public Password convertToEntityAttribute(String passwordString){
        return new Password(passwordString,passwordString);
    }


}
