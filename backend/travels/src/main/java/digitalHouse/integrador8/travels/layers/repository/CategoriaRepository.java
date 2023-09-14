package digitalHouse.integrador8.travels.layers.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import digitalHouse.integrador8.travels.entity.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

    Optional<Categoria> findByTipoExperiencia(String tipoExperiencia);
    List<Categoria> findAll();

}