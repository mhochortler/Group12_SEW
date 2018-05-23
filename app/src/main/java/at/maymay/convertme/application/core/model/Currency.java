package at.maymay.convertme.application.core.model;

import java.util.ArrayList;

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

        unit_output_list_ = new ArrayList<>(unit_list_);
    }

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
}
