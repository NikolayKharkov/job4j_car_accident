package ru.job4j.repositories.data;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.models.AccidentType;

public interface TypeRepository extends CrudRepository<AccidentType, Integer> {
}