package at.maymay.convertme.application.core.model;

import java.util.ArrayList;

import at.maymay.convertme.application.core.Profile;

public class Temperature extends Category {

    public Temperature(){
        init();
    }

    @Override
    protected void init() {
        Unit c = new Unit("Celsius", "°C", 1);
        Unit f = new Unit("Fahrenheit", "°F", 1.8);
        Unit k = new Unit ("Kelvin", "K", 273.15);

        unit_list_.add(c);
        unit_list_.add(f);
        unit_list_.add(k);

        unit_output_list_ = new ArrayList<>(unit_list_);
    }

    public void changeList(Profile profile) {
        unit_list_.remove(profile.getDefault_temperature());
        unit_list_.add(0, profile.getDefault_temperature());
    }

    public void changeOutputList(Profile profile) {
        unit_output_list_.remove(profile.getDefault_temperature());
        unit_output_list_.add(0, profile.getDefault_temperature());
    }

    public double convert(Unit from, Unit to, double value) {
        if(from == null || to == null)
            throw new NullPointerException("One unit is a Null-Ptr!");

        String shortcutFrom = from.getShortcut();
        String shortcutTo = to.getShortcut();
        Unit validUnitFrom = GetUnitByShortcut(shortcutFrom);
        Unit validUnitTo = GetUnitByShortcut(shortcutTo);

        if(validUnitFrom == null || validUnitTo == null)
            throw new IllegalArgumentException("Unit is not part of the category!");

        if(shortcutFrom.equals("K"))
            value -= validUnitFrom.getFactor();
        switch (shortcutTo){
            case "°C":
                if(shortcutFrom.equals("°F"))
                    return (value - 32.0) / 1.8;
                break;
            case "°F":
                value = value * 1.8 + 32.0;
                break;
            case "K":
                if(shortcutFrom.equals("°F"))
                    value =  ((value - 32.0)/validUnitFrom.getFactor());
                value += validUnitTo.getFactor();
            default:
                return value;
        }
        return value;
    }

    public Unit getCelsius() { return unit_list_.get(0); }
    public Unit getFahrenheit() { return unit_list_.get(1); }
    public Unit getKelvin() { return unit_list_.get(2); }
}
