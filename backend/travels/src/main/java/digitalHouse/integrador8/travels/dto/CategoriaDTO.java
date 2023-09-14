package digitalHouse.integrador8.travels.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoriaDTO {
	
	private Long id;
	
	@NonNull
	private String tipoExperiencia;
	
	@NonNull
	private String descripcion;
	
	@NonNull
	private String urlImagen;
}
