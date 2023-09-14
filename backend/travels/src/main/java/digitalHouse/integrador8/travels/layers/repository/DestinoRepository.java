package digitalHouse.integrador8.travels.layers.repository;

import digitalHouse.integrador8.travels.entity.Destino;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DestinoRepository extends CrudRepository<Destino, Long> {

    Optional<Destino> findByNombreDestino(String nombreDestino);
}
