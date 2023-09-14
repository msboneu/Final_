package digitalHouse.integrador8.travels.layers.service;

import java.util.Optional;

import digitalHouse.integrador8.travels.entity.Experiencia;
import digitalHouse.integrador8.travels.exception.ExperienciaNoExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digitalHouse.integrador8.travels.dto.ExperienciaDetalleDTO;
import digitalHouse.integrador8.travels.layers.repository.ExperienciaRepository;
import digitalHouse.integrador8.travels.utils.Mapper;

@Service
public class ListarDetalleExperienciaService {
	
	private final ExperienciaRepository experienciaRepository;
	
    @Autowired
    public ListarDetalleExperienciaService(ExperienciaRepository experienciaRepository) {
        this.experienciaRepository = experienciaRepository;
    }
    
    public Optional<ExperienciaDetalleDTO> listarDetalleExperiencia(Long id) {
    	return Optional.ofNullable(Mapper.convertExperienciaDetalleEntityToDto(experienciaRepository.findById(id).orElse(null)));
    }

    public Experiencia listarExperienciaCompleta(Long id) {
        Optional<Experiencia> experienciaOptional = experienciaRepository.findById(id);
        if (experienciaOptional.isPresent()) {
            return experienciaOptional.get();
        } else {
            throw new ExperienciaNoExistenteException(id);
        }
    }
}
