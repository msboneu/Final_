//package digitalHouse.integrador8.travels.entity;
//
//import java.util.Date;
//import java.util.UUID;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Table(name = "confirmacion")
//@Getter
//@Setter
//@RequiredArgsConstructor
//@AllArgsConstructor
//public class ConfirmationToken {
//
//	    @Id
//	    @GeneratedValue(strategy = GenerationType.AUTO)
//	    @Column(name="token_id")
//	    private long tokenid;
//
//	    @Column(name="confirmation_token")
//	    private String confirmationToken;
//
//	    @Temporal(TemporalType.TIMESTAMP)
//	    private Date createdDate;
//
//	    @OneToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
//	    @JoinColumn(nullable = false, name = "user_id")
//	    private Usuario user;
//
//	    public ConfirmationToken(Usuario user) {
//	        this.user = user;
//	        createdDate = new Date();
//	        confirmationToken = UUID.randomUUID().toString();
//	    }
//
//}
