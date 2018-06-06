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

public class EmptyCategoryContainerMock implements ICategoryContainer
{
    @Override
    public Currency currency(){
        return null;
    }
    @Override
    public Length length(){
        return null;
    }
    @Override
    public Speed speed(){
        return null;
    }
    @Override
    public Temperature temperature(){
        return null;
    }
    @Override
    public Volume volume(){
        return null;
    }
    @Override
    public Weight weight(){
        return null;
    }
}