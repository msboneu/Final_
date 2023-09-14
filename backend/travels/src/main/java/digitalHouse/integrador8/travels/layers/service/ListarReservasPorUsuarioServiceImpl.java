package digitalHouse.integrador8.travels.layers.service;

import digitalHouse.integrador8.travels.dto.ReservaCreadaDTO;
import digitalHouse.integrador8.travels.layers.repository.ReservaRepository;
import digitalHouse.integrador8.travels.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarReservasPorUsuarioServiceImpl {

    @Autowired
    ReservaRepository reservaRepository;

    public List<ReservaCreadaDTO> consultarReservasPorUsuario(Long idUsuario) {

        return reservaRepository.findByUsuarioId(idUsuario).stream().map(reserva -> Mapper.convertReservaToReservaCreadaDTO(reserva)).toList();
    }
}
