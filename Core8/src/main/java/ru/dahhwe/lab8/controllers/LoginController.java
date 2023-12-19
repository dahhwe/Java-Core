package ru.dahhwe.lab8.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Контроллер для обработки запросов аутентификации.
 */
@Controller // Аннотация, указывающая, что этот класс является веб-контроллером.
public class LoginController {

    /**
     * Обрабатывает GET запросы для страницы входа в систему.
     *
     * @return Путь к шаблону страницы входа.
     */
    @GetMapping("/login")
    public String login() {
        return "furniture/login"; // Возвращает имя представления для отображения страницы входа.
    }
}
