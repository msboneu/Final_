package digitalHouse.integrador8.travels.exception;

public class EntidadExistenteException extends RuntimeException {

    public EntidadExistenteException (String nombre) {
        super("No es posible registrar porque "+ nombre + " ya existe en la base de datos");
    }
}
