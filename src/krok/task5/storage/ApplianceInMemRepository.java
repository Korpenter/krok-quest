package krok.task5.storage;

import krok.task5.domain.entities.appliances.Appliance;
import krok.task5.service.ApplianceRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ApplianceInMemRepository implements ApplianceRepository {
    private final Map<Integer, Appliance> appliances = new HashMap<>();
    private int currentId = 1;
    public void save(Appliance appliance) {
        appliance.setId(currentId++);
        appliances.put(appliance.getId(), appliance);
    }
    public Optional<Appliance> findById(int id) {
        return Optional.ofNullable(appliances.get(id));
    }
    public List<Appliance> findAll() {
        return new ArrayList<>(appliances.values());
    }
    public void update(int id, Appliance updatedAppliance) {
        if (appliances.containsKey(id)) {
            appliances.put(id, updatedAppliance);
        } else {
            throw new IllegalArgumentException("Appliance with id " + id + " not found");
        }
    }
    public void delete(int id) {
        if (appliances.remove(id) == null) {
            throw new IllegalArgumentException("Appliance with id " + id + " not found");
        }
    }
}