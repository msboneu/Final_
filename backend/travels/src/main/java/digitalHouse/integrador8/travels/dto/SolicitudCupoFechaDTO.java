package digitalHouse.integrador8.travels.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SolicitudCupoFechaDTO {

    @NonNull LocalDate fecha;
}
