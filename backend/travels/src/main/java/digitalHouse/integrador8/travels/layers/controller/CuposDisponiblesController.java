package digitalHouse.integrador8.travels.layers.controller;
import digitalHouse.integrador8.travels.dto.SolicitudCupoFechaDTO;
import digitalHouse.integrador8.travels.layers.service.serviceInterfaces.CuposDisponiblesReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/experiencia")
public class CuposDisponiblesController {
    @Autowired
    CuposDisponiblesReservaService cuposDisponiblesReservaService;

    @GetMapping("/cuposDisponibles/{id}")
    public ResponseEntity<Integer> obtenerCuposDisponibles(@PathVariable Long id, @RequestBody SolicitudCupoFechaDTO fechaConsulta) {
        return ResponseEntity.ok(cuposDisponiblesReservaService.obtenerCuposDisponibles(id, fechaConsulta));
    }
}