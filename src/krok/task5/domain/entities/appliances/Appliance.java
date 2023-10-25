package krok.task5.domain.entities.appliances;

import krok.task5.domain.enums.Country;
import krok.task5.domain.enums.WarrantyStatus;
import krok.common.exceptions.ValidationException;

import static krok.task5.domain.enums.Country.RUSSIA;

public abstract class Appliance {
    private int id;
    private String description;
    private double price;
    private Dimensions dimensions;
    private int power;
    private Country countryOfOrigin;
    private Warranty warranty;

    public Appliance(String description, double price, Dimensions dimensions, int power, Country countryOfOrigin, Warranty warranty) {
        if (price < 0 || power < 0 || dimensions == null) {
            throw new ValidationException("Invalid values provided for appliance creation");
        }
        this.description = description;
        this.price = price;
        this.dimensions = dimensions;
        this.power = power;
        this.countryOfOrigin = countryOfOrigin;
        this.warranty = warranty;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public int getPower() {
        return power;
    }

    public int getId() {
        return id;
    }

    public Country getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(Country countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String warrantyInfo() {
        return warranty.toString();
    }

    public void setWarrantyStatus(WarrantyStatus status) {
        warranty.setStatus(status);
    }

    public Warranty getWarranty() {
        return warranty;
    }

    public void setWarranty(Warranty warranty) {
        this.warranty = warranty;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImportInfo() {
        if(countryOfOrigin != RUSSIA) {
            return String.format("Country of Origin: %s, Warranty: %s", countryOfOrigin, warranty);
        } else {
            return "Not an imported appliance.";
        }
    }

    public boolean hasManufacturerWarranty() {
        return warranty.getStatus() == WarrantyStatus.WARRANTIED;
    }

    public void setDimensions(Dimensions dimensions) {
        if (dimensions == null) {
            throw new ValidationException("Dimensions cannot be null");
        }
        this.dimensions = dimensions;
    }

    public void setDescription(String description) {
        if(description == null || description.isEmpty()) {
            throw new ValidationException("Description cannot be null or empty");
        }
        this.description = description;
    }

    public void setPrice(double price) {
        if(price < 0) {
            throw new ValidationException("Price cannot be negative");
        }
        this.price = price;
    }

    public void setPower(int power) {
        if(power < 0) {
            throw new ValidationException("Power cannot be negative");
        }
        this.power = power;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Desc.: %s, Price: %.2f, Dimensions: %s, Power: %dW, Import Info: %s",
               id, description, price, dimensions, power, getImportInfo());
    }

}