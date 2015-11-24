package be.groept.ex3;

import javax.faces.validator.FacesValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(value = RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE, ElementType.METHOD})
@Constraint(validatedBy = NullOrNumberValidator.class)
public @interface NullOrNumber{
    String message() default "De inputtekst is niet numeriek.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int max() default 0;

}
