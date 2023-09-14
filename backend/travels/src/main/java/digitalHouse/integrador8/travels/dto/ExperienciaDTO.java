package digitalHouse.integrador8.travels.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExperienciaDTO {
	
    private Long id;

    @NonNull
    private String nombreExperiencia;

    @NonNull
    private String categoria;

    @NonNull
    private String destino;
    
    @NonNull
    private String urlImagen;

    @NonNull
    private Double precioBasico;

    @NonNull
    private Double precioPremium;

    @NonNull
    private String descripcion;
    @NonNull
    private Integer cupoMaximo;
    @NonNull
    private Integer duracionDias;
}
