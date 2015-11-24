package be.groept.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.ResourceBundle;

@FacesValidator
public class IntegerValidator implements Validator {


    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String inputtekst = (String)value;

        String bundlename = context.getApplication().getMessageBundle();
        ResourceBundle msgbundle = ResourceBundle.getBundle(bundlename);
        String errorbdschap = msgbundle.getString("validateminamount");

        if(!inputtekst.isEmpty() && !(inputtekst.matches("[0-9]+"))) {
            throw new ValidatorException(new FacesMessage(errorbdschap));
        }
    }
}
