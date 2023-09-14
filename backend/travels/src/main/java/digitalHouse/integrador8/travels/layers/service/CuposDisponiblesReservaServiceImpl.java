package digitalHouse.integrador8.travels.layers.service;

import digitalHouse.integrador8.travels.dto.SolicitudCupoFechaDTO;
import digitalHouse.integrador8.travels.entity.Experiencia;
import digitalHouse.integrador8.travels.entity.Reserva;
import digitalHouse.integrador8.travels.layers.repository.ReservaRepository;
import digitalHouse.integrador8.travels.layers.service.serviceInterfaces.CuposDisponiblesReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CuposDisponiblesReservaServiceImpl implements CuposDisponiblesReservaService {

    @Autowired
    ListarDetalleExperienciaService experienciaService;

    @Autowired
    ReservaRepository reservaRepository;


    public Integer obtenerCuposDisponibles(Long idExperiencia, SolicitudCupoFechaDTO fechaReserva) {
        Experiencia experiencia = experienciaService.listarExperienciaCompleta(idExperiencia);
        List<Reserva> reservas = experiencia.getReservas().stream()
                .filter(reserva -> reserva.getFechaInicio().equals(fechaReserva.getFecha()))
                .toList();
        List<Integer> cuposReservas = reservas.stream().map(Reserva::getCantidadCupos).toList();
        Integer cuposUsados = cuposReservas.stream().reduce(0, (subtotal, cupos) -> subtotal + cupos);
        return experiencia.getCupoMaximo() - cuposUsados;
    }

}
