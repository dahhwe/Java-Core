package ru.second.JavaCore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("ru.second.JavaCore");
        ConsoleApplication consoleApplication = context.getBean(ConsoleApplication.class);
        consoleApplication.run();
    }
}
