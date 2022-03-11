package ru.job4j.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import ru.job4j.services.AccidentService;

import java.util.Arrays;

@Controller
public class IndexControl {

    @Autowired
    private AccidentService accidentService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("accidents", accidentService.findAll());
        return "index";
    }
}
