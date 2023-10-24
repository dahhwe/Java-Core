package ru.second.JavaCore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureService {

    @Autowired
    private FurnitureDao furnitureDao;

    public void addFurniture(Furniture furniture) {
        furnitureDao.addFurniture(furniture);
    }

    public List<Furniture> getAllFurniture() {
        return furnitureDao.getAllFurniture();
    }

    public void updateFurniture(Integer id, Furniture updatedFurniture) {
        furnitureDao.updateFurniture(id, updatedFurniture);
    }

    public void deleteFurniture(Integer id) {
        furnitureDao.deleteFurniture(id);
    }

    public List<Furniture> searchFurniture(String field, String value) {
        return furnitureDao.searchFurniture(field, value);
    }
}
