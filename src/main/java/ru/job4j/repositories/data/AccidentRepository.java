package ru.job4j.repositories.data;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.models.Accident;

import java.util.List;

public interface AccidentRepository extends CrudRepository<Accident, Integer> {
    @EntityGraph(value = "Accident.rules")
    List<Accident> findAll();

    @EntityGraph(value = "Accident.rules")
    Accident findById(int id);
}