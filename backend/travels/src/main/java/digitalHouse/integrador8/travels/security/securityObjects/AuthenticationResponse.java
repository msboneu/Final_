package digitalHouse.integrador8.travels.security.securityObjects;

import digitalHouse.integrador8.travels.dto.DatosUsuarioAutenticadoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    private String token;
    private DatosUsuarioAutenticadoDTO datosUsuario;
}
