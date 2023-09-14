package digitalHouse.integrador8.travels.layers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digitalHouse.integrador8.travels.exception.ExperienciaNoExistenteException;
import digitalHouse.integrador8.travels.layers.repository.ExperienciaRepository;
import digitalHouse.integrador8.travels.layers.service.serviceInterfaces.EliminarExperienciaService;

@Service
public class EliminarExperienciaServiceImpl implements EliminarExperienciaService{

    @Autowired
    ExperienciaRepository experienciaRepository;

     @Override
    public void eliminar(Long id) {
    	 if(experienciaRepository.findById(id).isPresent()) {
              experienciaRepository.deleteById(id);
    	 } else {
    		 throw new ExperienciaNoExistenteException(id);
    	 }

    }
}
