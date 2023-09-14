package digitalHouse.integrador8.travels.layers.controller;

import java.util.Optional;

import digitalHouse.integrador8.travels.entity.Experiencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import digitalHouse.integrador8.travels.dto.ExperienciaDetalleDTO;
import digitalHouse.integrador8.travels.layers.service.ListarDetalleExperienciaService;


@RestController
@RequestMapping("/experiencia")
public class ListarDetalleExperienciaController {
	
    private final ListarDetalleExperienciaService experienciaService;

    @Autowired
    public ListarDetalleExperienciaController(ListarDetalleExperienciaService experienciaService) {
        this.experienciaService = experienciaService;
    }

    @GetMapping(value = "/detalle/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExperienciaDetalleDTO> listarDetalleExperiencia(@PathVariable("id") Long id) {
    	Optional<ExperienciaDetalleDTO> experienciaDTO = experienciaService.listarDetalleExperiencia(id);
        if (experienciaDTO.isPresent()) {
            return ResponseEntity.ok(experienciaDTO.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/completa/{id}")
    public ResponseEntity<Experiencia> consultarExperiencia(@PathVariable Long id) {
        return new ResponseEntity<>(experienciaService.listarExperienciaCompleta(id), HttpStatus.OK);
    }
}
