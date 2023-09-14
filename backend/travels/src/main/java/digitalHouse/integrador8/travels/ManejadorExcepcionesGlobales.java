package digitalHouse.integrador8.travels;

import digitalHouse.integrador8.travels.exception.*;
import io.jsonwebtoken.ClaimJwtException;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class ManejadorExcepcionesGlobales extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> errors.add(error.getDefaultMessage()));
        return new ResponseEntity<>(new RespuestaTipoError(errors), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({EntidadExistenteException.class, UsuarioExistenteException.class})
    public ResponseEntity<Object> manejadorRecursoExistente(RuntimeException e) {
        RespuestaTipoError respuestaTipoError = new RespuestaTipoError(Arrays.asList(e.getMessage()));
        return new  ResponseEntity<>(respuestaTipoError, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler({ExperienciaNoExistenteException.class, ExperienciaNoPaginacionException.class, ExperienciaNoEncontradaException.class, NoExperienciasCategoria.class})
    public ResponseEntity<Object> manejadorRecursoNoExistente(RuntimeException e) {
        RespuestaTipoError respuestaTipoError = new RespuestaTipoError(Arrays.asList(e.getMessage()));
        return new  ResponseEntity<>(respuestaTipoError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({CategoriaNoValidaException.class, LimiteCupoException.class, CuposNoDisponiblesException.class})
    public ResponseEntity<Object> manejadorRecursoNoValido(RuntimeException e) {
        RespuestaTipoError respuestaTipoError = new RespuestaTipoError(Arrays.asList(e.getMessage()));
        return new  ResponseEntity<>(respuestaTipoError, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> manejadorCamposNulos (RuntimeException e) {
        RespuestaTipoError tipoError = new RespuestaTipoError(Arrays.asList(e.getMessage()));
        return new ResponseEntity<>(tipoError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<Object> manejadorCamposNulos (ClaimJwtException e) {
        RespuestaTipoError tipoError = new RespuestaTipoError(Arrays.asList(e.getMessage()));
        return new ResponseEntity<>(tipoError, HttpStatus.BAD_REQUEST);
    }
}
