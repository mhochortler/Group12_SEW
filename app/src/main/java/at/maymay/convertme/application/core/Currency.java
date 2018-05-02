package at.maymay.convertme.application.core;

public class Currency extends Category {

    public Currency(){
        init();
    }

    @Override
    protected void init() {

        Unit usd = new Unit("U.S. Dollar", "USD", 1.0);
        Unit eur = new Unit("Euro", "EUR", getExchangeRate("EUR"));
        Unit yen = new Unit("Yen", "JPY", getExchangeRate("JPY"));
        Unit pound = new Unit("British Pound", "GBP", getExchangeRate("GBP"));
        Unit frank = new Unit("Swiss Franc", "CHF", getExchangeRate("CHF"));
        unit_list_.add(usd);
        unit_list_.add(eur);
        unit_list_.add(yen);
        unit_list_.add(pound);
        unit_list_.add(frank);
    }

    private double getExchangeRate(String currency)
    {
        double result = 0.0;
        try{
            result = CurrencyExchangeAPI.getExchangeRate(currency, "USD");
        }
        catch(Exception e){
            System.out.print("Couldn't get exchange rate");
        }
        return result;
    }
}
