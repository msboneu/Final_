package digitalHouse.integrador8.travels.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "experiencia")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "nombre_experiencia")
    private String nombreExperiencia;

    @NonNull
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "calificacion")
    private Double calificacion;

    @Column(name = "cantidad_calificaciones")
    private Integer cantidadCalificaciones;

    @NonNull
    @Column(name = "cupo_maximo")
    private Integer cupoMaximo;

    @NonNull
    @Column(name = "duracion_dias")
    private Integer duracionDias;

    @OneToMany(mappedBy = "experiencia", cascade = CascadeType.ALL)
    private List<Imagen> imagenes;

    @JsonIgnore
    @OneToMany(mappedBy = "experiencia", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Reserva> reservas;

    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private Categoria categoria;

    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "destino_id", referencedColumnName = "id")
    private Destino destino;

    @OneToMany
    @JoinTable(name = "experiencia_paquete_mapping", joinColumns = {@JoinColumn(name = "experiencia_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "paquete_id", referencedColumnName = "id")})
    @MapKey(name = "nombrePaquete")
    private Map<String, Paquete> paqueteMap;
}
