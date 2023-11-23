package ru.dahhwe.lab5.models;

import jakarta.persistence.*;

/**
 * Сущность роли пользователя для использования в контексте безопасности.
 */
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Идентификатор роли.

    private String name; // Имя роли.

    /**
     * Получить идентификатор роли.
     *
     * @return Идентификатор роли.
     */
    public Long getId() {
        return id;
    }

    /**
     * Установить идентификатор роли.
     *
     * @param id Новый идентификатор роли.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Получить имя роли.
     *
     * @return Имя роли.
     */
    public String getName() {
        return name;
    }

    /**
     * Установить имя роли.
     *
     * @param name Новое имя роли.
     */
    public void setName(String name) {
        this.name = name;
    }
}
