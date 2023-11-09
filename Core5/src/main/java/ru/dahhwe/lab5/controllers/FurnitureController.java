package ru.dahhwe.lab5.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.dahhwe.lab5.models.Furniture;
import ru.dahhwe.lab5.services.FurnitureService;

@Controller
@RequestMapping("/furniture")
public class FurnitureController {

    private final FurnitureService furnitureService;

    @Autowired
    public FurnitureController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @GetMapping
    public String index(@RequestParam(name = "name", required = false) String name, Model model) {
        if (name != null) {
            model.addAttribute("furnitures", furnitureService.filterByName(name));
        } else {
            model.addAttribute("furnitures", furnitureService.findAll());
        }
        return "furnitures/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("furniture", furnitureService.findOne(id));
        return "furnitures/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("furniture", furnitureService.findOne(id));
        return "furnitures/edit";
    }

    @GetMapping("/new")
    public String newFurniture(@ModelAttribute("furniture") Furniture furniture) {
        return "furnitures/new";
    }

    @PostMapping()
    public String create(
            @ModelAttribute("furniture") @Valid Furniture furniture,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "furnitures/new";
        }

        furnitureService.save(furniture);
        return "redirect:/furniture";
    }

    @PatchMapping("/{id}")
    public String update(
            @ModelAttribute("furniture") @Valid Furniture furniture,
            BindingResult bindingResult,
            @PathVariable("id") int id
    ) {
        if (bindingResult.hasErrors()) {
            return "furnitures/edit";
        }
        furnitureService.update(id, furniture);
        return "redirect:/furniture";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        furnitureService.delete(id);
        return "redirect:/furniture";
    }

}
