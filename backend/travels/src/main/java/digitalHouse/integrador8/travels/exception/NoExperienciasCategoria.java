package digitalHouse.integrador8.travels.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoExperienciasCategoria extends RuntimeException {
	
	public NoExperienciasCategoria() {
		super("Lo sentimos, no tenemos experiencias en esta categoría.");
	}
}
