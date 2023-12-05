package ru.dahhwe.lab7.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.dahhwe.lab7.services.UserService;

/**
 * Контроллер для управления процессом регистрации пользователей.
 */
@Controller // Аннотация, обозначающая, что этот класс является контроллером в MVC паттерне.
public class RegistrationController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    /**
     * Конструктор для внедрения сервиса пользователей и кодировщика паролей.
     *
     * @param userService     Сервис для работы с пользователями.
     * @param passwordEncoder Кодировщик паролей.
     */
    @Autowired
    public RegistrationController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Обработка GET запроса на страницу регистрации.
     *
     * @return Имя шаблона страницы регистрации.
     */
    @GetMapping("/register")
    public String registration() {
        return "furniture/register"; // Возвращает имя шаблона для отображения страницы регистрации.
    }

    /**
     * Обработка POST запроса для регистрации нового пользователя.
     *
     * @param username Имя пользователя.
     * @param password Пароль пользователя.
     * @return Перенаправление на страницу входа после успешной регистрации.
     */
    @PostMapping("/newUser")
    public String registerNewUser(@RequestParam String username, @RequestParam String password) {
        String encodedPassword = passwordEncoder.encode(password); // Кодирование пароля.
        if ("admin".equalsIgnoreCase(username)) {
            // Регистрация пользователя с ролью администратора.
            userService.registerAdmin(username, encodedPassword);
        } else {
            // Регистрация пользователя с обычной ролью.
            userService.registerUser(username, encodedPassword);
        }
        return "redirect:/login"; // Перенаправление на страницу входа.
    }
}
