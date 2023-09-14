//package digitalHouse.integrador8.travels.layers.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//import digitalHouse.integrador8.travels.entity.ConfirmationToken;
//import digitalHouse.integrador8.travels.entity.Usuario;
//import digitalHouse.integrador8.travels.layers.repository.ConfirmationTokenRepository;
//import digitalHouse.integrador8.travels.layers.repository.UsuarioRepository;
//
//@Service
//public class RegistrarUsuarioService {
//
//	  private final JavaMailSender javaMailSender;
//
//	  private final UsuarioRepository userRepository;
//
//	  @Autowired
//	  private ConfirmationTokenRepository confirmationTokenRepository;
//
//	  @Autowired
//	  public RegistrarUsuarioService(JavaMailSender javaMailSender, UsuarioRepository userRepository) {
//	    this.javaMailSender = javaMailSender;
//	    this.userRepository = userRepository;
//	  }
//
//	  public void enviarEmail(Usuario user) {
//
//        userRepository.save(user);
//        ConfirmationToken confirmationToken = new ConfirmationToken(user);
//        confirmationTokenRepository.save(confirmationToken);
//
//      	SimpleMailMessage mailMessage = new SimpleMailMessage();
//      	System.out.println(user.getEmail());
//		mailMessage.setTo(user.getEmail());
//		mailMessage.setSubject("Complete Registration!");
//		mailMessage.setText("To confirm your account, please click here : "
//		+"http://localhost:8080/confirmar-cuenta?token="+confirmationToken.getConfirmationToken());
//
//		javaMailSender.send(mailMessage);
//	  }
//
//
//	    public boolean confirmarRegistro(String confirmationToken) {
//	        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
//
//	        if (token != null) {
//	            Usuario user = userRepository.findByEmailIgnoreCase(token.getUser().getEmail());
//	            user.setEnabled(true);
//	            userRepository.save(user);
//	            return true;
//	        } else {
//	            return false;
//	        }
//	    }
//}
