package digitalHouse.integrador8.travels.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidadorCategoria.class)
public @interface CategoriaValida {

    String message() default "La ciudad no es valida";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
