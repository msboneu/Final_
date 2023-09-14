package digitalHouse.integrador8.travels.layers.service;

import digitalHouse.integrador8.travels.dto.ReservaCreadaDTO;
import digitalHouse.integrador8.travels.dto.SolicitudReservaDTO;
import digitalHouse.integrador8.travels.entity.Experiencia;
import digitalHouse.integrador8.travels.entity.Reserva;
import digitalHouse.integrador8.travels.entity.Usuario;
import digitalHouse.integrador8.travels.exception.CuposNoDisponiblesException;
import digitalHouse.integrador8.travels.exception.LimiteCupoException;
import digitalHouse.integrador8.travels.layers.repository.ReservaRepository;
import digitalHouse.integrador8.travels.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class CreadorReservaService {

    @Autowired
    UsuarioServiceImpl usuarioService;
    @Autowired
    ListarDetalleExperienciaService experienciaService;
    @Autowired
    ReservaRepository reservaRepository;

    public ReservaCreadaDTO crearReserva(SolicitudReservaDTO solicitudReserva, Long idExperiencia) {

        Experiencia experiencia = experienciaService.listarExperienciaCompleta(idExperiencia);
        Usuario usuario = usuarioService.obtenerUsuarioPorEmail(solicitudReserva.getEmail());

        if (solicitudReserva.getCantidadCupos() > experiencia.getCupoMaximo()) {
            throw new LimiteCupoException(experiencia.getNombreExperiencia(), experiencia.getCupoMaximo());
        }
        if (cuposLlenos(solicitudReserva.getCantidadCupos(), experiencia, solicitudReserva.getFechaInicio())) {
            Integer cuposDisponibles = contarCuposDisponibles(experiencia, solicitudReserva.getFechaInicio());
            throw new CuposNoDisponiblesException(cuposDisponibles);
        }
        return asistirCreacionReserva(solicitudReserva, experiencia, usuario);
    }

    public boolean cuposLlenos(Integer cantidadCupos, Experiencia experiencia, LocalDate fechaNuevaReserva) {

        List<Reserva> reservasPrevias = experiencia.getReservas().stream()
                .filter(reserva -> reserva.getFechaInicio().equals(fechaNuevaReserva))
                .toList();
        if (reservasPrevias.size() == 0) {
            return false;
        } else {
            List<Integer> cuposReservas = reservasPrevias.stream().map(Reserva::getCantidadCupos).toList();
            Integer cuposUsados = cuposReservas.stream().reduce(0, (subtotal, cupos) -> subtotal + cupos);
            cuposUsados += cantidadCupos;
            return cuposUsados > experiencia.getCupoMaximo();
        }
    }

    public static boolean cuposLlenos(Experiencia experiencia, LocalDate fechaNuevaReserva) {

        List<Reserva> reservasPrevias = experiencia.getReservas().stream()
                .filter(reserva -> reserva.getFechaInicio().equals(fechaNuevaReserva))
                .toList();
        if (reservasPrevias.size() == 0) {
            return false;
        } else {
            List<Integer> cuposReservas = reservasPrevias.stream().map(Reserva::getCantidadCupos).toList();
            Integer cuposUsados = cuposReservas.stream().reduce(0, (subtotal, cupos) -> subtotal + cupos);
            return cuposUsados.equals(experiencia.getCupoMaximo());
        }
    }

    public Integer contarCuposDisponibles(Experiencia experiencia, LocalDate fechaNuevaReserva) {
        List<Reserva> reservasPrevias = experiencia.getReservas().stream()
                .filter(reserva -> reserva.getFechaInicio().equals(fechaNuevaReserva))
                .toList();
        List<Integer> cuposReservas = reservasPrevias.stream().map(Reserva::getCantidadCupos).toList();
        Integer cuposUsados = cuposReservas.stream().reduce(0, (subtotal, cupos) -> subtotal + cupos);
        return experiencia.getCupoMaximo() - cuposUsados;
    }

    public ReservaCreadaDTO asistirCreacionReserva(SolicitudReservaDTO solicitudReserva, Experiencia experienciaReserva, Usuario usuarioReserva) {

        try {
            Reserva reserva = Reserva.builder()
                    .cantidadCupos(solicitudReserva.getCantidadCupos())
                    .fechaInicio(solicitudReserva.getFechaInicio())
                    .fechaFin(solicitudReserva.getFechaInicio().plusDays(experienciaReserva.getDuracionDias()))
                    .precioTotal(asignarPrecioReserva(solicitudReserva.getTipoPaquete(), experienciaReserva, solicitudReserva.getCantidadCupos()))
                    .usuario(usuarioReserva)
                    .experiencia(experienciaReserva)
                    .paqueteEscogido(solicitudReserva.getTipoPaquete())
                    .build();
            Reserva reservacreada = reservaRepository.save(reserva);
            return Mapper.convertReservaToReservaCreadaDTO(reservacreada);
        } catch (RuntimeException ex) {
            throw new DataIntegrityViolationException("Uno de los campos está vacio");
        }
    }

    public Double asignarPrecioReserva(String tipoPaquete, Experiencia experiencia, Integer cantidadCupos) {

        Double precio;
        if (tipoPaquete.equals("basic")) {
            precio = cantidadCupos * experiencia.getPaqueteMap().get("basic").getPrecio();
        } else {
            precio = cantidadCupos * experiencia.getPaqueteMap().get("premium").getPrecio();
        }
        return precio;
    }
}
