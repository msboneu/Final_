package digitalHouse.integrador8.travels.layers.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import digitalHouse.integrador8.travels.entity.Experiencia;

@Repository
public interface ExperienciaRepository
		extends JpaRepository<Experiencia, Long>, PagingAndSortingRepository<Experiencia, Long> {

	Optional<Experiencia> findByNombreExperiencia(String nombreExperiencia);

	Page<Experiencia> findAll(Pageable pageable);

	List<Experiencia> findByCategoriaId(Long id);
}
