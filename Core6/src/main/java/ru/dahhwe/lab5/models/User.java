package ru.dahhwe.lab5.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Сущность "Пользователь" для использования в контексте аутентификации и авторизации.
 */
@Entity // Указывает, что класс является сущностью JPA.
@Table(name = "users") // Указывает на имя таблицы, где будут храниться данные о пользователях.
public class User {
    @Id // Указывает на первичный ключ сущности.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Стратегия генерации идентификаторов.
    private Long id; // Идентификатор пользователя.

    private String username; // Имя пользователя.
    private String password; // Пароль пользователя.

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>(); // Коллекция ролей, связанных с пользователем.

    /**
     * Получить идентификатор пользователя.
     *
     * @return Идентификатор пользователя.
     */
    public Long getId() {
        return id;
    }

    /**
     * Установить идентификатор пользователя.
     *
     * @param id Новый идентификатор пользователя.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Получить имя пользователя.
     *
     * @return Имя пользователя.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Установить имя пользователя.
     *
     * @param username Новое имя пользователя.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Получить пароль пользователя.
     *
     * @return Пароль пользователя.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Установить пароль пользователя.
     *
     * @param password Новый пароль пользователя.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Получить набор ролей пользователя.
     *
     * @return Набор ролей пользователя.
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Установить набор ролей пользователя.
     *
     * @param roles Набор новых ролей пользователя.
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
