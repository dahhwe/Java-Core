package ru.dahhwe.lab8.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dahhwe.lab8.models.Furniture;
import ru.dahhwe.lab8.services.FurnitureService;

import java.util.List;

@RestController
@RequestMapping("/api/furniture")
public class FurnitureRestController {

    private final FurnitureService furnitureService;

    @Autowired
    public FurnitureRestController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @GetMapping
    public ResponseEntity<List<Furniture>> getAllFurniture() {
        List<Furniture> furniture = furnitureService.findAll();
        return ResponseEntity.ok(furniture);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Furniture> getFurnitureById(@PathVariable Integer id) {
        Furniture furniture = furnitureService.findbyId(id);
        return furniture != null ? ResponseEntity.ok(furniture) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Furniture> createFurniture(@RequestBody Furniture furniture) {
        Furniture savedFurniture = furnitureService.save(furniture);
        return new ResponseEntity<>(savedFurniture, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Furniture> updateFurniture(@PathVariable Integer id, @RequestBody Furniture furniture) {
        Furniture existingFurniture = furnitureService.findbyId(id);
        if (existingFurniture != null) {
            furniture.setId(id);
            Furniture updatedFurniture = furnitureService.save(furniture);
            return ResponseEntity.ok(updatedFurniture);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFurniture(@PathVariable Integer id) {
        Furniture furniture = furnitureService.findbyId(id);
        if (furniture != null) {
            furnitureService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/buy")
    public ResponseEntity<Void> buyFurniture(@PathVariable Integer id) {
        Furniture furniture = furnitureService.findbyId(id);
        if (furniture != null) {
            System.out.println("User wants to buy furniture with id " + id + ". Furniture details: " + furniture);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
