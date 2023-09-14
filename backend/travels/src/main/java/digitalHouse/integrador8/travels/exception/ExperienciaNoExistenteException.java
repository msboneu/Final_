package digitalHouse.integrador8.travels.exception;

public class ExperienciaNoExistenteException extends RuntimeException {

    public ExperienciaNoExistenteException (Long id) {
        super("La experiencia con id: '" + id + "' no existe");
    }
}
