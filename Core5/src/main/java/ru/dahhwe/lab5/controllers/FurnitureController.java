package ru.dahhwe.lab5.controllers;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.dahhwe.lab5.models.Furniture;
import ru.dahhwe.lab5.services.FurnitureService;

/**
 * Контроллер для обработки запросов, связанных с мебелью.
 */
@Controller
@RequestMapping("/furniture")
public class FurnitureController {

    private static final Logger logger = LoggerFactory.getLogger(FurnitureController.class);
    private final FurnitureService furnitureService;

    /**
     * Конструктор для внедрения сервиса мебели.
     *
     * @param furnitureService Сервис для работы с мебелью.
     */
    @Autowired
    public FurnitureController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    /**
     * Показывает список мебели.
     *
     * @param name  Необязательное имя для фильтрации мебели.
     * @param model Модель для передачи данных в представление.
     * @return Имя представления для отображения.
     */
    @GetMapping
    public String listFurniture(@RequestParam(name = "name", required = false) String name, Model model) {
        model.addAttribute("currentPage", "index");
        if (name != null) {
            model.addAttribute("furnitures", furnitureService.filterByName(name));
        } else {
            model.addAttribute("furnitures", furnitureService.findAll());
        }
        return "furnitures/index";
    }

    /**
     * Показывает детали конкретной мебели по идентификатору.
     *
     * @param id    Идентификатор мебели.
     * @param model Модель для передачи данных в представление.
     * @return Имя представления для отображения.
     */
    @GetMapping("/{id}")
    public String viewFurnitureDetails(@PathVariable("id") int id, Model model) {
        model.addAttribute("currentPage", "details");
        Furniture furniture = furnitureService.findOne(id);
        if (furniture != null) {
            model.addAttribute("furniture", furniture);
            return "furnitures/show";
        } else {
            logger.error("Furniture with id {} not found", id);
            model.addAttribute("error", "Furniture not found");
            return "error";
        }
    }

    /**
     * Форма для редактирования мебели.
     *
     * @param id    Идентификатор мебели для редактирования.
     * @param model Модель для передачи данных в представление.
     * @return Имя представления для отображения.
     */
    @GetMapping("/{id}/edit")
    public String editFurnitureForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("currentPage", "edit");
        Furniture furniture = furnitureService.findOne(id);
        if (furniture != null) {
            model.addAttribute("furniture", furniture);
            return "furnitures/edit";
        } else {
            logger.error("Attempted to edit non-existing furniture with id {}", id);
            return "error";
        }
    }

    /**
     * Форма для создания новой мебели.
     *
     * @param model Модель для передачи данных в представление.
     * @return Имя представления для отображения.
     */
    @GetMapping("/new")
    public String newFurnitureForm(Model model) {
        model.addAttribute("currentPage", "new");
        model.addAttribute("furniture", new Furniture());
        return "furnitures/new";
    }

    /**
     * Создает новую запись мебели.
     *
     * @param furniture          Объект мебели для создания.
     * @param bindingResult      Результат привязки для обработки ошибок.
     * @param model              Модель для передачи данных в представление.
     * @param redirectAttributes Атрибуты для передачи данных при перенаправлении.
     * @return Перенаправление на список мебели.
     */
    @PostMapping
    public String createFurniture(@ModelAttribute("furniture") @Valid Furniture furniture,
                                  BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("currentPage", "new");
            return "furnitures/new";
        }
        furnitureService.save(furniture);
        redirectAttributes.addFlashAttribute("message", "Furniture successfully added.");
        return "redirect:/furniture";
    }

    /**
     * Обновляет существующую запись мебели.
     *
     * @param furniture     Объект мебели для обновления.
     * @param bindingResult Результат привязки для обработки ошибок.
     * @param id            Идентификатор мебели для обновления.
     * @param model         Модель для передачи данных в представление.
     * @return Перенаправление на список мебели.
     */
    @PutMapping("/{id}")
    public String updateFurniture(@ModelAttribute("furniture") @Valid Furniture furniture,
                                  BindingResult bindingResult, @PathVariable("id") int id, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("currentPage", "edit");
            return "furnitures/edit";
        }
        if (furnitureService.doesNotExist(id)) {
            logger.error("Attempted to update non-existing furniture with id {}", id);
            return "error";
        }
        furnitureService.update(id, furniture);
        return "redirect:/furniture";
    }

    /**
     * Удаляет запись мебели.
     *
     * @param id Идентификатор мебели для удаления.
     * @return Перенаправление на список мебели.
     */
    @DeleteMapping("/{id}")
    public String deleteFurniture(@PathVariable("id") int id) {
        if (furnitureService.doesNotExist(id)) {
            logger.error("Attempted to delete non-existing furniture with id {}", id);
            return "error";
        }
        furnitureService.delete(id);
        return "redirect:/furniture";
    }
}
