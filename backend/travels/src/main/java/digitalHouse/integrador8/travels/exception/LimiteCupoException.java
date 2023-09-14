package digitalHouse.integrador8.travels.exception;

public class LimiteCupoException extends RuntimeException {

    public LimiteCupoException (String nombreExperiencia, Integer cupos) {
        super("La experiencia : '" + nombreExperiencia + "' cuenta con un límite máximo de "+ cupos);
    }
}
