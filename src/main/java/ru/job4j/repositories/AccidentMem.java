package ru.job4j.repositories;

import org.springframework.stereotype.Repository;
import ru.job4j.models.Accident;
import ru.job4j.models.AccidentType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {

    private HashMap<Integer, AccidentType> accidentTypes = new HashMap<>(Map.of(
            1, AccidentType.of(1, "Type_1"),
            2, AccidentType.of(2, "Type_2"),
            3, AccidentType.of(3, "Type_3")));

    private HashMap<Integer, Accident> accidents = new HashMap<>(Map.of(
            1, Accident.of(1, "Name_1", "Text_1", "Address_1", accidentTypes.get(1)),
            2, Accident.of(2, "Name_2", "Text_2", "Address_2", accidentTypes.get(2)),
            3, Accident.of(3, "Name_3", "Text_3", "Address_3", accidentTypes.get(3))));

    private static final AtomicInteger ACCIDENT_ID = new AtomicInteger(4);

    public List<Accident> getAccidents() {
        return new ArrayList<>(accidents.values());
    }

    public List<AccidentType> getAccidentTypes() {
        return new ArrayList<>(accidentTypes.values());
    }

    public void create(Accident accident) {
        if (accident.getId() == 0) {
            accident.setId(ACCIDENT_ID.incrementAndGet());
        }
        accidents.put(accident.getId(), accident);
    }

    public Accident findAccidentById(int id) {
        return accidents.get(id);
    }

    public AccidentType findAccidentTypeById(int id) {
        return accidentTypes.get(id);
    }
}
