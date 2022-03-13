package ru.job4j.repositories;

import org.springframework.stereotype.Repository;
import ru.job4j.models.Accident;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {
    private HashMap<Integer, Accident> accidents = new HashMap<>(Map.of(
            1, new Accident(1, "Name_1", "Text_1", "Address_1"),
            2, new Accident(2, "Name_2", "Text_2", "Address_2"),
            3, new Accident(3, "Name_3", "Text_3", "Address_3")));

    private static final AtomicInteger ACCIDENT_ID = new AtomicInteger(4);

    public List<Accident> getAccidents() {
        return new ArrayList<>(accidents.values());
    }

    public void create(Accident accident) {
        if (accident.getId() == 0) {
            accident.setId(ACCIDENT_ID.incrementAndGet());
        }
        accidents.put(accident.getId(), accident);
    }

    public Accident findById(int id) {
        return accidents.get(id);
    }
}
