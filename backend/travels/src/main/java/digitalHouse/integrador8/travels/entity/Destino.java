package digitalHouse.integrador8.travels.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "destino")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "nombre_destino")
    private String nombreDestino;

    @JsonIgnore
    @OneToMany(mappedBy = "destino", cascade = CascadeType.ALL)
    List<Experiencia> experiencias;
}
