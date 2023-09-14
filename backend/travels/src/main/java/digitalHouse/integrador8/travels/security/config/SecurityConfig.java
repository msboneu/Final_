package digitalHouse.integrador8.travels.security.config;

import digitalHouse.integrador8.travels.security.filters.ExceptionHandlerFilter;
import digitalHouse.integrador8.travels.security.filters.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.OPTIONS, "*").permitAll()
                .requestMatchers(HttpMethod.POST,"/autenticacion/**").permitAll() // probando el http method con post
                .requestMatchers(HttpMethod.POST, "/experiencia/guardar/**").hasAuthority("ADMIN")
                .requestMatchers("/registrar").permitAll()
	            .requestMatchers("/confirmar-cuenta/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/categoria/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "reserva/**").hasAnyAuthority("ADMIN", "USER")
                .requestMatchers(HttpMethod.PUT, "experiencia/calificar/**").permitAll()
                .requestMatchers(HttpMethod.GET).permitAll()
                .anyRequest()//authenticated() prueba
                .permitAll()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new ExceptionHandlerFilter(), JwtAuthenticationFilter.class); // si no funciona cambiar por JWTAuthenticationFilterClass
        return http.build();
    }
}
