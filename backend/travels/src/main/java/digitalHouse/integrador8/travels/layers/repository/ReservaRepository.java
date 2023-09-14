package digitalHouse.integrador8.travels.layers.repository;

import digitalHouse.integrador8.travels.entity.Reserva;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservaRepository extends CrudRepository<Reserva, Long> {

    List<Reserva> findByUsuarioId(Long id);
}
