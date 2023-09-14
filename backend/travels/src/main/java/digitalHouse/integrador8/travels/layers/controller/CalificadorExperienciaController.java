package digitalHouse.integrador8.travels.layers.controller;

import digitalHouse.integrador8.travels.dto.CalificacionDTO;
import digitalHouse.integrador8.travels.layers.service.CalificadorExperienciaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("experiencia/calificar")
public class CalificadorExperienciaController {

    @Autowired
    CalificadorExperienciaServiceImpl calificadorExperienciaService;

    @PutMapping("{id}")
    public ResponseEntity<HttpStatus> calificarExperiencia(@PathVariable Long id, @Valid @RequestBody CalificacionDTO calificacionDTO) {
        calificadorExperienciaService.calificarExperiencia(id, calificacionDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
