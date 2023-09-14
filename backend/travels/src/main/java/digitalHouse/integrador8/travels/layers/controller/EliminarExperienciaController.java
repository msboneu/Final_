package digitalHouse.integrador8.travels.layers.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import digitalHouse.integrador8.travels.layers.service.serviceInterfaces.EliminarExperienciaService;


@RestController
@RequestMapping("/experiencia")
public class EliminarExperienciaController {
    @Autowired
    EliminarExperienciaService experienciaService;

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteExperiencia(@PathVariable Long id){
        experienciaService.eliminar(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
