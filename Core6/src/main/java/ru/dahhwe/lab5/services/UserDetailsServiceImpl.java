package ru.dahhwe.lab5.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dahhwe.lab5.models.User;
import ru.dahhwe.lab5.repositories.UserRepository;
import ru.dahhwe.lab5.security.UserDetailsImpl;

import java.util.Optional;

/**
 * Сервис для получения UserDetails по имени пользователя.
 */
@Service // Аннотация, указывающая, что этот класс является сервисом в контексте Spring.
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * Конструктор для внедрения репозитория пользователей.
     *
     * @param userRepository Репозиторий для работы с пользователями.
     */
    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Загружает UserDetails, используя имя пользователя.
     *
     * @param username Имя пользователя для загрузки его UserDetails.
     * @return UserDetails пользователя.
     * @throws UsernameNotFoundException Если пользователь не найден.
     */
    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        return new UserDetailsImpl(user.get());
    }
}
