package ru.dahhwe.lab5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.dahhwe.lab5.services.UserService;

@Controller
public class RegistrationController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String registration() {
        return "furnitures/register";
    }

    @PostMapping("/register")
    public String registerNewUser(@RequestParam String username, @RequestParam String password) {
        String encodedPassword = passwordEncoder.encode(password);
        if ("admin".equalsIgnoreCase(username)) {
            userService.registerAdmin(username, encodedPassword);
        } else {
            userService.registerUser(username, encodedPassword);
        }
        return "redirect:/login";
    }
}
