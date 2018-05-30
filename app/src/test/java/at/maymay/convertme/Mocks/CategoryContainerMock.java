package at.maymay.convertme.Mocks;

import java.util.List;

import at.maymay.convertme.application.core.ICategoryContainer;
import at.maymay.convertme.application.core.model.Currency;
import at.maymay.convertme.application.core.model.Length;
import at.maymay.convertme.application.core.model.Speed;
import at.maymay.convertme.application.core.model.Temperature;
import at.maymay.convertme.application.core.model.Unit;
import at.maymay.convertme.application.core.model.Volume;
import at.maymay.convertme.application.core.model.Weight;

public class CategoryContainerMock implements ICategoryContainer
{
    @Override
    public Currency currency(){
        Currency currency = new Currency();
        List<Unit> units = currency.getUnitList();

        units.add(new Unit("Curr1", "C1", 1));
        units.add(new Unit("Curr2", "C2", 2));
        units.add(new Unit("Curr3", "C3", 0.5));

        return currency;
    }
    @Override
    public Length length(){
        Length length = new Length();
        List<Unit> units = length.getUnitList();

        units.add(new Unit("Len1", "L1", 1));
        units.add(new Unit("Len2", "L2", 2));
        units.add(new Unit("Len3", "L3", 0.5));

        return length;
    }
    @Override
    public Speed speed(){
        Speed speed = new Speed();
        List<Unit> units = speed.getUnitList();

        units.add(new Unit("Speed1", "S1", 1));
        units.add(new Unit("Speed", "S2", 2));
        units.add(new Unit("Speed3", "S3", 0.5));

        return speed;
    }
    @Override
    public Temperature temperature(){
        Temperature temperature = new Temperature();
        List<Unit> units = temperature.getUnitList();

        units.add(new Unit("Temp1", "T1", 1));
        units.add(new Unit("Temp2", "T2", 2));
        units.add(new Unit("Temp3", "T3", 0.5));

        return temperature;
    }
    @Override
    public Volume volume(){
        Volume volume = new Volume();
        List<Unit> units = volume.getUnitList();

        units.add(new Unit("Vol1", "V1", 1));
        units.add(new Unit("Vol2", "V2", 2));
        units.add(new Unit("Vol3", "V3", 0.5));

        return volume;
    }
    @Override
    public Weight weight(){
        Weight weight = new Weight();
        List<Unit> units = weight.getUnitList();

        units.add(new Unit("Wei1", "W1", 1));
        units.add(new Unit("Wei2", "W2", 2));
        units.add(new Unit("Wei3", "W3", 0.5));

        return weight;
    }
}