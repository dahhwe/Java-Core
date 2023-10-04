package ru.second.JavaCore;

/**
 * Класс пользователя, который имеет компьютер
 */
public class User {
    /**
     * Объект, который хранит компьютер пользователя
     */
    private final Computer computer;

    /**
     * Конструктор класса
     *
     * @param computer компьютер, который принадлежит пользователю
     */
    public User(Computer computer) {
        this.computer = computer;
    }

    /**
     * Метод, который запускает компьютер пользователя
     */
    public void startComputer() {
        computer.compute();
    }
}
