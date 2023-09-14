package digitalHouse.integrador8.travels.validation;

import digitalHouse.integrador8.travels.entity.Categoria;
import digitalHouse.integrador8.travels.layers.service.CategoriaServiceImpl;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ValidadorCategoria implements ConstraintValidator<CategoriaValida, String> {

    @Autowired
    CategoriaServiceImpl categoriaService;

    List<String> categoriasValidas = categoriaService.obtenerEntidades().stream()
            .map(Categoria::getTipoExperiencia).collect(Collectors.toList());

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return false;
        for (String string : categoriasValidas) {
            if (value.equals(string)) return true;
        }
        return false;
    }

}
