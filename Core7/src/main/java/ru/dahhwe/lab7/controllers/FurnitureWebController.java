package ru.dahhwe.lab7.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.dahhwe.lab7.models.Furniture;
import ru.dahhwe.lab7.services.FurnitureService;

import java.util.List;

@Controller
@RequestMapping("/furniture")
public class FurnitureWebController {

    private final FurnitureService furnitureService;

    @Autowired
    public FurnitureWebController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @GetMapping
    public String showFurnitureList(Model model) {
        List<Furniture> allFurniture = furnitureService.findAll();
        model.addAttribute("furniture", allFurniture);
        return "furniture/index";
    }

    @GetMapping("/{id}")
    public String showFurnitureDetails(@PathVariable("id") Integer id, Model model) {
        Furniture furniture = furnitureService.findbyId(id);
        if (furniture != null) {
            model.addAttribute("furniture", furniture);
            return "furniture/details";
        } else {
            return "redirect:/furniture";
        }
    }

    @GetMapping("/new")
    public String showNewFurnitureForm(Model model) {
        model.addAttribute("furniture", new Furniture());
        return "furniture/new";
    }

    @PostMapping
    public String createFurniture(@ModelAttribute Furniture furniture, RedirectAttributes redirectAttributes) {
        Furniture savedFurniture = furnitureService.save(furniture);
        redirectAttributes.addFlashAttribute("success", "Furniture created successfully!");
        return "redirect:/furniture";
    }

    @GetMapping("/{id}/edit")
    public String showEditFurnitureForm(@PathVariable("id") Integer id, Model model) {
        Furniture furniture = furnitureService.findbyId(id);
        if (furniture != null) {
            model.addAttribute("furniture", furniture);
            return "furniture/edit";
        } else {
            return "redirect:/furniture";
        }
    }


    @PostMapping("/{id}/update")
    public String updateFurniture(@PathVariable("id") Integer id,
                                  @ModelAttribute Furniture furniture,
                                  RedirectAttributes redirectAttributes) {
        furniture.setId(id);
        furnitureService.save(furniture);
        redirectAttributes.addFlashAttribute("success", "Furniture updated successfully!");
        return "redirect:/furniture";
    }

    @PostMapping("/{id}/delete")
    public String deleteFurniture(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        furnitureService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Furniture deleted successfully!");
        return "redirect:/furniture";
    }
}
