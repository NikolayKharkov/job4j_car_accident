package ru.job4j.repositories.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.models.Accident;

import java.util.List;
import java.util.Optional;

public interface AccidentRepository extends CrudRepository<Accident, Integer> {

    @Query("select distinct a from Accident a join fetch a.rules where a.id = ?1")
    Optional<Accident> findByIdWithJoinFetch(int id);

    @Query("select distinct a from Accident a join fetch a.rules")
    List<Accident> findAllWithJoinFetch();
}