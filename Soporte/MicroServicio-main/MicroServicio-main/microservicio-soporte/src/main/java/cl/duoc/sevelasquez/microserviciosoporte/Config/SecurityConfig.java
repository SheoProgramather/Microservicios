package cl.duoc.sevelasquez.microserviciosoporte.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)  // Desactiva CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()  // Permite todas las peticiones sin autenticación
                )
                .formLogin(Customizer.withDefaults()) // No elimina la config por defecto (puede omitirse)
                .httpBasic(AbstractHttpConfigurer::disable); // Desactiva la autenticación básica

        return http.build();
    }
}



