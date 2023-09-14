package digitalHouse.integrador8.travels.layers.repository;

import digitalHouse.integrador8.travels.entity.Servicios;
import digitalHouse.integrador8.travels.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, CrudRepository<Usuario, Long> {
    
	Optional<Usuario> findByEmail(String email);
	Usuario findByEmailIgnoreCase(String email);
}
