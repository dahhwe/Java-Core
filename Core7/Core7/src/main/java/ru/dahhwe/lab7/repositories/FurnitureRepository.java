package ru.dahhwe.lab7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dahhwe.lab7.models.Furniture;

import java.util.List;

/**
 * Репозиторий для работы с сущностями мебели, предоставляющий операции CRUD и поиска.
 */
@Repository
public interface FurnitureRepository extends JpaRepository<Furniture, Integer> {

    /**
     * Поиск записей мебели, имя которых содержит заданную подстроку.
     *
     * @param name Подстрока для поиска в имени мебели.
     * @return Список мебели, соответствующей критериям поиска.
     */
    List<Furniture> findByNameContains(String name);
}
