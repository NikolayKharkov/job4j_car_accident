package ru.job4j.repositories.data;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.models.Authority;

public interface AuthorityRepository extends CrudRepository<Authority, Integer> {
    Authority findByAuthority(String authority);
}
