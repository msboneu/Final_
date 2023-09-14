package digitalHouse.integrador8.travels.exception;

public class CategoriaNoValidaException extends RuntimeException {

    public CategoriaNoValidaException (String nombreCategoria) {
        super("La categoría : '" + nombreCategoria + "' no es valida");
    }
}
