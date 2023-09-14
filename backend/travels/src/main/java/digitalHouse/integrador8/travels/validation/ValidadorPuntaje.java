package digitalHouse.integrador8.travels.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class ValidadorPuntaje implements ConstraintValidator<PuntajeValido, Double> {

    List<Double> puntajesValidos = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);

    @Override
    public boolean isValid(Double aDouble, ConstraintValidatorContext constraintValidatorContext) {
        return puntajesValidos.stream().anyMatch(puntaje -> puntaje.equals(aDouble));
    }
}
