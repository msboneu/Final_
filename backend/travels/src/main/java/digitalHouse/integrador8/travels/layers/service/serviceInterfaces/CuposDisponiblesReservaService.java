package digitalHouse.integrador8.travels.layers.service.serviceInterfaces;

import digitalHouse.integrador8.travels.dto.SolicitudCupoFechaDTO;

public interface CuposDisponiblesReservaService {
    Integer obtenerCuposDisponibles(Long idExperiencia, SolicitudCupoFechaDTO fechaReserva);
}