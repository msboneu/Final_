package digitalHouse.integrador8.travels.layers.service.serviceInterfaces;

import java.util.List;

import digitalHouse.integrador8.travels.dto.ExperienciaDTO;

public interface ListarExperienciasPorCategoriaService {
	List<ExperienciaDTO> listarExperienciasPorCategoria(Long id);
}
