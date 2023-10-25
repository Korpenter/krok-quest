package krok.task5.domain.entities.appliances;

import krok.task5.domain.enums.Country;
import krok.common.exceptions.ValidationException;

public class Fridge extends Appliance {
    private boolean hasFreezer;
    private int freezerTemperature;

    public Fridge(String description, double price, Dimensions dimensions, int power, boolean hasFreezer, int freezerTemperature, Country countryOfOrigin, Warranty warranty) {
        super(description, price, dimensions, power, countryOfOrigin, warranty);
        this.hasFreezer = hasFreezer;

        if (hasFreezer) {
            if (freezerTemperature > 0 || freezerTemperature < -30) {
                throw new ValidationException("Freezer temperature must be between -30 and 0");
            }
            this.freezerTemperature = freezerTemperature;
        }
    }

    public boolean hasFreezer() {
        return hasFreezer;
    }
    public int getFreezerTemperature() {
        return freezerTemperature;
    }
    public void setHasFreezer(boolean hasFreezer) {
        this.hasFreezer = hasFreezer;
    }

    public void setFreezerTemperature(int freezerTemperature) {
        this.freezerTemperature = freezerTemperature;
    }
     @Override
    public String toString() {
        String baseInfo = super.toString();
        String fridgeInfo = hasFreezer ? "Has Freezer: Yes" : "Has Freezer: No";
        return String.format("%s, %s", baseInfo, fridgeInfo);
    }

}