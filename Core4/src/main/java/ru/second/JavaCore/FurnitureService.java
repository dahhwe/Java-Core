package ru.second.JavaCore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис для работы с мебелью.
 */
@Service
public class FurnitureService {

    @Autowired
    private FurnitureDao furnitureDao;

    /**
     * Добавляет новую мебель в базу данных.
     * @param furniture мебель для добавления.
     */
    public void addFurniture(Furniture furniture) {
        furnitureDao.addFurniture(furniture);
    }

    /**
     * Возвращает список всех мебельных предметов из базы данных.
     * @return список мебели.
     */
    public List<Furniture> getAllFurniture() {
        return furnitureDao.getAllFurniture();
    }

    /**
     * Обновляет информацию о мебели по идентификатору.
     * @param id идентификатор мебели для обновления.
     * @param updatedFurniture обновленная информация о мебели.
     */
    public void updateFurniture(Integer id, Furniture updatedFurniture) {
        furnitureDao.updateFurniture(id, updatedFurniture);
    }

    /**
     * Удаляет мебель из базы данных по идентификатору.
     * @param id идентификатор мебели для удаления.
     */
    public void deleteFurniture(Integer id) {
        furnitureDao.deleteFurniture(id);
    }

    /**
     * Осуществляет поиск мебели по заданному полю и значению.
     * @param field поле для поиска.
     * @param value значение для поиска.
     * @return список мебели, соответствующий критериям поиска.
     */
    public List<Furniture> searchFurniture(String field, String value) {
        return furnitureDao.searchFurniture(field, value);
    }
}