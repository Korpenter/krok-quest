package krok.task5.domain.entities.appliances;

import krok.task5.domain.enums.Country;
import krok.common.exceptions.ValidationException;

public class VacuumRobot extends Appliance   {
    private int batteryLife;
    public VacuumRobot(String description, double price, Dimensions dimensions, int power,
                      int batteryLife, Country countryOfOrigin, Warranty warranty) {
        super(description, price, dimensions, power, countryOfOrigin, warranty);


        if (batteryLife <= 0) {
            throw new ValidationException("Battery life must be a positive value");
        }
        this.batteryLife = batteryLife;
    }
    public int getBatteryLife() {
        return batteryLife;
    }
    public void setBatteryLife(int batteryLife) {
        if (batteryLife <= 0) {
            throw new ValidationException("Battery life must be a positive value");
        }
        this.batteryLife = batteryLife;
    }
    @Override
    public String toString() {
        String baseInfo = super.toString();
        String robotInfo = String.format("Battery Life: %d min.", batteryLife);
        return String.format("%s, %s", baseInfo, robotInfo);
    }
}