package digitalHouse.integrador8.travels.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@Entity
@Table(name = "reserva")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @NonNull
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @NonNull
    @Column(name = "cantidad_cupos")
    private Integer cantidadCupos;

    @NonNull
    @Column(name = "precio_total")
    private Double precioTotal;

    @NonNull
    @Column(name = "paquete_escogido")
    private String paqueteEscogido;

    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "experiencia_id", referencedColumnName = "id")
    private Experiencia experiencia;
}
