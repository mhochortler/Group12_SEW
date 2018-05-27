package at.maymay.convertme.application.dal.dao;

import java.util.ArrayList;
import java.util.List;

import at.maymay.convertme.application.core.dao.IDAOWeight;
import at.maymay.convertme.application.core.model.Unit;
import at.maymay.convertme.application.core.model.Weight;

public class DAOWeight implements IDAOWeight {

    @Override
    public Weight load() {
        Weight weight = new Weight();
        List<Unit> units = weight.getUnitList();

        units.add(new Unit("Gram", "g", 1));
        units.add(new Unit("Kilogram", "kg", 1000.0));
        units.add(new Unit("Decagram", "dag", 10.0));
        units.add(new Unit("Ounce", "oz", 28.349));
        units.add(new Unit("Pound", "lb", 453.592));
        units.add(new Unit("Stone", "st", 6350.29));
        units.add(new Unit("US Ton", "ust", 907184.28568));
        units.add(new Unit ("Imperial Ton", "it", 1016050.0));

        return weight;
    }
}
