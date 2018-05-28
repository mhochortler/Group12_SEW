package at.maymay.convertme.application.core;

import at.maymay.convertme.application.core.model.Currency;
import at.maymay.convertme.application.core.model.Length;
import at.maymay.convertme.application.core.model.Speed;
import at.maymay.convertme.application.core.model.Temperature;
import at.maymay.convertme.application.core.model.Volume;
import at.maymay.convertme.application.core.model.Weight;

public class CategoryContainer
{
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

    public Currency currency(){
        return currency_;
    }
    public Length length(){
        return length_;
    }
    public Speed speed(){
        return speed_;
    }
    public Temperature temperature(){
        return temperature_;
    }
    public Volume volume(){
        return volume_;
    }
    public Weight weight(){
        return weight_;
    }
}
