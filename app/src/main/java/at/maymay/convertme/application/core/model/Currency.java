package at.maymay.convertme.application.core.model;

import org.json.JSONObject;

public class Currency extends Category {

    public Currency(){ }

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
