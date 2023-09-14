package digitalHouse.integrador8.travels.layers.service;

import digitalHouse.integrador8.travels.dto.DatosUsuarioDTO;
import digitalHouse.integrador8.travels.dto.ExperienciaDetalleDTO;
import digitalHouse.integrador8.travels.entity.Categoria;
import digitalHouse.integrador8.travels.entity.Usuario;
import digitalHouse.integrador8.travels.exception.UsuarioNoExistenteException;
import digitalHouse.integrador8.travels.layers.repository.UsuarioRepository;
import digitalHouse.integrador8.travels.layers.service.serviceInterfaces.UsuarioService;
import digitalHouse.integrador8.travels.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Optional<DatosUsuarioDTO>obtener(Long id) {
        return Optional.of(Mapper.convertUsuarioEntityToDto(Objects.requireNonNull(usuarioRepository.findById(id).orElse(null))));

    }

    @Override
    public Usuario obtenerUsuarioPorEmail(String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isEmpty()) {
            throw new UsuarioNoExistenteException(email);
        } else {
            return usuario.get();
        }
    }
}



