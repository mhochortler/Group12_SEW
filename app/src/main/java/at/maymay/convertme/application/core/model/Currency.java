package at.maymay.convertme.application.core.model;

public class Currency extends Category {

    public Currency(){
        init();
    }

    @Override
    protected void init() {
        Unit usd = new Unit("U.S. Dollar", "USD");
        Unit eur = new Unit("Euro", "EUR");
        Unit yen = new Unit("Yen", "JPY");
        Unit rubel = new Unit("British Pound", "GBP");
        Unit frank = new Unit("Swiss Franc", "CHF");

        unit_list_.add(usd);
        unit_list_.add(eur);
        unit_list_.add(yen);
        unit_list_.add(rubel);
        unit_list_.add(frank);
    }
}
