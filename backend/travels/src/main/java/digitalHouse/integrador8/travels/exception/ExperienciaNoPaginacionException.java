package digitalHouse.integrador8.travels.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExperienciaNoPaginacionException extends RuntimeException {
    public ExperienciaNoPaginacionException(int page) {
        super("La página " + page + " no tiene experiencias disponibles.");
    }
}
