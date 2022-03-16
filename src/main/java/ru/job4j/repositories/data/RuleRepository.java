package ru.job4j.repositories.data;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.models.Rule;

public interface RuleRepository extends CrudRepository<Rule, Integer> {
}
