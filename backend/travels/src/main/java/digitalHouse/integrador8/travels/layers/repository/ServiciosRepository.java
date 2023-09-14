package digitalHouse.integrador8.travels.layers.repository;

import digitalHouse.integrador8.travels.entity.Servicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ServiciosRepository extends JpaRepository<Servicios, Long> {
}
