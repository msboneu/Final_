package digitalHouse.integrador8.travels.security.securityObjects;

import digitalHouse.integrador8.travels.entity.Usuario;
import digitalHouse.integrador8.travels.exception.UsuarioNoExistenteException;
import digitalHouse.integrador8.travels.layers.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public Authentication authenticate(AuthenticationRequest request) throws AuthenticationException {
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsuarioNoExistenteException(request.getEmail()));
        if (!passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            throw new BadCredentialsException("You provided an incorrect password.");
        }
        return new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }
}
