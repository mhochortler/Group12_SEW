package at.maymay.convertme.application.core;

import at.maymay.convertme.application.core.model.Currency;
import at.maymay.convertme.application.core.model.Length;
import at.maymay.convertme.application.core.model.Speed;
import at.maymay.convertme.application.core.model.Temperature;
import at.maymay.convertme.application.core.model.Volume;
import at.maymay.convertme.application.core.model.Weight;

public class CategoryContainer implements ICategoryContainer {
    private Currency currency_;
    private Length length_;
    private Speed speed_;
    private Temperature temperature_;
    private Volume volume_;
    private Weight weight_;

    public CategoryContainer(Currency currency, Length length, Speed speed,
                             Temperature temperature, Volume volume, Weight weight){
        currency_ = currency;
        length_ = length;
        temperature_ = temperature;
        speed_ = speed;
        volume_ = volume;
        weight_ = weight;
    }

    @Override
    public Currency currency(){
        return currency_;
    }
    @Override
    public Length length(){
        return length_;
    }
    @Override
    public Speed speed(){
        return speed_;
    }
    @Override
    public Temperature temperature(){
        return temperature_;
    }
    @Override
    public Volume volume(){
        return volume_;
    }
    @Override
    public Weight weight(){
        return weight_;
    }
}
