//package digitalHouse.integrador8.travels.layers.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import digitalHouse.integrador8.travels.entity.Usuario;
//import digitalHouse.integrador8.travels.layers.repository.UsuarioRepository;
//import digitalHouse.integrador8.travels.layers.service.RegistrarUsuarioService;
//
//@CrossOrigin("*")
//@RestController
//public class RegistrarUsuarioController {
//
//	    @Autowired
//	    private RegistrarUsuarioService emailSenderService;
//
//	    @Autowired
//		private UsuarioRepository userRepository;
//
//	    @PostMapping("/registrar")
//	    public ResponseEntity<String> registerUser(@RequestBody Usuario usuario) {
//	        Usuario usuarioExiste = userRepository.findByEmailIgnoreCase(usuario.getEmail());
//	        if (usuarioExiste != null) {
//	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El correo ya existe!");
//	        } else {
//	        	emailSenderService.enviarEmail(usuario);
//	            return ResponseEntity.ok("Usuario registrado correctamente.");
//	        }
//	    }
//
//	@GetMapping("/confirmar-cuenta")
//	public ResponseEntity<String> confirmUserAccount(@RequestParam("token") String confirmationToken) {
//		boolean accountVerified = emailSenderService.confirmarRegistro(confirmationToken);
//	    if (accountVerified) {
//	        return ResponseEntity.ok("Cuenta verificada!");
//	    } else {
//	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hay problemas con el link.");
//	    }
//	}
//}
