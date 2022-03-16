package ru.job4j.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.models.Accident;
import ru.job4j.models.AccidentType;
import ru.job4j.models.Rule;
import ru.job4j.repositories.data.AccidentRepository;
import ru.job4j.repositories.data.RuleRepository;
import ru.job4j.repositories.data.TypeRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class AccidentService {

    @Autowired
    private AccidentRepository accidentRepository;

    @Autowired
    private RuleRepository ruleRepository;

    @Autowired
    private TypeRepository typeRepository;

    public Accident create(Accident accident, String[] rules) {
        Arrays.stream(rules).map(id -> ruleRepository.findById(Integer.parseInt(id)).get()).forEach(accident::addRule);
        return accidentRepository.save(accident);
    }

    public List<Accident> getAccidents() {
        return (List<Accident>) accidentRepository.findAll();
    }

    public List<AccidentType> getAccidentTypes() {
        return (List<AccidentType>) typeRepository.findAll();
    }

    public List<Rule> getRules() {
        return (List<Rule>) ruleRepository.findAll();
    }

    public Accident findAccidentById(int id) {
        return accidentRepository.findById(id);
    }
}
