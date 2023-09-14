package digitalHouse.integrador8.travels.layers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digitalHouse.integrador8.travels.dto.CategoriaDTO;
import digitalHouse.integrador8.travels.layers.repository.CategoriaRepository;
import digitalHouse.integrador8.travels.layers.service.serviceInterfaces.ListarCategoriasService;
import digitalHouse.integrador8.travels.utils.Mapper;

@Service
public class ListarCategoriaServiceImpl implements ListarCategoriasService {
	
	private final CategoriaRepository categoriaRepository;
	
	@Autowired
	public ListarCategoriaServiceImpl(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	@Override
	public List<CategoriaDTO> listarCategorias() { 
		return categoriaRepository.findAll().stream().map(Mapper::convertCategoriaToDto).toList();
	}
	
}
