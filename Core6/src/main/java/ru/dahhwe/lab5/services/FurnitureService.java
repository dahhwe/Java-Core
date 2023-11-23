package ru.dahhwe.lab5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dahhwe.lab5.models.Furniture;
import ru.dahhwe.lab5.repositories.FurnitureRepository;

import java.util.List;

/**
 * Сервис для работы с мебелью.
 */
@Service
@Transactional(readOnly = true)
public class FurnitureService {
    private final FurnitureRepository repository;

    /**
     * Конструктор для внедрения зависимости репозитория мебели.
     *
     * @param repository Репозиторий мебели.
     */
    @Autowired
    public FurnitureService(FurnitureRepository repository) {
        this.repository = repository;
    }

    /**
     * Получает все записи мебели.
     *
     * @return Список мебели.
     */
    public List<Furniture> findAll() {
        return repository.findAll();
    }

    /**
     * Находит мебель по идентификатору.
     *
     * @param id Идентификатор мебели.
     * @return Найденная мебель или null, если мебель не найдена.
     */
    public Furniture findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Сохраняет новую запись мебели.
     *
     * @param furniture Объект мебели для сохранения.
     */
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void save(Furniture furniture) {
        repository.save(furniture);
    }

    /**
     * Обновляет информацию о мебели.
     *
     * @param id        Идентификатор мебели.
     * @param furniture Объект мебели для обновления.
     */
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void update(int id, Furniture furniture) {
        furniture.setId(id);
        repository.save(furniture);
    }

    /**
     * Удаляет мебель по идентификатору.
     *
     * @param id Идентификатор мебели для удаления.
     */
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void delete(int id) {
        repository.deleteById(id);
    }

    /**
     * Проверяет отсутствие мебели в базе данных по идентификатору.
     *
     * @param id Идентификатор мебели для проверки.
     * @return true, если мебель отсутствует, иначе false.
     */
    public boolean doesNotExist(int id) {
        return !repository.existsById(id);
    }

    /**
     * Фильтрует мебель по имени.
     *
     * @param name Имя для фильтрации мебели.
     * @return Список мебели, соответствующей заданному имени.
     */
    public List<Furniture> filterByName(String name) {
        return repository.findByNameContains(name);
    }
}
