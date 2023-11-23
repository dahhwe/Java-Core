package ru.dahhwe.lab5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Основной класс приложения, использующий Spring Boot для запуска и конфигурации.
 */
@SpringBootApplication // Указывает на то, что это основной класс Spring Boot приложения.
public class Lab5Application {

    /**
     * Главная точка входа в приложение.
     *
     * @param args Аргументы командной строки, передаваемые при запуске приложения.
     */
    public static void main(String[] args) {
        // Запускает Spring Boot приложение, используя Lab5Application.class в качестве основного конфигурационного класса.
        SpringApplication.run(Lab5Application.class, args);
    }

}
