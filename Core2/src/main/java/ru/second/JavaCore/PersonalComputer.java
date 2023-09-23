package ru.second.JavaCore;

/**
 * Класс, представляющий персональный компьютер и реализующий интерфейс Computer
 */
public class PersonalComputer implements Computer {
    /**
     * Название процессора
     */
    private String processor;
    /**
     * Оперативная память
     */
    private String memory;
    /**
     * Видеокарта
     */
    private String videocard;
    /**
     * Жесткий диск
     */
    private String hardDrive;

    /**
     * Конструктор класса PersonalComputer, принимающий процессор в качестве параметра
     *
     * @param processor Название процессора
     */
    public PersonalComputer(String processor) {
        this.processor = processor;
    }

    /**
     * Устанавливает характеристики процессора
     *
     * @param processor Название процессора
     */
    public void setProcessor(String processor) {
        this.processor = processor;
    }

    /**
     * Устанавливает характеристики оперативной памяти
     *
     * @param memory Оперативная память
     */
    public void setMemory(String memory) {
        this.memory = memory;
    }

    /**
     * Устанавливает характеристики видеокарты
     *
     * @param videocard Видеокарта
     */
    public void setVideocard(String videocard) {
        this.videocard = videocard;
    }

    /**
     * Устанавливает характеристики жесткого диска
     *
     * @param hardDrive Жесткий диск
     */
    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    // Реализация метода compute() из интерфейса Computer
    public void compute() {
        System.out.println("Вычисления на компьютере с процессором " + processor + ", памятью " + memory + ", видеокартой " + videocard + " и жестким диском " + hardDrive);
    }
}
