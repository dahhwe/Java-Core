package ru.second.JavaCore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Главный класс программы
 */
public class Main {
    /**
     * Главный метод приложения
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        // Создаем контекст приложения, загружая конфигурацию из файла applicationContext.xml
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            // Получаем бин (компонент) с именем "user" из контекста
            User user = (User) context.getBean("user");

            // Вызываем метод startComputer() у объекта user
            user.startComputer();
        }
    }
}
