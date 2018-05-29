package at.maymay.convertme.application.core.model;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;

import at.maymay.convertme.application.core.Converter;
import at.maymay.convertme.application.core.Profile;
import at.maymay.convertme.application.dal.CurrencyExchangeAPI;

public class Currency extends Category {

    public Currency(){ }

    public Unit getUSD() { return unit_list_.get(0); }
    public Unit getEuro() { return unit_list_.get(1); }
    public Unit getYen() { return unit_list_.get(2); }
    public Unit getPound() { return unit_list_.get(3); }
    public Unit getFrank() { return unit_list_.get(4); }

    public void loadExchangeRates(JSONObject obj)
    {
        /*
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
        */
    }
/*
    private boolean checkFactorsUnitList()
    {
        for(Unit unit: unit_list_) {
            if(unit != null && unit.getFactor() == 0.0)
                return false;
        }
        return true;
    }*/
}
