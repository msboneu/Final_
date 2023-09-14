package digitalHouse.integrador8.travels.layers.controller;

import digitalHouse.integrador8.travels.dto.DatosUsuarioDTO;
import digitalHouse.integrador8.travels.dto.ExperienciaDetalleDTO;
import digitalHouse.integrador8.travels.layers.service.serviceInterfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuario/{id}")
    public ResponseEntity<DatosUsuarioDTO> obtener(@PathVariable("id") Long id){
        Optional<DatosUsuarioDTO> usuarioDTO = usuarioService.obtener(id);
        if (usuarioDTO.isPresent()) {
            return ResponseEntity.ok(usuarioDTO.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}


