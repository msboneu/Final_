package digitalHouse.integrador8.travels.layers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digitalHouse.integrador8.travels.dto.ExperienciaDTO;
import digitalHouse.integrador8.travels.exception.NoExperienciasCategoria;
import digitalHouse.integrador8.travels.layers.repository.ExperienciaRepository;
import digitalHouse.integrador8.travels.layers.service.serviceInterfaces.ListarExperienciasPorCategoriaService;
import digitalHouse.integrador8.travels.utils.Mapper;

@Service
public class ListarExperienciasPorCategoriaServiceImpl implements ListarExperienciasPorCategoriaService {
	
	private final ExperienciaRepository experienciaRepository;
	
	@Autowired
	public ListarExperienciasPorCategoriaServiceImpl(ExperienciaRepository experienciaRepository) {
		this.experienciaRepository = experienciaRepository;
	}

	@Override
	public List<ExperienciaDTO> listarExperienciasPorCategoria(Long id) {
		List<ExperienciaDTO> experienciaCategoria = experienciaRepository.findByCategoriaId(id).stream().map(Mapper::convertExperienciaEntityToDto).toList();
		if(experienciaCategoria.isEmpty()) {
			throw new NoExperienciasCategoria();
		}
		return experienciaCategoria;
	}
	
}
