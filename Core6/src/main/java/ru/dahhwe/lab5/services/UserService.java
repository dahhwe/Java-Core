package ru.dahhwe.lab5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.dahhwe.lab5.models.Role;
import ru.dahhwe.lab5.models.User;
import ru.dahhwe.lab5.repositories.RoleRepository;
import ru.dahhwe.lab5.repositories.UserRepository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        Role userRole = roleRepository.findByName("User").orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        user.setRoles(Collections.singleton(userRole));
        userRepository.save(user);
    }

    public void registerAdmin(String username, String password) {
        User admin = new User();
        admin.setUsername(username);
        admin.setPassword(passwordEncoder.encode(password));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("User").orElseThrow(() -> new RuntimeException("Error: Role User is not found.")));
        roles.add(roleRepository.findByName("Admin").orElseThrow(() -> new RuntimeException("Error: Role Admin is not found.")));
        admin.setRoles(roles);
        userRepository.save(admin);
    }
}
