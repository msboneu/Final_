package digitalHouse.integrador8.travels.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidadorPuntaje.class)
public @interface PuntajeValido {

    String message() default "El puntaje ingresado no es valido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
