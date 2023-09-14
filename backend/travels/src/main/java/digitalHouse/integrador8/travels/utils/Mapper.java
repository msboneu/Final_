package digitalHouse.integrador8.travels.utils;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


import digitalHouse.integrador8.travels.dto.*;

import digitalHouse.integrador8.travels.entity.*;

public abstract class Mapper {
	
    private static final ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .findAndRegisterModules();
    
    public static ExperienciaDTO convertExperienciaEntityToDto(Experiencia experiencia) {
        ExperienciaDTO experienciaDTO = new ExperienciaDTO();
        experienciaDTO.setId(experiencia.getId());
        experienciaDTO.setNombreExperiencia(experiencia.getNombreExperiencia());
        experienciaDTO.setCategoria(experiencia.getCategoria().getTipoExperiencia());
        experienciaDTO.setDestino(experiencia.getDestino().getNombreDestino());
        experienciaDTO.setUrlImagen(experiencia.getImagenes().get(0).getUrlImagen());
        experienciaDTO.setDescripcion(experiencia.getDescripcion());
        experienciaDTO.setPrecioBasico(experiencia.getPaqueteMap().get("basic").getPrecio());
        experienciaDTO.setPrecioPremium(experiencia.getPaqueteMap().get("premium").getPrecio());
        return experienciaDTO;
    }
    
    public static ExperienciaDetalleDTO convertExperienciaDetalleEntityToDto(Experiencia experiencia) {
        ExperienciaDetalleDTO experienciaDTO = new ExperienciaDetalleDTO();
        List<Imagen> imagenes = experiencia.getImagenes();

        experienciaDTO.setId(experiencia.getId());
        experienciaDTO.setNombreExperiencia(experiencia.getNombreExperiencia());
        experienciaDTO.setCategoria(experiencia.getCategoria().getTipoExperiencia());
        experienciaDTO.setDestino(experiencia.getDestino().getNombreDestino());
        experienciaDTO.setDescripcion(experiencia.getDescripcion());
        experienciaDTO.setImagenes(imagenes.stream().map(Imagen::getUrlImagen).collect(Collectors.toList()));
        experienciaDTO.setPrecioBasico(experiencia.getPaqueteMap().get("basic").getPrecio());
        experienciaDTO.setPrecioPremium(experiencia.getPaqueteMap().get("premium").getPrecio());
        experienciaDTO.setServiciosBasico(Arrays.asList("tiquetes","desayuno","hospedaje"));
        experienciaDTO.setServiciosPremium(Arrays.asList("tiquetes","traslado","alimentacionCompleta","desayuno","seguroMedico","hospedaje"));
        experienciaDTO.setCupoMaximo(experiencia.getCupoMaximo());
        experienciaDTO.setDuracionDias(experiencia.getDuracionDias());
        return experienciaDTO;
    }
    
    public static Experiencia convertExperienciaDtoToEntity(ExperienciaDTO experiencia) {
        return  mapper.convertValue(experiencia, Experiencia.class);
    }
    public static DatosUsuarioDTO convertUsuarioEntityToDto(Usuario usuario) {
        StringBuilder iniciales = new StringBuilder();
        String nombre = usuario.getNombre() != null ? usuario.getNombre() :  "";
        String apellido = usuario.getApellido() != null ? usuario.getApellido() : "";
        DatosUsuarioDTO datoUsuarioDTO = new DatosUsuarioDTO();
        datoUsuarioDTO.setNombre(nombre);
        datoUsuarioDTO.setApellido(apellido);
        datoUsuarioDTO.setId(usuario.getId());
        datoUsuarioDTO.setEmail(usuario.getEmail());
        StringBuilder nombreCompleto = new StringBuilder(nombre);
        String sTexto = nombreCompleto.append(" ").append(apellido).toString();
        StringTokenizer stPalabras = new StringTokenizer(sTexto);
        while (stPalabras.hasMoreTokens()) {
           String sPalabra = stPalabras.nextToken();
           iniciales.append(sPalabra.charAt(0));
       }
        datoUsuarioDTO.setIniciales(iniciales.toString());
        return datoUsuarioDTO;
    }
    
    public static Categoria convertCategoriaDtoToEntity(CategoriaDTO categoriaDTO) {
        return new Categoria(categoriaDTO.getTipoExperiencia(), new ImagenCategoria(), categoriaDTO.getDescripcion());
    }
    
    public static CategoriaDTO convertCategoriaToDto(Categoria categoria) {
    	return CategoriaDTO.builder()
                .id(categoria.getId())
                .descripcion(categoria.getDescripcion())
                .tipoExperiencia(categoria.getTipoExperiencia())
                .urlImagen(categoria.getImagenCategoria().getUrlImagen())
                .build();
    }

    public static ReservaCreadaDTO convertReservaToReservaCreadaDTO(Reserva reserva) {
        return ReservaCreadaDTO.builder()
                .idReserva(reserva.getId())
                .cantidadCupos(reserva.getCantidadCupos())
                .precioTotal(reserva.getPrecioTotal())
                .fechaInicio(reserva.getFechaInicio())
                .fechaFin(reserva.getFechaFin())
                .paqueteReservado(reserva.getPaqueteEscogido())
                .experiencia(reserva.getExperiencia().getNombreExperiencia())
                .datosUsuario(Mapper.convertUsuarioEntityToDto(reserva.getUsuario()))
                .build();
    }
    

}
