package at.maymay.convertme.application.dal.dao;

import java.util.List;

import at.maymay.convertme.application.core.dao.IDAOCurrency;
import at.maymay.convertme.application.core.model.Currency;
import at.maymay.convertme.application.core.model.Unit;

public class DAOCurrency implements IDAOCurrency{

    @Override
    public Currency load(){
        Currency currency = new Currency();
        List<Unit> units = currency.getUnitList();

        units.add(new Unit("U.S. Dollar", "USD",  1.0));
        units.add(new Unit("Euro", "EUR",0.0));
        units.add(new Unit("Yen", "JPY", 0.0));
        units.add(new Unit("British Pound", "GBP",0.0));
        units.add(new Unit("Swiss Franc", "CHF",0.0));

        return currency;
    }

    @Override
    public void save(Currency currency) {

    }
}
