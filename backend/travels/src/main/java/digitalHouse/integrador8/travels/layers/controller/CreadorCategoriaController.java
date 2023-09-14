package digitalHouse.integrador8.travels.layers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import digitalHouse.integrador8.travels.dto.CategoriaDTO;
import digitalHouse.integrador8.travels.entity.Categoria;
import digitalHouse.integrador8.travels.layers.service.CreadorCategoriaServiceImpl;

@RestController
@RequestMapping("/categoria")
public class CreadorCategoriaController {
	
    private final CreadorCategoriaServiceImpl categoriaService;

    @Autowired
    public CreadorCategoriaController(CreadorCategoriaServiceImpl categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/guardar")
    public ResponseEntity<Categoria> guardarCategoria(@RequestBody CategoriaDTO experienciaDTO) {
        return new ResponseEntity<>(categoriaService.guardarCategoria(experienciaDTO), HttpStatus.CREATED);
    }

}
