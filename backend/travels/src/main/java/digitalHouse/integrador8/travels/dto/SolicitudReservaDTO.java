package digitalHouse.integrador8.travels.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudReservaDTO {

    @NonNull
    private String email;
    @NonNull
    private LocalDate fechaInicio;
    @NonNull
    private Integer cantidadCupos;
    @NonNull
    private String tipoPaquete;
}
