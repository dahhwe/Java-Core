package ru.dahhwe.lab5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dahhwe.lab5.models.Furniture;

import java.util.List;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture, Integer> {

    List<Furniture> findByNameContains(String name);

}

