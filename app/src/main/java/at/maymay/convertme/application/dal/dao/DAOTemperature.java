package at.maymay.convertme.application.dal.dao;

import java.util.List;

import at.maymay.convertme.application.core.dao.IDAOTemperature;
import at.maymay.convertme.application.core.model.Temperature;
import at.maymay.convertme.application.core.model.Unit;

public class DAOTemperature implements IDAOTemperature {

    @Override
    public Temperature load() {
        Temperature temperature = new Temperature();
        List<Unit> units = temperature.getUnitList();

        units.add(new Unit( "Celsius", "°C", 1.0));
        units.add(new Unit( "Fahrenheit", "°F", 1.8));
        units.add(new Unit( "Kelvin", "K", 273.15));

        return temperature;
    }
}
