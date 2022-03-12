package ru.job4j.repositories;

import org.springframework.stereotype.Repository;
import ru.job4j.models.Accident;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccidentMem {
    private HashMap<Integer, Accident> accidents = new HashMap<>(Map.of(
            1, new Accident(1, "Name_1", "Text_1", "Address_1"),
            2, new Accident(2, "Name_2", "Text_2", "Address_2"),
            3, new Accident(3, "Name_3", "Text_3", "Address_3")));


    public List<Accident> getAccidents() {
        return new ArrayList<>(accidents.values());
    }
}
