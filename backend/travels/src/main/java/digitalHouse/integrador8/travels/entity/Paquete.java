package digitalHouse.integrador8.travels.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "paquete")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Paquete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "nombre_paquete")
    private String nombrePaquete;

    @NonNull
    @Column(name = "precio")
    private Double precio;

    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "servicios_id", referencedColumnName = "id")
    private Servicios servicios;
}
