package at.maymay.convertme.application.core;

import at.maymay.convertme.application.core.model.Currency;
import at.maymay.convertme.application.core.model.Length;
import at.maymay.convertme.application.core.model.Speed;
import at.maymay.convertme.application.core.model.Temperature;
import at.maymay.convertme.application.core.model.Volume;
import at.maymay.convertme.application.core.model.Weight;

public interface ICategoryContainer {
    Currency currency();
    Length length();
    Speed speed();
    Temperature temperature();
    Volume volume();
    Weight weight();
}
