package ru.job4j.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.models.Accident;
import ru.job4j.repositories.AccidentMem;

import java.util.List;

@Service
public class AccidentService {

    @Autowired
    private AccidentMem accidents;

    public List<Accident> findAll() {
        return accidents.getAccidents();
    }
}
