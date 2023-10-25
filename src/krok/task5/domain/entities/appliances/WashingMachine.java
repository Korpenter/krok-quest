package krok.task5.domain.entities.appliances;

import krok.task5.domain.enums.Country;

public class WashingMachine extends Appliance {
    private boolean hasDryer;
    public WashingMachine(String description, double price, Dimensions dimensions, int power,
                          boolean hasDryer, Country countryOfOrigin, Warranty warranty) {
        super(description, price, dimensions, power, countryOfOrigin, warranty);
        this.hasDryer = hasDryer;
    }
    public boolean hasDryer() {
        return hasDryer;
    }
    public void setHasDryer(boolean hasDryer) {
        this.hasDryer = hasDryer;
    }
      @Override
    public String toString() {
        String baseInfo = super.toString();
        String dryerInfo = hasDryer ? "Has Dryer: Yes" : "Has Dryer: No";
        return String.format("%s, %s", baseInfo, dryerInfo);
    }
}