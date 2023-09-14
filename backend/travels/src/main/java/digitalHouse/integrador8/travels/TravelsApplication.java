package digitalHouse.integrador8.travels;

import digitalHouse.integrador8.travels.entity.Rol;
import digitalHouse.integrador8.travels.entity.Servicios;
import digitalHouse.integrador8.travels.entity.Usuario;
import digitalHouse.integrador8.travels.layers.repository.ServiciosRepository;
import digitalHouse.integrador8.travels.layers.repository.UsuarioRepository;
import digitalHouse.integrador8.travels.layers.service.ListarFechasOcupadasPorExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TravelsApplication implements CommandLineRunner {
	@Autowired
	ServiciosRepository serviciosRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	ListarFechasOcupadasPorExperienciaService listarReservasDisponiblesPorExperiencia;

	public static void main(String[] args) {
		SpringApplication.run(TravelsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if (serviciosRepository.findAll().size() == 0) {
			serviciosRepository.save(new Servicios(true, true, true, true, true, true));
			serviciosRepository.save(new Servicios(true, false, false, true, false, true));
		}

		var usuarioAdmin = Usuario.builder()
				.nombre("admin")
				.apellido("admin")
				.email("admin@normad.com")
				.password(passwordEncoder.encode("Normad2023*"))
				.direccion("internet")
				.rol(Rol.ADMIN)
				.build();
		if (usuarioRepository.findAll().size() == 0) {
			usuarioRepository.save(usuarioAdmin);
		}
	}
}
