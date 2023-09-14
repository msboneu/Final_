package digitalHouse.integrador8.travels.layers.service.serviceInterfaces;

import java.util.List;
import java.util.Optional;

public interface TravelService<T> {

    T guardarEntidad(T entidad);

    T obtenerEntidad(Long entidadId);

    List<T> obtenerEntidades();

    void eliminarEntidad(Long entidadId);

    T desenvolvedorSeguro(Optional<T> entidad, Long entidadId);
    
    public boolean entidadPresente(T entidad);

}
