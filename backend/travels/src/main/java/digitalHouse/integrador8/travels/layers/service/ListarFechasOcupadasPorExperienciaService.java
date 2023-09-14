package digitalHouse.integrador8.travels.layers.service;

import digitalHouse.integrador8.travels.entity.Experiencia;
import digitalHouse.integrador8.travels.entity.Reserva;
import digitalHouse.integrador8.travels.exception.ExperienciaNoExistenteException;
import digitalHouse.integrador8.travels.layers.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ListarFechasOcupadasPorExperienciaService {

    @Autowired
    ExperienciaRepository experienciaRepository;

    public List<LocalDate> consultarFechasOcupadasPorExperiencia(Long idExperiencia) {
        Optional<Experiencia> experiencia = experienciaRepository.findById(idExperiencia);
        if (experiencia.isEmpty()) {
            throw new ExperienciaNoExistenteException(idExperiencia);
        } else {
            List<Reserva> reservasExperiencia = experiencia.get().getReservas();
            return reservasExperiencia.stream()
                    .filter(reserva -> CreadorReservaService.cuposLlenos(experiencia.get(), reserva.getFechaInicio()))
                    .filter(reserva -> reserva.getFechaInicio().isAfter(LocalDate.now()) || reserva.getFechaInicio().equals(LocalDate.now()))
                    .map(Reserva::getFechaInicio)
                    .collect(Collectors.toList());
        }
    }
}
