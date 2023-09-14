package digitalHouse.integrador8.travels.layers.service;

import digitalHouse.integrador8.travels.dto.ExperienciaDTO;
import digitalHouse.integrador8.travels.dto.ExperienciaDTO2;
import digitalHouse.integrador8.travels.entity.Experiencia;
import digitalHouse.integrador8.travels.entity.Paquete;
import digitalHouse.integrador8.travels.exception.EntidadExistenteException;
import digitalHouse.integrador8.travels.layers.repository.ExperienciaRepository;
import digitalHouse.integrador8.travels.layers.service.serviceInterfaces.TravelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class CreadorExperienciaServiceImpl implements TravelService<Experiencia> {

    @Autowired
    ExperienciaRepository experienciaRepository;
    @Autowired
    AuxiliarExperienciaService auxiliarExperienciaService;


    @Override
    public Experiencia guardarEntidad(Experiencia entidad) {
        return null;
    }

    public Experiencia guardarExperiencia(ExperienciaDTO experienciaDTO) {
        if (entidadPresente(experienciaDTO.getNombreExperiencia())) {
            throw new EntidadExistenteException(experienciaDTO.getNombreExperiencia());
        } else {
            return auxiliarExperienciaService.guardarExperiencia(experienciaDTO);
        }
    }

    public Experiencia guardarExperiencia(ExperienciaDTO2 experienciaDTO) {
        if (entidadPresente(experienciaDTO.getNombreExperiencia())) {
            throw new EntidadExistenteException(experienciaDTO.getNombreExperiencia());
        } else {
            return auxiliarExperienciaService.guardarExperiencia(experienciaDTO);
        }
    }

    @Override
    public Experiencia obtenerEntidad(Long entidadId) {
        return null;
    }

    @Override
    public List<Experiencia> obtenerEntidades() {
        return null;
    }

    @Override
    public void eliminarEntidad(Long entidadId) {

    }

    @Override
    public Experiencia desenvolvedorSeguro(Optional<Experiencia> entidad, Long entidadId) {
        return null;
    }

    @Override
    public boolean entidadPresente(Experiencia entidad) {
        return false;
    }

    public boolean entidadPresente(String nombreExperiencia) {
        return experienciaRepository.findByNombreExperiencia(nombreExperiencia).isPresent();
    }
}
