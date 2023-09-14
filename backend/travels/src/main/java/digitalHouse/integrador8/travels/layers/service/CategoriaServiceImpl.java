package digitalHouse.integrador8.travels.layers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digitalHouse.integrador8.travels.entity.Categoria;
import digitalHouse.integrador8.travels.layers.repository.CategoriaRepository;
import digitalHouse.integrador8.travels.layers.service.serviceInterfaces.TravelService;

@Service
public class CategoriaServiceImpl implements TravelService<Categoria> {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public Categoria guardarEntidad(Categoria entidad) {
        if (entidadPresente(entidad)) {
            throw new RuntimeException();
        } else {
            return categoriaRepository.save(entidad);
        }
    }

    @Override
    public Categoria obtenerEntidad(Long entidadId) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(entidadId);
        return desenvolvedorSeguro(categoriaOptional, entidadId);
    }

    @Override
    public List<Categoria> obtenerEntidades() {
        return (List<Categoria>) categoriaRepository.findAll();
    }

    @Override
    public void eliminarEntidad(Long entidadId) {
        categoriaRepository.deleteById(entidadId);
    }

    @Override
    public Categoria desenvolvedorSeguro(Optional<Categoria> entidad, Long entidadId) {
        if(entidad.isPresent()) {
            return entidad.get();
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean entidadPresente(Categoria entidad) {
        return categoriaRepository.findByTipoExperiencia(entidad.getTipoExperiencia()).isPresent();
    }
    
}
