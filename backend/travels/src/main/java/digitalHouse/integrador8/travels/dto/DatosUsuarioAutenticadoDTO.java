package digitalHouse.integrador8.travels.dto;

import digitalHouse.integrador8.travels.entity.Rol;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DatosUsuarioAutenticadoDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private Rol rol;
    private String iniciales;
}
