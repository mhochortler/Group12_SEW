package at.maymay.convertme.application.core.model;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;

import at.maymay.convertme.application.core.Converter;
import at.maymay.convertme.application.core.Profile;
import at.maymay.convertme.application.dal.CurrencyExchangeAPI;

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

        unit_output_list_ = new ArrayList<>(unit_list_);
    }

    private long remoteID;

    public void changeList(Profile profile) {
        unit_list_.remove(profile.getDefault_currency());
        unit_list_.add(0, profile.getDefault_currency());
    }

    public void changeOutputList(Profile profile) {
        unit_output_list_.remove(profile.getDefault_currency());
        unit_output_list_.add(0, profile.getDefault_currency());
    }

    public Unit getUSD() { return unit_list_.get(0); }
    public Unit getEuro() { return unit_list_.get(1); }
    public Unit getYen() { return unit_list_.get(2); }
    public Unit getRubel() { return unit_list_.get(3); }
    public Unit getFrank() { return unit_list_.get(4); }

    public void loadExchangeRates(JSONObject obj)
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
