package ru.dahhwe.lab7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Основной класс приложения, использующий Spring Boot для запуска и конфигурации.
 */
@SpringBootApplication // Указывает на то, что это основной класс Spring Boot приложения.
public class Lab7Application {

    /**
     * Главная точка входа в приложение.
     *
     * @param args Аргументы командной строки, передаваемые при запуске приложения.
     */
    public static void main(String[] args) {
        // Запускает Spring Boot приложение, используя Lab5Application.class в качестве основного конфигурационного класса.
        SpringApplication.run(Lab7Application.class, args);
    }
}
