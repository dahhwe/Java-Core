package ru.dahhwe.lab5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dahhwe.lab5.models.User;

import java.util.Optional;

/**
 * Репозиторий для работы с сущностями пользователей, предоставляющий операции CRUD и поиска.
 */
@Repository // Аннотация указывает, что этот интерфейс является репозиторием в контексте Spring.
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Находит пользователя по его имени пользователя.
     *
     * @param username Имя пользователя для поиска.
     * @return Optional, содержащий объект пользователя, если он найден, или пустой Optional, если пользователя нет.
     */
    Optional<User> findByUsername(String username);
}
