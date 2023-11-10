package ru.dahhwe.lab5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dahhwe.lab5.models.Furniture;

import java.util.List;

/**
 * Репозиторий для работы с сущностями мебели.
 */
@Repository
public interface FurnitureRepository extends JpaRepository<Furniture, Integer> {

    // Находит все записи мебели, имя которых содержит заданную подстроку.
    List<Furniture> findByNameContains(String name);

}
