package krok.task5.service;

import krok.task5.domain.entities.appliances.Appliance;

import java.util.List;

public class ApplianceService {
    private final ApplianceRepository applianceRepository;
    public ApplianceService(ApplianceRepository applianceRepository) {
        this.applianceRepository = applianceRepository;
    }
    public void addAppliance(Appliance appliance) {
        applianceRepository.save(appliance);
    }
    public Appliance getAppliance(int id) {
        return applianceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Appliance with id " + id + " not found"));
    }
    public List<Appliance> getAllAppliances() {
        return applianceRepository.findAll();
    }
    public void updateAppliance(int id, Appliance updatedAppliance) {
        applianceRepository.update(id, updatedAppliance);
    }
    public void deleteAppliance(int id) {
        applianceRepository.delete(id);
    }
}