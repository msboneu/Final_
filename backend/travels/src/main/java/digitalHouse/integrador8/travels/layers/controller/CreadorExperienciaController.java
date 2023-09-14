package digitalHouse.integrador8.travels.layers.controller;

import digitalHouse.integrador8.travels.dto.ExperienciaDTO;
import digitalHouse.integrador8.travels.dto.ExperienciaDTO2;
import digitalHouse.integrador8.travels.entity.Experiencia;
import digitalHouse.integrador8.travels.layers.service.CreadorExperienciaServiceImpl;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/experiencia/guardar")
public class CreadorExperienciaController {

    @Autowired
    CreadorExperienciaServiceImpl guardarExperienciaService;

    @PostMapping("/v1")
    public ResponseEntity<Experiencia> guardarExperiencia(@RequestBody ExperienciaDTO experienciaDTO) {
        return new ResponseEntity<>(guardarExperienciaService.guardarExperiencia(experienciaDTO), HttpStatus.CREATED);
    }

    @PostMapping("/v2")
    public ResponseEntity<Experiencia> guardarExperienciaV2(@RequestBody ExperienciaDTO2 experienciaDTO2) {
        return new ResponseEntity<>(guardarExperienciaService.guardarExperiencia(experienciaDTO2), HttpStatus.CREATED);
    }
}
