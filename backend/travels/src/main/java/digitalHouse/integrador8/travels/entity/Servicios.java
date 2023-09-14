package digitalHouse.integrador8.travels.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "servicios")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Servicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "tiquetes")
    private Boolean tiquetes;

    @NonNull
    @Column(name = "traslados")
    private Boolean traslado;

    @NonNull
    @Column(name = "alimentacion_completa")
    private Boolean alimentacionCompleta;

    @NonNull
    @Column(name = "desayuno")
    private Boolean desayuno;

    @NonNull
    @Column(name = "seguro_medico")
    private Boolean seguroMedico;

    @NonNull
    @Column(name = "hospedaje")
    private Boolean hospedaje;
}
