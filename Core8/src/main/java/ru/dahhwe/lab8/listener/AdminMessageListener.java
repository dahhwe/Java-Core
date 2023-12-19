package ru.dahhwe.lab8.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class AdminMessageListener {

    @JmsListener(destination = "adminQueue")
    public void listener(String message) {
        System.out.println("Message received: " + message);
    }
}
