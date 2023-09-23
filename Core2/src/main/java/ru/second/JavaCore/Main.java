package ru.second.JavaCore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Главный класс программы
 */
public class Main {
    public static void main(String[] args) {
        // Создаем контекст приложения, загружая конфигурацию из файла applicationContext.xml
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Получаем бин (компонент) с именем "user" из контекста
        User user = (User) context.getBean("user");

        // Вызываем метод startComputer() у объекта user
        user.startComputer();
    }
}
