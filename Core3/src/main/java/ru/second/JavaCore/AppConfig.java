package ru.second.JavaCore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

/**
 * Конфигурационный класс Spring.
 */
@Configuration
public class AppConfig {

    /**
     * Значение процессора, получаемое из внешних свойств.
     */
    @Value("${processor}")
    private String processor;

    /**
     * Значение оперативной памяти, получаемое из внешних свойств.
     */
    @Value("${memory}")
    private String memory;

    /**
     * Значение видеокарты, получаемое из внешних свойств.
     */
    @Value("${videocard}")
    private String videocard;

    /**
     * Значение жесткого диска, получаемое из внешних свойств.
     */
    @Value("${hardDrive}")
    private String hardDrive;

    /**
     * Определяет бин PersonalComputer и внедряет значения из внешних свойств.
     *
     * @return Бин PersonalComputer
     */
    @Bean
    public Computer personalComputer() {
        PersonalComputer pc = new PersonalComputer(processor);
        pc.setMemory(memory);
        pc.setVideocard(videocard);
        pc.setHardDrive(hardDrive);
        return pc;
    }

    /**
     * Определяет бин User, который зависит от бина PersonalComputer.
     *
     * @return Бин User
     */
    @Bean
    public User user() {
        return new User(personalComputer());
    }
}
