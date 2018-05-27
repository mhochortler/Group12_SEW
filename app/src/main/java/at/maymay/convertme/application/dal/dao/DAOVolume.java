package at.maymay.convertme.application.dal.dao;

import java.util.List;

import at.maymay.convertme.application.core.dao.IDAOVolume;
import at.maymay.convertme.application.core.model.Unit;
import at.maymay.convertme.application.core.model.Volume;

public class DAOVolume implements IDAOVolume {

    @Override
    public Volume load() {
        Volume volume = new Volume();
        List<Unit> units = volume.getUnitList();

        units.add(new Unit("Litre", "l", 1.0));
        units.add(new Unit("US liquid gallon", "uslg", 3.78541));
        units.add(new Unit("US liquid quart", "uslq", 0.946353));
        units.add(new Unit("US liquid pint", "uslp", 0.473176));
        units.add(new Unit("US liquid cup", "uslc", 0.24));
        units.add(new Unit("US fluid ounce", "usfo", 0.0295735));
        units.add(new Unit("US tablespoon", "ustap", 0.0147868));
        units.add(new Unit("US teaspoon", "usts", 0.00492892));
        units.add(new Unit("Imperial gallon", "ig", 4.54609));
        units.add(new Unit("Imperial quart", "iq", 1.13652));
        units.add(new Unit("Imperial pint", "ip", 0.568261));
        units.add(new Unit("Imperial cup", "ic", 0.284131));
        units.add(new Unit("Imperial fluid ounce", "ifo", 0.0284131));
        units.add(new Unit("Imperial tablespoon", "itap", 0.0177582));
        units.add(new Unit("Imperial teaspoon", "its", 0.00591939));
        units.add(new Unit("Cubic metre", "m³", 1000.0));
        units.add(new Unit("Cubic foot", "ft³", 28.3168));
        units.add(new Unit("Cubic inch", "in³", 0.0163871));

        return volume;
    }
}
