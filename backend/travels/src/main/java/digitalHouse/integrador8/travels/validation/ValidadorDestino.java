package digitalHouse.integrador8.travels.validation;

import digitalHouse.integrador8.travels.entity.Destino;
import digitalHouse.integrador8.travels.layers.service.DestinoServiceImpl;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ValidadorDestino implements ConstraintValidator<DestinoValido, String> {

    @Autowired
    DestinoServiceImpl destinoService;

    List<String> destinosValidos = destinoService.obtenerEntidades().stream()
            .map(Destino::getNombreDestino).collect(Collectors.toList());

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) return false;
        for (String string : destinosValidos) {
            if (value.equals(string)) return true;
        }
        return false;
    }
}
