package at.maymay.convertme.application.core.model;

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
    }
}
