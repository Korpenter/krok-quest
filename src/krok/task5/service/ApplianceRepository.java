package krok.task5.service;

import krok.task5.domain.entities.appliances.Appliance;

import java.util.List;
import java.util.Optional;

public interface ApplianceRepository {
    public void save(Appliance appliance);
    public Optional<Appliance> findById(int id);
    public List<Appliance> findAll();
    public void update(int id, Appliance updatedAppliance);
    public void delete(int id);
}
