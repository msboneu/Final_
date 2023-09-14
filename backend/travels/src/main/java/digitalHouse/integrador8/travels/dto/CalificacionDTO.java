package digitalHouse.integrador8.travels.dto;

import digitalHouse.integrador8.travels.validation.PuntajeValido;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CalificacionDTO {

    @PuntajeValido
    @NonNull
    private Double puntaje;
}
