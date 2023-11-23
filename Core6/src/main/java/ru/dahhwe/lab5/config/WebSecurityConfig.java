package ru.dahhwe.lab5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.dahhwe.lab5.services.UserDetailsServiceImpl;

/**
 * Конфигурация безопасности веб-приложения.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final UserDetailsServiceImpl userDetailsService;

    /**
     * Конструктор класса конфигурации безопасности.
     *
     * @param userDetailsService Сервис для работы с информацией о пользователях.
     */
    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    /**
     * Создание цепочки фильтров безопасности для конкретных HTTP запросов.
     *
     * @param http Объект для настройки безопасности web-запросов.
     * @return Сконфигурированный объект SecurityFilterChain.
     * @throws Exception Исключение при настройке SecurityFilterChain.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/register", "/login", "/newUser", "/process_login").permitAll()
                        .requestMatchers("/furniture/new", "/furniture/*/edit").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/furniture/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH, "/furniture/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/process_login")
                        .defaultSuccessUrl("/furniture", true)
                        .failureUrl("/login?error"))
                .logout(logout -> logout
                        .logoutSuccessUrl("/login"));

        return http.build();
    }

    /**
     * Создание и настройка менеджера аутентификации.
     *
     * @param http Объект HttpSecurity для настройки аутентификации.
     * @return Сконфигурированный объект AuthenticationManager.
     * @throws Exception Исключение при настройке AuthenticationManager.
     */
    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }

    /**
     * Создание бина кодировщика паролей.
     *
     * @return Экземпляр PasswordEncoder.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        // В продакшене следует использовать более надёжный метод кодирования паролей
        return NoOpPasswordEncoder.getInstance();
    }
}
