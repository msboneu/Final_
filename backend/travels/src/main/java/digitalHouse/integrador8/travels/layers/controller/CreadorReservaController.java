package digitalHouse.integrador8.travels.layers.controller;

import digitalHouse.integrador8.travels.dto.ReservaCreadaDTO;
import digitalHouse.integrador8.travels.dto.SolicitudReservaDTO;
import digitalHouse.integrador8.travels.layers.service.CreadorReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserva/crear")
public class CreadorReservaController {

    @Autowired
    CreadorReservaService creadorReservaService;

    @PostMapping("/{id}")
    public ResponseEntity<ReservaCreadaDTO> reservarExperiencia(@PathVariable Long id, @RequestBody SolicitudReservaDTO solicitudReserva) {
        return new ResponseEntity<>(creadorReservaService.crearReserva(solicitudReserva, id), HttpStatus.CREATED);
    }
}
