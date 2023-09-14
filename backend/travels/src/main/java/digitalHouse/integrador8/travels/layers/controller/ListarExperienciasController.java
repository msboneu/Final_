package digitalHouse.integrador8.travels.layers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import digitalHouse.integrador8.travels.dto.ExperienciaDTO;
import digitalHouse.integrador8.travels.exception.ExperienciaNoEncontradaException;
import digitalHouse.integrador8.travels.exception.ExperienciaNoPaginacionException;
import digitalHouse.integrador8.travels.layers.service.ListarExperienciasService;
import jakarta.annotation.Nullable;


@RestController
@RequestMapping("/experiencia")
public class ListarExperienciasController {
	
    private final ListarExperienciasService experienciasService;

    @Autowired
    public ListarExperienciasController(ListarExperienciasService experienciasService) {
        this.experienciasService = experienciasService;
    }

    @GetMapping(value = "/listar",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ExperienciaDTO>> listarExperienciasPag(@Nullable @RequestParam Integer pageNumber) throws ExperienciaNoPaginacionException {
    	int actualPageNumber = pageNumber == null ? 0 : pageNumber;
        return ResponseEntity.ok(experienciasService.listarExperienciasPag(actualPageNumber));
    }

    @GetMapping(value = "/listarExperiencias",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ExperienciaDTO>> listarExperiencias() throws ExperienciaNoEncontradaException {
        return ResponseEntity.ok(experienciasService.listarExperiencias());
    }

    @GetMapping(value = "/listarPagExperiencias",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> totalPaginas() {
        return ResponseEntity.ok(experienciasService.paginasTotal());
    }
}
