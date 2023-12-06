package ru.dahhwe.restclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RestClientApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RestClientApplication.class, args);
        RestClient client = context.getBean(RestClient.class);
        client.run();
    }
}
