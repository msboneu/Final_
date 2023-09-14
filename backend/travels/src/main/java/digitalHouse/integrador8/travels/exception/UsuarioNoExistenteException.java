package digitalHouse.integrador8.travels.exception;

public class UsuarioNoExistenteException extends RuntimeException {

    public UsuarioNoExistenteException (String email) {
        super("El usuario no existe en la base de datos");
    }
}
