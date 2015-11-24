package be.groept.ex3;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.math.BigDecimal;

/**
 * Created by java on 13.10.15.
 */
public class NullOrNumberValidator implements ConstraintValidator<NullOrNumber,String> {
    @Override
    public void initialize(NullOrNumber constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value==null)
        {
            return true;
        }
        else {
            for (char c: value.toCharArray()){
                if(!Character.isDigit(c)){
                    return false;
                }

            }
            return true;
        }

    }
}
