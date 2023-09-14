package digitalHouse.integrador8.travels.layers.service;

import digitalHouse.integrador8.travels.entity.Destino;
import digitalHouse.integrador8.travels.layers.repository.DestinoRepository;
import digitalHouse.integrador8.travels.layers.service.serviceInterfaces.TravelService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class DestinoServiceImpl implements TravelService<Destino> {

    @Autowired
    DestinoRepository destinoRepository;

    @Override
    public Destino guardarEntidad(Destino entidad) {
        if (entidadPresente(entidad)) {
            throw new RuntimeException();
        } else {
            return destinoRepository.save(entidad);
        }
    }

    @Override
    public Destino obtenerEntidad(Long entidadId) {
        Optional<Destino> destinoOptional = destinoRepository.findById(entidadId);
        return desenvolvedorSeguro(destinoOptional, entidadId);
    }

    @Override
    public List<Destino> obtenerEntidades() {
        return (List<Destino>) destinoRepository.findAll();
    }

    @Override
    public void eliminarEntidad(Long entidadId) {
        destinoRepository.deleteById(entidadId);
    }

    @Override
    public Destino desenvolvedorSeguro(Optional<Destino> entidad, Long entidadId) {
        if(entidad.isPresent()) {
            return entidad.get();
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean entidadPresente(Destino entidad) {
        return destinoRepository.findByNombreDestino(entidad.getNombreDestino()).isPresent();
    }
}
