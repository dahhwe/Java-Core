package ru.dahhwe.lab8.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dahhwe.lab8.models.Role;

import java.util.Optional;

/**
 * Репозиторий для работы с сущностями ролей пользователей.
 */
@Repository // Аннотация указывает, что этот интерфейс является репозиторием в контексте Spring.
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * Поиск роли пользователя по её имени.
     *
     * @param name Имя роли для поиска.
     * @return Optional, содержащий найденную роль или пустой, если роль не найдена.
     */
    Optional<Role> findByName(String name);
}
