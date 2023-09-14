package digitalHouse.integrador8.travels.layers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import digitalHouse.integrador8.travels.dto.ExperienciaDTO;
import digitalHouse.integrador8.travels.layers.service.ListarExperienciasPorCategoriaServiceImpl;


@RestController
@RequestMapping("/experiencia")
public class ListarExperienciasPorCategoriaController {
	
    private final ListarExperienciasPorCategoriaServiceImpl experienciasCategoriaService;

    @Autowired
    public ListarExperienciasPorCategoriaController(ListarExperienciasPorCategoriaServiceImpl experienciasCategoriaService) {
        this.experienciasCategoriaService = experienciasCategoriaService;
    }

    @GetMapping(value = "/listarPorCategoria/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ExperienciaDTO>> listarExperienciasPag(@PathVariable("id") Long id) {
        return ResponseEntity.ok(experienciasCategoriaService.listarExperienciasPorCategoria(id));
    }
}
