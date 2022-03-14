package ru.job4j.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.models.Accident;
import ru.job4j.models.AccidentType;
import ru.job4j.repositories.AccidentMem;

@Controller
public class AccidentControl {
    private final AccidentMem accidents;

    public AccidentControl(AccidentMem accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", accidents.getAccidentTypes());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident) {
        accident.setType(accidents.findAccidentTypeById(accident.getType().getId()));
        accidents.create(accident);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("accident", accidents.findAccidentById(id));
        model.addAttribute("types", accidents.getAccidentTypes());
        return "update";
    }
}