package by.tms.music.security;

import by.tms.music.security.filter.CustomAccessDeniedHandler;
import by.tms.music.security.filter.JwtAuthenticationFilter;
import by.tms.music.security.filter.RestAuthenticationEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
@EnableMethodSecurity
public class JwtSecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    private final CustomAccessDeniedHandler customAccessDeniedHandler;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(authorize -> authorize
                                .requestMatchers(HttpMethod.POST, "/song").hasAuthority("ADMIN")
                                .requestMatchers("/oauth/sign-up").permitAll()
                                .requestMatchers("/oauth/sign-in").permitAll()
                                .requestMatchers(HttpMethod.GET, "/artist/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/artist").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.GET, "/album/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/album/add").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PATCH, "/album/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/album").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/song").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.GET, "/song/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/genre/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/genre/add").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/song/add").hasAuthority("ADMIN")
                                .requestMatchers( "/user").hasAuthority("ADMIN")
                                .requestMatchers( "/user/editPassword").authenticated()
                                .requestMatchers( "/subscription").authenticated()
                                .requestMatchers("/song/favorite").authenticated()
                                .requestMatchers("/session/login").permitAll()
                                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**","/swagger-ui.html").permitAll()
//                        .requestMatchers("/**").permitAll()
                )
                .addFilterBefore(jwtAuthenticationFilter, BasicAuthenticationFilter.class).exceptionHandling(ex -> {
                    ex.authenticationEntryPoint(restAuthenticationEntryPoint);
                    ex.accessDeniedHandler(customAccessDeniedHandler);
                });
        return http.build();

    }


    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
