package at.maymay.convertme.application.dal.dao;

import java.util.List;

import at.maymay.convertme.application.core.dao.IDAOSpeed;
import at.maymay.convertme.application.core.model.Speed;
import at.maymay.convertme.application.core.model.Unit;

public class DAOSpeed implements IDAOSpeed {

    @Override
    public Speed load(){
        Speed speed = new Speed();
        List<Unit> units = speed.getUnitList();

        units.add(new Unit( "KilometersHours", "km/h", 1.0));
        units.add(new Unit( "MilesHours", "mile/h", 1.6093445));
        units.add(new Unit( "FootSeconds", "ft/s", 1.0972805));
        units.add(new Unit( "MeterSeconds", "m/s", 3.6));
        units.add(new Unit( "Knot", "kn", 1.8519994));

        return speed;
    }
}
