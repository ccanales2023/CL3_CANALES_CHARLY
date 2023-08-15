package pe.edu.cibertec.CL3_CHARLY_CANALES;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import pe.edu.cibertec.CL3_CHARLY_CANALES.repositories.UserRepository;
import pe.edu.cibertec.CL3_CHARLY_CANALES.services.MyUserDetailsService;


@Configuration
public class SecurityConfiguration {
    

    @Bean
    public UserDetailsService getUserDetailsService(UserRepository userRepository) {
        return new MyUserDetailsService(userRepository);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

     @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
            .authorizeHttpRequests(authorizeHttpRequests -> 
                authorizeHttpRequests
                    .requestMatchers("/nosotros", "/" , "empleados").permitAll()
                    .requestMatchers("/Registrar", "/Actualizar", "/Eliminar", "/**").authenticated()
                    
                )
            .formLogin(formLogin -> 
                formLogin.loginPage("/login")
                    .permitAll())
            .build();
    }
}

