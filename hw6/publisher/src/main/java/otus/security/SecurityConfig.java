package otus.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Slf4j
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig  {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable()) // Disable CORS
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/register","/validate","/health/", "/", "/login", "/actuator/**").permitAll()
                        .requestMatchers("/user/*").authenticated()
                        .anyRequest().authenticated()
                )
//                .securityMatcher("/register*","/validate*","/health/").
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .securityMatcher("/user/**")
        ;
//        http.addFilterAfter(new SecurityFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

//    @Bean
//    public PrincipalExtractor srvPrincipalExtractor() {
//        return new SrvPrincipalExtractor();
//    }

//
////                // Configures logout settings
////                .logout(logout -> logout
////                        .logoutSuccessUrl("/") // Redirects to the root URL on successful logout
////                        .invalidateHttpSession(true) // Invalidates session to clear session data
////                        .clearAuthentication(true) // Clears authentication details
////                        .deleteCookies("JSESSIONID") // Deletes the session cookie
////                );

//
//    @Bean
//    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
//        return new SecurityEvaluationContextExtension();
//    }
}
