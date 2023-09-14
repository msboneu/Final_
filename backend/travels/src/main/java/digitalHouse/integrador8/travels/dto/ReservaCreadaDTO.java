package digitalHouse.integrador8.travels.dto;

import digitalHouse.integrador8.travels.entity.Usuario;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservaCreadaDTO {

    @NonNull
    private Long idReserva;
    @NonNull
    private String experiencia;
    @NonNull
    private String paqueteReservado;
    @NonNull
    private Double precioTotal;
    @NonNull
    private LocalDate fechaInicio;
    @NonNull
    private LocalDate fechaFin;
    @NonNull
    private Integer cantidadCupos;
    @NonNull
    private DatosUsuarioDTO datosUsuario;
}
