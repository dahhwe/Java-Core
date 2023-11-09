package ru.second.JavaCore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Главный класс, запускающий приложение.
 */
public class Main {

    /**
     * Точка входа в приложение.
     * 
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        // Создание контекста приложения на основе аннотаций
        ApplicationContext context = new AnnotationConfigApplicationContext("ru.second.JavaCore");
        
        // Получение бина ConsoleApplication из контекста
        ConsoleApplication consoleApplication = context.getBean(ConsoleApplication.class);
        
        // Запуск приложения
        consoleApplication.run();
    }
}