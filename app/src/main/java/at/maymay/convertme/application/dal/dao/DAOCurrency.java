package at.maymay.convertme.application.dal.dao;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import at.maymay.convertme.application.core.dao.IDAOCurrency;
import at.maymay.convertme.application.core.model.Currency;
import at.maymay.convertme.application.core.model.Unit;
import at.maymay.convertme.application.dal.CurrencyExchangeAPI;

public class DAOCurrency implements IDAOCurrency{

    private List<Unit> units = new ArrayList<>();

    @Override
    public Currency load(){
        Currency currency = new Currency();
        units = currency.getUnitList();
        units.add(new Unit( "U.S. Dollar", "USD", 1.0));
        units.add(new Unit( "Euro", "EUR", 0.0));
        units.add(new Unit( "Yen", "JPY", 0.0));
        units.add(new Unit( "British Pound", "GBP", 0.0));
        units.add(new Unit( "Swiss Franc", "CHF", 0.0));

        CurrencyExchangeAPI api = new CurrencyExchangeAPI();
        api.execute(this);
        return currency;
    }

    public void loadExchangeRates(JSONObject obj) {
        if (obj != null) {
            try {
                String base = obj.getString("base");
                if (base.equals("USD")) {
                    JSONObject rates = obj.getJSONObject("rates");
                    for (Unit unit : units) {
                        unit.setFactor(1 / rates.getDouble(unit.getShortcut()));
                    }
                }
            } catch (Exception e) {
                throw new NullPointerException();
            }
        }
    }
}
