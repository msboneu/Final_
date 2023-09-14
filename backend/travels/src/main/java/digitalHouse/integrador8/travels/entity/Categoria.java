package digitalHouse.integrador8.travels.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "categoria")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "tipo_experiencia")
    private String tipoExperiencia;

    @NonNull
    @OneToOne(mappedBy = "categoria", cascade = CascadeType.ALL)
    private ImagenCategoria imagenCategoria;
    
    @NonNull
    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @JsonIgnore
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    List<Experiencia> experiencias;

}
