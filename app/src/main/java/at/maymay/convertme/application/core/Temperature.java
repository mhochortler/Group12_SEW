package at.maymay.convertme.application.core;

import java.util.List;

public class Temperature extends Category {

    public Temperature(){
        init();
    }

    @Override
    protected void init() {
        Unit c = new Unit("Celsius", "°C", 1);
        Unit f = new Unit("Fahrenheit", "F°", 1);
        Unit k = new Unit ("Kelvin", "K", 1);
        unit_list_.add(c);
        unit_list_.add(f);
        unit_list_.add(k);
    }
}
