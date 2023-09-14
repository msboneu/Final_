package digitalHouse.integrador8.travels.layers.service;

import digitalHouse.integrador8.travels.dto.ExperienciaDTO;
import digitalHouse.integrador8.travels.dto.ExperienciaDTO2;
import digitalHouse.integrador8.travels.entity.Experiencia;
import digitalHouse.integrador8.travels.entity.Paquete;
import digitalHouse.integrador8.travels.layers.repository.ExperienciaRepository;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class AuxiliarExperienciaService {

    @Autowired
    CreadorDestinoServiceImpl guardarDestinoService;
    @Autowired
    CreadorCategoriaServiceImpl guardarCategoriaService;
    @Autowired
    ExperienciaRepository experienciaRepository;
    @Autowired
    CreadorPaqueteServiceImpl guardarPaqueteService;
    @Autowired
    CreadorCarreteImagenServiceImpl carreteImagenService;

    public Experiencia guardarExperiencia(ExperienciaDTO experienciaDTO) {
        Experiencia experiencia = new Experiencia();
        experiencia.setNombreExperiencia(experienciaDTO.getNombreExperiencia());
        experiencia.setDescripcion(experienciaDTO.getDescripcion());
        experiencia.setCategoria(guardarCategoriaService.obtenerCategoria(experienciaDTO.getCategoria()));
        experiencia.setDestino(guardarDestinoService.guardarDestino(experienciaDTO.getDestino()));
        experiencia.setCantidadCalificaciones(0);
        experiencia.setCalificacion(0.0);
        experiencia.setPaqueteMap(new HashMap<>());
        experiencia.setCupoMaximo(experienciaDTO.getCupoMaximo());
        experiencia.setDuracionDias(experienciaDTO.getDuracionDias());
        experiencia.setReservas(new ArrayList<>());
        Paquete paquetePremium = guardarPaqueteService.guardarPaquete("premium", experienciaDTO.getPrecioPremium(), 1L);
        Paquete paqueteBasic = guardarPaqueteService.guardarPaquete("basic", experienciaDTO.getPrecioBasico(), 2L);
        experiencia.getPaqueteMap().put("premium", paquetePremium);
        experiencia.getPaqueteMap().put("basic", paqueteBasic);
        experiencia.setImagenes(new ArrayList<>());
        return experienciaRepository.save(experiencia);
    }

    public Experiencia guardarExperiencia(ExperienciaDTO2 experienciaDTO) {
        try {
            Experiencia experiencia = new Experiencia();
            experiencia.setNombreExperiencia(experienciaDTO.getNombreExperiencia());
            experiencia.setDescripcion(experienciaDTO.getDescripcion());
            experiencia.setCategoria(guardarCategoriaService.obtenerCategoria(experienciaDTO.getCategoria()));
            experiencia.setDestino(guardarDestinoService.guardarDestino(experienciaDTO.getDestino()));
            experiencia.setCantidadCalificaciones(0);
            experiencia.setCalificacion(0.0);
            experiencia.setPaqueteMap(new HashMap<>());
            experiencia.setCupoMaximo(experienciaDTO.getCupoMaximo());
            experiencia.setDuracionDias(experienciaDTO.getDuracionDias());
            Paquete paquetePremium = guardarPaqueteService.guardarPaquete("premium", experienciaDTO.getPrecioPremium(), 1L);
            Paquete paqueteBasic = guardarPaqueteService.guardarPaquete("basic", experienciaDTO.getPrecioBasico(), 2L);
            experiencia.getPaqueteMap().put("premium", paquetePremium);
            experiencia.getPaqueteMap().put("basic", paqueteBasic);
            experienciaRepository.save(experiencia);
            experiencia.setImagenes(carreteImagenService.guardarImagenes(experienciaDTO.getUrlImagenes(), experiencia));
            return experienciaRepository.save(experiencia);
        } catch (RuntimeException ex) {
                throw new DataIntegrityViolationException("Uno de los campos está vacio");
        }
    }
}
