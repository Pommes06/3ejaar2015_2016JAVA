package be.groept.hibernate.entities.types;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by java on 25.02.16.
 */
@Converter(autoApply = true) //anders werkt die niet automatisch
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
