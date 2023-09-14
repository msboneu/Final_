package digitalHouse.integrador8.travels.layers.controller;

import digitalHouse.integrador8.travels.dto.ReservaCreadaDTO;
import digitalHouse.integrador8.travels.layers.service.ListarReservasPorUsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class ListarReservasPorUsuarioController {

    @Autowired
    ListarReservasPorUsuarioServiceImpl listarReservasPorUsuarioService;

    @GetMapping("/reservas/{id}")
    public ResponseEntity<List<ReservaCreadaDTO>> listarReservasPorUsuario(@PathVariable Long id) {
        return new ResponseEntity<>(listarReservasPorUsuarioService.consultarReservasPorUsuario(id), HttpStatus.OK);
    }
}
