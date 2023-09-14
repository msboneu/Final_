package digitalHouse.integrador8.travels.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExperienciaDTO2 {

    @NonNull
    private String nombreExperiencia;
    @NonNull
    private String categoria;
    @NonNull
    private String destino;
    @NonNull
    private Double precioBasico;
    @NonNull
    private Double precioPremium;
    @NonNull
    private String descripcion;
    @NonNull
    private List<String> urlImagenes;
    @NonNull
    private Integer cupoMaximo;
    @NonNull
    private Integer duracionDias;
}
