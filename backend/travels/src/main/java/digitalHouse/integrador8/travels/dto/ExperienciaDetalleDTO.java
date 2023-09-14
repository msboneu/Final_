package digitalHouse.integrador8.travels.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExperienciaDetalleDTO {
	
	    @NonNull
        private Long id;
	    @NonNull
	    private String nombreExperiencia;
		@NonNull
		private List<String> imagenes;
	    @NonNull
	    private String descripcion;
	    @NonNull
	    private Double calificacion = 5.0;
	    @NonNull
	    private String categoria;
	    @NonNull
	    private String destino;
	    @NonNull
	    private Double precioBasico;
	    @NonNull
	    private Double precioPremium;
	    @NonNull
	    private List<String> serviciosBasico;
	    @NonNull
	    private List<String> serviciosPremium;
		@NonNull
		private Integer duracionDias;
		@NonNull
		private Integer cupoMaximo;
}
