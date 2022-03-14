package ru.job4j.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.models.Accident;
import ru.job4j.models.AccidentType;
import ru.job4j.models.Rule;
import ru.job4j.repositories.AccidentMem;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class AccidentControl {
    private final AccidentMem accidents;

    public AccidentControl(AccidentMem accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", accidents.getAccidentTypes());
        model.addAttribute("rules", accidents.getRules());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        accident.setRules(
                Arrays.stream(req.getParameterValues("rIds"))
                .map(id -> accidents.findRuleById(Integer.parseInt(id)))
                .collect(Collectors.toSet()));
        accident.setType(accidents.findAccidentTypeById(accident.getType().getId()));
        accidents.create(accident);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("accident", accidents.findAccidentById(id));
        model.addAttribute("types", accidents.getAccidentTypes());
        model.addAttribute("rules", accidents.getRules());
        return "update";
    }
}