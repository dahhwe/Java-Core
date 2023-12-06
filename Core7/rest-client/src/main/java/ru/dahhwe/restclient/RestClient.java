package ru.dahhwe.restclient;

import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import ru.dahhwe.restclient.models.Furniture;

@Component
public class RestClient {

    private final RestTemplate restTemplate;
    private static final String BASE_URL = "http://localhost:8080/api/furniture";

    public RestClient() {
        this.restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(
                new BasicAuthenticationInterceptor("admin", "admin"));
    }

    // Получение всех объектов
    public void getAllFurniture() {
        ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL, String.class);
        System.out.println(response.getBody());
    }

    // Получение объекта по ID
    public void getFurnitureById(int id) {
        ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL + "/" + id, String.class);
        System.out.println(response.getBody());
    }

    // Добавление нового объекта
    public void addFurniture(Furniture furniture) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Furniture> request = new HttpEntity<>(furniture, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(BASE_URL, request, String.class);
        System.out.println(response.getBody());
    }

    // Обновление объекта
    public void updateFurniture(int id, Furniture furniture) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Furniture> request = new HttpEntity<>(furniture, headers);

        restTemplate.put(BASE_URL + "/" + id, request);
    }

    // Удаление объекта
    public void deleteFurniture(int id) {
        restTemplate.delete(BASE_URL + "/" + id);
    }

    public void run() {
        System.out.println("\n========== Получение всех мебельных объектов ==========");
        getAllFurniture();

        // Идентификатор существующего объекта (например, стула)
        int testId = 2; // ID стула из init.sql

        System.out.println("\n========== Получение информации о конкретной мебели (ID: " + testId + ") ==========");
        // Получение информации о стуле
        getFurnitureById(testId);

         System.out.println("\n========== Обновление информации о мебели ==========");
         Furniture updatedFurniture = new Furniture("Updated Chair", "metal", "Modern", 5500.0, 5);
         updatedFurniture.setId(testId);
         updateFurniture(testId, updatedFurniture);

        System.out.println("\n========== Получение всех мебельных объектов после обновления ==========");
        getAllFurniture();

         System.out.println("\n========== Удаление мебельного объекта ==========");
         deleteFurniture(7); // Удаление, например, книжного шкафа
    }
}