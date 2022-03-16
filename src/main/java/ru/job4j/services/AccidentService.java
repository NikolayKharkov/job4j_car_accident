package ru.job4j.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.models.Accident;
import ru.job4j.models.AccidentType;
import ru.job4j.models.Rule;
import ru.job4j.repositories.hb.AccidentHibernate;
import ru.job4j.repositories.hb.RuleHibernate;
import ru.job4j.repositories.hb.TypeHibernate;

import java.util.Arrays;
import java.util.List;

@Service
public class AccidentService {

    @Autowired
    private AccidentHibernate accidentsHb;

    @Autowired
    private RuleHibernate rulesHb;

    @Autowired
    private TypeHibernate typesHb;

    public Accident create(Accident accident, String[] rules) {
        Arrays.stream(rules).map(id -> rulesHb.findRuleById(Integer.parseInt(id))).forEach(accident::addRule);
        return accidentsHb.create(accident);
    }

    public List<Accident> getAccidents() {
        return accidentsHb.getAccidents();
    }

    public List<AccidentType> getAccidentTypes() {
        return typesHb.getAccidentTypes();
    }

    public List<Rule> getRules() {
        return rulesHb.getRules();
    }

    public Accident findAccidentById(int id) {
        return accidentsHb.findAccidentById(id);
    }
}
