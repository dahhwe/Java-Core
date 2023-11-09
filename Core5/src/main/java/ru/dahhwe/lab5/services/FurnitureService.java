package ru.dahhwe.lab5.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dahhwe.lab5.models.Furniture;
import ru.dahhwe.lab5.repository.FurnitureRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class FurnitureService {
    FurnitureRepository repository;

    @Autowired
    public FurnitureService(FurnitureRepository repository) {
        this.repository = repository;
    }

    /**
     * Получает все музыкальные инструменты.
     *
     * @return список музыкальных инструментов
     */
    public List<Furniture> findAll() {
        return repository.findAll();
    }

    /**
     * Находит музыкальный инструмент по идентификатору.
     *
     * @param id идентификатор инструмента
     * @return найденный инструмент или null, если не найден
     */
    public Furniture findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Сохраняет новый музыкальный инструмент.
     *
     * @param furniture объект музыкального инструмента
     */
    @Transactional
    public void save(Furniture furniture) {
        repository.save(furniture);
    }

    /**
     * Обновляет информацию о музыкальном инструменте.
     *
     * @param id        идентификатор инструмента
     * @param furniture объект музыкального инструмента
     */
    @Transactional
    public void update(int id, Furniture furniture) {
        furniture.setId(id);
        repository.save(furniture);
    }

    /**
     * Удаляет музыкальный инструмент по идентификатору.
     *
     * @param id идентификатор инструмента
     */
    @Transactional
    public void delete(int id) {
        repository.deleteById(id);
    }

    public List<Furniture> filterByName(String name) {
        return repository.findByNameContains(name);
    }

}
