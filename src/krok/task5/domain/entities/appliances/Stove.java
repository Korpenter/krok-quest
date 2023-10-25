package krok.task5.domain.entities.appliances;

import krok.task5.domain.enums.Country;
import krok.task5.domain.enums.StoveType;
public class Stove extends Appliance {
    private StoveType stoveType;

    public Stove(String description, double price, Dimensions dimensions, int power,
                 StoveType stoveType , Country countryOfOrigin, Warranty warranty) {
        super(description, price, dimensions, power, countryOfOrigin, warranty);
        this.stoveType = stoveType;

    }
    public StoveType getStoveType() {
        return stoveType;
    }
    public void setStoveType(StoveType stoveType) {
        this.stoveType = stoveType;
    }
    @Override
    public String toString() {
        String baseInfo = super.toString();
        String stoveInfo = String.format("Stove Type: %s", stoveType);
        return String.format("%s, %s", baseInfo, stoveInfo);
    }
}