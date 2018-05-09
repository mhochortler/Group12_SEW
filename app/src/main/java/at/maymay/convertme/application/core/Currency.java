package at.maymay.convertme.application.core;

import org.json.JSONObject;

public class Currency extends Category {

    public Currency(){
        init();
    }

    @Override
    protected void init() {
        CurrencyExchangeAPI api = new CurrencyExchangeAPI();
        api.execute(this);
    }

    protected void setExchangeRates(JSONObject obj)
    {
        try {
            String base = obj.getString("base");
            if(base.equals("USD"))
            {
                JSONObject rates = obj.getJSONObject("rates");
                Unit usd = new Unit("U.S. Dollar", "USD", 1.0);
                Unit eur = new Unit("Euro", "EUR", 1/rates.getDouble("EUR"));
                Unit yen = new Unit("Yen", "JPY", 1/rates.getDouble("JPY"));
                Unit pound = new Unit("British Pound", "GBP", 1/rates.getDouble("GBP"));
                Unit frank = new Unit("Swiss Franc", "CHF", 1/rates.getDouble("CHF"));
                unit_list_.add(usd);
                unit_list_.add(eur);
                unit_list_.add(yen);
                unit_list_.add(pound);
                unit_list_.add(frank);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
