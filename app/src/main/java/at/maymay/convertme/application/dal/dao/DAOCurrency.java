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

        Unit usd = new Unit("U.S. Dollar", "USD",  1.0);
        Unit eur = new Unit("Euro", "EUR",0.0);
        Unit yen = new Unit("Yen", "JPY", 0.0);
        Unit pound = new Unit("British Pound", "GBP",0.0);
        Unit frank = new Unit("Swiss Franc", "CHF",0.0);

        return currency;
    }

    @Override
    public void save(Currency currency) {

    }
}
