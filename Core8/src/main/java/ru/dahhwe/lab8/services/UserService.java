package ru.dahhwe.lab8.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dahhwe.lab8.models.Role;
import ru.dahhwe.lab8.models.User;
import ru.dahhwe.lab8.repositories.RoleRepository;
import ru.dahhwe.lab8.repositories.UserRepository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Сервис для управления пользователями в приложении.
 */
@Service // Указывает, что класс представляет собой сервисный слой бизнес-логики.
@Transactional // Обозначает, что все методы класса должны выполняться в рамках транзакции.
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Конструктор для внедрения зависимостей репозиториев и кодировщика паролей.
     *
     * @param userRepository Репозиторий для работы с пользователями.
     * @param roleRepository Репозиторий для работы с ролями.
     * @param passwordEncoder Кодировщик паролей.
     */
    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Регистрирует пользователя с ролью "Пользователь".
     *
     * @param username Имя пользователя.
     * @param password Пароль пользователя.
     */
    public void registerUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        user.setRoles(Collections.singleton(userRole));
        userRepository.save(user);
    }

    /**
     * Регистрирует пользователя с ролью "Администратор".
     *
     * @param username Имя пользователя.
     * @param password Пароль пользователя.
     */
    public void registerAdmin(String username, String password) {
        User admin = new User();
        admin.setUsername(username);
        admin.setPassword(passwordEncoder.encode(password));

        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Error: Role User is not found."));
        Role adminRole = roleRepository.findByName("ROLE_ADMIN")
                .orElseThrow(() -> new RuntimeException("Error: Role Admin is not found."));

        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        roles.add(adminRole);
        admin.setRoles(roles);
        userRepository.save(admin);
    }
}