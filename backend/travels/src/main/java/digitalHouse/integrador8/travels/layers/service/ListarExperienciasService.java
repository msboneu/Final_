package digitalHouse.integrador8.travels.layers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import digitalHouse.integrador8.travels.dto.ExperienciaDTO;
import digitalHouse.integrador8.travels.exception.ExperienciaNoEncontradaException;
import digitalHouse.integrador8.travels.exception.ExperienciaNoPaginacionException;
import digitalHouse.integrador8.travels.layers.repository.ExperienciaRepository;
import digitalHouse.integrador8.travels.utils.Mapper;

@Service
public class ListarExperienciasService {
    private static final int PAGE_SIZE = 9;
    
    private final ExperienciaRepository experienciaRepository;

    @Autowired
    public ListarExperienciasService(ExperienciaRepository experienciaRepository) {
        this.experienciaRepository = experienciaRepository;
    }

    public List<ExperienciaDTO> listarExperienciasPag(int pageNumber) throws ExperienciaNoPaginacionException {
    	
    	Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE, Sort.by("nombreExperiencia").ascending());
        Page<ExperienciaDTO> page = experienciaRepository.findAll(pageable).map(Mapper::convertExperienciaEntityToDto);
        List<ExperienciaDTO> experiencias = page.getContent();
        
        if (experiencias.isEmpty()) {
            throw new ExperienciaNoPaginacionException(pageNumber);
        }
        
        return experiencias;
    }
    
    public List<ExperienciaDTO> listarExperiencias() throws ExperienciaNoEncontradaException {
    	
    	List<ExperienciaDTO> experiencias = experienciaRepository.findAll().stream().map(Mapper::convertExperienciaEntityToDto).toList();
        
        if (experiencias.isEmpty()) {
            throw new ExperienciaNoEncontradaException();
        }
        
        return experiencias;
    }
    
    public int paginasTotal() {
    	int sizeExperiencias = experienciaRepository.findAll().size();
    	
    	int cociente = sizeExperiencias / PAGE_SIZE;
        int resto = sizeExperiencias % PAGE_SIZE;

        if (resto > 0) {
            cociente++;
        }
        return cociente;
    }
}
