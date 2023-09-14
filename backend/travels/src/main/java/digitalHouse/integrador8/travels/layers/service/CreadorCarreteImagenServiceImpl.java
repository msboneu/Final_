package digitalHouse.integrador8.travels.layers.service;

import digitalHouse.integrador8.travels.entity.Imagen;
import digitalHouse.integrador8.travels.entity.Experiencia;
import digitalHouse.integrador8.travels.layers.repository.CarreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreadorCarreteImagenServiceImpl {

    @Autowired
    CarreteRepository carreteRepository;

    public List<Imagen> guardarImagenes(List<String> urlImagenes, Experiencia experiencia) {
        return urlImagenes.stream().map(url -> carreteRepository.save(new Imagen(url, experiencia))).collect(Collectors.toList());
    }
}
