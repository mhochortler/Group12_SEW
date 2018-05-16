package at.maymay.convertme.application.core;

import java.util.ArrayList;

public class Temperature extends Category {

    public Temperature(){
        init();
    }

    @Override
    protected void init() {
        Unit c = new Unit("Celsius", "°C", 1);
        Unit f = new Unit("Fahrenheit", "°F", 1.8);
        Unit k = new Unit ("Kelvin", "K", 274.15);

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

    public Unit getCelsius() { return unit_list_.get(0); }
    public Unit getFahrenheit() { return unit_list_.get(1); }
    public Unit getKelvin() { return unit_list_.get(2); }
}
