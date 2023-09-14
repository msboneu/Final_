/*package digitalHouse.integrador8.travels.layers.controller;

import digitalHouse.integrador8.travels.layers.service.S3ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin("*")
@RestController
@RequestMapping("/imagenes")
public class S3Controller {

    @Autowired
    S3ServiceImpl s3Service;

    @PostMapping("/cargar/{id}")
    public ResponseEntity<String> cargarImagen(@RequestParam(value = "imagen") MultipartFile imagen, @PathVariable Long id) throws IOException {
        return new ResponseEntity<>(s3Service.cargarImagen(imagen, id), HttpStatus.CREATED);
    }
}
*/