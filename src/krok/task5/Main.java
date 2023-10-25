package krok.task5;

import krok.task5.domain.entities.appliances.*;
import krok.task5.domain.enums.Country;
import krok.task5.domain.enums.StoveType;
import krok.task5.domain.enums.WarrantyStatus;
import krok.common.exceptions.ValidationException;
import krok.task5.storage.ApplianceInMemRepository;
import krok.task5.service.ApplianceService;

import java.time.LocalDate;

// Right now I handle/change objects by reference in memory, so I don't use Update method and Repository doesn't return a copy.
public class Main {
    public static void main(String[] args) {
        ApplianceInMemRepository repo = new ApplianceInMemRepository();
        ApplianceService svc = new ApplianceService(repo);
        int id;
        Dimensions smallDimensions = new Dimensions(50, 50, 50);
        Dimensions mediumDimensions = new Dimensions(60, 60, 60);
        Dimensions largeDimensions = new Dimensions(70, 70, 70);

        try {
            Fridge fridge = new Fridge("Holodilnick", 200, smallDimensions, 150, true, -20,  Country.JAPAN, new Warranty(WarrantyStatus.WARRANTIED, LocalDate.now().plusYears(2)));
            svc.addAppliance(fridge);

            Stove stove = new Stove("Plitochka", 300, mediumDimensions, 1000, StoveType.ELECTRIC, Country.USA, new Warranty(WarrantyStatus.WARRANTIED, LocalDate.now().plusYears(3)));
            svc.addAppliance(stove);

            WashingMachine washingMachine = new WashingMachine("Moechka", 400, largeDimensions, 500, true, Country.RUSSIA, new Warranty(WarrantyStatus.WARRANTIED, LocalDate.now().plusYears(1)));
            svc.addAppliance(washingMachine);

            VacuumRobot vacuumRobot = new VacuumRobot("Robotics", 150, smallDimensions, 100, 120, Country.CHINA, new Warranty(WarrantyStatus.WARRANTIED, LocalDate.now().plusYears(1)));
            svc.addAppliance(vacuumRobot);

        } catch (ValidationException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("All Appliances:");
        for (Appliance appliance : svc.getAllAppliances()) {
            System.out.println(appliance);
        }

        Stove updatedStove = new Stove("Plita New Name", 350, mediumDimensions, 1200, StoveType.ELECTRIC, Country.RUSSIA, new Warranty(WarrantyStatus.WARRANTIED, LocalDate.now().plusYears(3)));
        id = 2;
        svc.updateAppliance(id, updatedStove);
        System.out.println("Updated Appliance with id="+id);
        System.out.println(svc.getAppliance(id));

        id = 3;
        svc.deleteAppliance(id);
        System.out.println("All Appliances after deletion with id="+id);
        for (Appliance appliance : svc.getAllAppliances()) {
            System.out.println(appliance);
        }

        System.out.println("Attempting to update with invalid values:");
        try {
            Appliance appliance = svc.getAppliance(1);
            appliance.setPrice(-100);
        } catch (ValidationException e) {
            System.err.println(e.getMessage());
        }

        try {
            Appliance appliance = svc.getAppliance(1);
            appliance.setWarranty(new Warranty(WarrantyStatus.WARRANTIED, LocalDate.now().minusYears(1)));
        } catch (ValidationException e) {
            System.err.println(e.getMessage());
        }

        try {
            Appliance appliance = svc.getAppliance(1);
            appliance.setDimensions(new Dimensions(-50, -50, -50));
        } catch (ValidationException e) {
            System.err.println(e.getMessage());
        }

        try {
            Appliance appliance = svc.getAppliance(1);
            appliance.setPower(-150);
        } catch (ValidationException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("All Appliances after attempting invalid updates:");
        for (Appliance appliance : svc.getAllAppliances()) {
            System.out.println(appliance);
        }

        try {
            Appliance appliance = svc.getAppliance(1);
            appliance.setPrice(250);
            appliance.setDimensions(new Dimensions(55, 55, 55));
            appliance.setPower(155);
            appliance.setWarranty(new Warranty(WarrantyStatus.WARRANTIED, LocalDate.now().plusYears(10)));
        } catch (ValidationException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("All Appliances after valid updates:");
        for (Appliance appliance : svc.getAllAppliances()) {
            System.out.println(appliance);
        }

        System.out.println("Attempting to access unknown ID:");
        try {
            System.out.println(svc.getAppliance(100));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Attempting to update unknown ID:");
        try {
            Stove anotherStove = new Stove("Another Stove", 300, mediumDimensions, 1000, StoveType.ELECTRIC, Country.USA, new Warranty(WarrantyStatus.WARRANTIED, LocalDate.now().plusYears(3)));
            svc.updateAppliance(100, anotherStove);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Attempting to delete unknown ID:");
        try {
            svc.deleteAppliance(100);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}