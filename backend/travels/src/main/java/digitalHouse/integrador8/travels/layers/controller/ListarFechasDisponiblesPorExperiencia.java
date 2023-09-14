package digitalHouse.integrador8.travels.layers.controller;

import digitalHouse.integrador8.travels.layers.service.ListarFechasOcupadasPorExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/experiencia/fechas")
public class ListarFechasDisponiblesPorExperiencia {

    @Autowired
    ListarFechasOcupadasPorExperienciaService listarFechasOcupadasPorExperiencia;

    @GetMapping({"/{id}"})
    public ResponseEntity<List<LocalDate>> consultarFechasOcupadasPorExperiencia(@PathVariable Long id) {
        return new ResponseEntity<>(listarFechasOcupadasPorExperiencia.consultarFechasOcupadasPorExperiencia(id), HttpStatus.OK);
    }
}
