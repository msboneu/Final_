package digitalHouse.integrador8.travels.exception;

public class CuposNoDisponiblesException extends RuntimeException {

    public CuposNoDisponiblesException (Integer cupos) {
        super("Solo quedan " + cupos + " cupos para esta fecha");
    }
}
