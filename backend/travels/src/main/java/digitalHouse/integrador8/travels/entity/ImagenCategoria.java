package digitalHouse.integrador8.travels.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "imagen_categoria")
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class ImagenCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "url_imagen")
    private String urlImagen;

    @NonNull
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private Categoria categoria;
}
