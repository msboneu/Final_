package digitalHouse.integrador8.travels.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExperienciaNoEncontradaException extends RuntimeException{
	
	public ExperienciaNoEncontradaException() {
        super("Lo sentimos, no tenemos experiencias en este momento.");
    }
}
