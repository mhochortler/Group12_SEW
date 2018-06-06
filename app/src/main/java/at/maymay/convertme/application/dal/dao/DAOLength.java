package at.maymay.convertme.application.dal.dao;

import java.util.List;

import at.maymay.convertme.application.core.dao.IDAOLength;
import at.maymay.convertme.application.core.model.Length;
import at.maymay.convertme.application.core.model.Unit;

public class DAOLength implements IDAOLength {

    @Override
    public Length load(){
        Length length = new Length();
        List<Unit> units = length.getUnitList();

        units.add(new Unit( "Millimeter", "mm", 0.001));
        units.add(new Unit( "Centimeter", "cm", 0.01));
        units.add(new Unit( "Meter", "m", 1.0));
        units.add(new Unit( "Kilometer", "km", 1000.0));
        units.add(new Unit( "Inch", "in", 0.0254));
        units.add(new Unit( "Foot", "ft", 0.3048));
        units.add(new Unit( "Yard", "yd", 0.9144));
        units.add(new Unit( "Mile", "mile", 1609.34));
        units.add(new Unit( "Nautical Mile", "nmi", 1852.0));

        return length;
    }
}
