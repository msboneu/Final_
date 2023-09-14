package digitalHouse.integrador8.travels.layers.service.serviceInterfaces;

import digitalHouse.integrador8.travels.dto.DatosUsuarioDTO;
import digitalHouse.integrador8.travels.entity.Usuario;

import java.util.Optional;

public interface

UsuarioService {
  Optional<DatosUsuarioDTO> obtener(Long id);
  Usuario obtenerUsuarioPorEmail(String email);

}
