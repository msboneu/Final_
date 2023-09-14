package digitalHouse.integrador8.travels.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidadorDestino.class)
public @interface DestinoValido {

    String message() default "El destino no es valido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
