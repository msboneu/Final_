package digitalHouse.integrador8.travels.layers.controller;

import digitalHouse.integrador8.travels.entity.Reserva;
import digitalHouse.integrador8.travels.layers.repository.ExperienciaRepository;
import digitalHouse.integrador8.travels.layers.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/prueba")
public class TestController {

    @Autowired
    ExperienciaRepository experienciaRepository;

    @GetMapping
    public ResponseEntity<String> tester() {
        return new ResponseEntity<>("Es una prueba", HttpStatus.OK);
    }

    @GetMapping("/reservas/{id}")
    public ResponseEntity<List<Reserva>> tester2(@PathVariable Long id) {
        return new ResponseEntity<>(experienciaRepository.findById(id).get().getReservas(), HttpStatus.OK);
    }

}
