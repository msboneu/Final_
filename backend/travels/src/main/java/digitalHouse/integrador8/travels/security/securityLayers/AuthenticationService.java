package digitalHouse.integrador8.travels.security.securityLayers;

import digitalHouse.integrador8.travels.dto.DatosUsuarioAutenticadoDTO;
import digitalHouse.integrador8.travels.entity.Rol;
import digitalHouse.integrador8.travels.entity.Usuario;
import digitalHouse.integrador8.travels.exception.UsuarioExistenteException;
import digitalHouse.integrador8.travels.exception.UsuarioNoExistenteException;
import digitalHouse.integrador8.travels.layers.repository.UsuarioRepository;
import digitalHouse.integrador8.travels.security.securityObjects.AuthenticationRequest;
import digitalHouse.integrador8.travels.security.securityObjects.AuthenticationResponse;
import digitalHouse.integrador8.travels.security.securityObjects.CustomAuthenticationManager;
import digitalHouse.integrador8.travels.security.securityObjects.RegisterRequest;
import digitalHouse.integrador8.travels.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final CustomAuthenticationManager customAuthenticationManager;

    public void register(RegisterRequest request) {

        if (userAlreadyExists(request.getEmail())) {
            throw new UsuarioExistenteException(request.getEmail());
        } else {
            var usuario = Usuario.builder()
                    .nombre(request.getNombre())
                    .apellido(request.getApellido())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .direccion(request.getDireccion())
                    .reservas(new ArrayList<>())
                    .rol(Rol.USER)
                    .build();
            usuarioRepository.save(usuario);
        }
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        customAuthenticationManager.authenticate(request);
        var usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsuarioNoExistenteException(request.getEmail()));
        var jwtToken = jwtService.generarToken(usuario);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .datosUsuario(DatosUsuarioAutenticadoDTO.builder()
                        .id(usuario.getId())
                        .iniciales(Mapper.convertUsuarioEntityToDto(usuario).getIniciales())
                        .nombre(usuario.getNombre())
                        .apellido(usuario.getApellido())
                        .email(usuario.getEmail())
                        .rol(usuario.getRol())
                        .build())
                .build();
    }

    public boolean userAlreadyExists(String email) {
        return usuarioRepository.findByEmail(email).isPresent();
    }
}
