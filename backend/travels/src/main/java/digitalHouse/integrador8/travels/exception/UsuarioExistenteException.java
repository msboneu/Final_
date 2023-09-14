package digitalHouse.integrador8.travels.exception;

public class UsuarioExistenteException extends RuntimeException {
    public UsuarioExistenteException (String email) {
        super("No es posible registrar el usuario con email '" + email + "', porque ya existe en la base de datos");
    }
}
