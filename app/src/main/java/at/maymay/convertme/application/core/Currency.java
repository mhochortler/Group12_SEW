package at.maymay.convertme.application.core;

import android.app.Dialog;
import android.content.Context;
import android.widget.Toast;

import org.json.JSONObject;

public class Currency extends Category {

    public Currency(){
        init();
    }

    @Override
    protected void init() {
        remoteID = 1;
        Unit usd = new Unit("U.S. Dollar", "USD", remoteID++,  1.0);
        Unit eur = new Unit("Euro", "EUR", remoteID++, 0.0);
        Unit yen = new Unit("Yen", "JPY", remoteID++, 0.0);
        Unit pound = new Unit("British Pound", "GBP", remoteID++, 0.0);
        Unit frank = new Unit("Swiss Franc", "CHF",remoteID++, 0.0);
        unit_list_.add(usd);
        unit_list_.add(eur);
        unit_list_.add(yen);
        unit_list_.add(pound);
        unit_list_.add(frank);
        CurrencyExchangeAPI api = new CurrencyExchangeAPI();
        api.execute(this);
    }

    private long remoteID;

    protected void loadExchangeRates(JSONObject obj)
    {
        if(obj != null) {
            try {
                String base = obj.getString("base");
                if (base.equals("USD")) {
                    JSONObject rates = obj.getJSONObject("rates");
                    for (Unit unit: unit_list_) {
                        unit.setFactor(1/rates.getDouble(unit.getShortcut()));
                    }
                    saveUnitListToDB();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else if(!checkFactorsUnitList()){
            Context context = Converter.getAppContext();

            Toast toast = Toast.makeText(context, "Couldn't load ExchangeRates, trying to load from database.", Toast.LENGTH_LONG);
            toast.show();
            for (Unit unit: unit_list_) {
                Unit remoteUnit = Unit.load(Unit.class, unit.remoteId_);
                if (remoteUnit != null) {
                    double factor = remoteUnit.getFactor();
                    unit.setFactor(factor);
                }
                else {
                    context = Converter.getAppContext();
                    toast = Toast.makeText(context, "Couldn't load ExchangeRates from database.", Toast.LENGTH_LONG);
                    toast.show();
                    break;
                }
            }
        }
    }

    private boolean checkFactorsUnitList()
    {
        for(Unit unit: unit_list_) {
            if(unit != null && unit.getFactor() == 0.0)
                return false;
        }
        return true;
    }
}
