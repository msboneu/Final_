package digitalHouse.integrador8.travels.security.securityObjects;

import digitalHouse.integrador8.travels.validation.PasswordValido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String nombre;
    private String apellido;
    private String email;
    @PasswordValido
    private String password;
    private String direccion;
}
