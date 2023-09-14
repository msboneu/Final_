package digitalHouse.integrador8.travels.layers.service;

import digitalHouse.integrador8.travels.dto.CalificacionDTO;
import digitalHouse.integrador8.travels.entity.Experiencia;
import digitalHouse.integrador8.travels.exception.ExperienciaNoExistenteException;
import digitalHouse.integrador8.travels.layers.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CalificadorExperienciaServiceImpl {

    @Autowired
    ExperienciaRepository experienciaRepository;

    public void calificarExperiencia(Long experienciaId, CalificacionDTO calificacion) {
        Optional<Experiencia> experienciaOptional = experienciaRepository.findById(experienciaId);
        if (experienciaOptional.isEmpty()) {
            throw new ExperienciaNoExistenteException(experienciaId);
        } else {
            puntuarExperiencia(experienciaOptional, calificacion);
        }
    }

    public void puntuarExperiencia(Optional<Experiencia> experienciaOptional, CalificacionDTO calificacion) {
        Experiencia experiencia = experienciaOptional.get();
        Integer cantidadCalificaciones = experiencia.getCantidadCalificaciones();
        if (cantidadCalificaciones == 0) {
            experiencia.setCalificacion(calificacion.getPuntaje());
        } else {
            experiencia.setCalificacion(((experiencia.getCalificacion() * cantidadCalificaciones) + calificacion.getPuntaje()) / (experiencia.getCantidadCalificaciones() + 1));
        }
        experiencia.setCantidadCalificaciones(cantidadCalificaciones + 1);
        experienciaRepository.save(experiencia);
    }
}
