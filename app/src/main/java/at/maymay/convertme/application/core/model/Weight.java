package at.maymay.convertme.application.core.model;

import java.util.ArrayList;

import at.maymay.convertme.application.core.Profile;

public class Weight extends Category {

    public Weight(){ }

    public Unit getGramm() { return unit_list_.get(0); }
    public Unit getKilogramm() { return unit_list_.get(1); }
    public Unit getDecagramm() { return unit_list_.get(2); }
    public Unit getOunce() { return unit_list_.get(3); }
    public Unit getPound() { return unit_list_.get(4); }
    public Unit getStone() { return unit_list_.get(5); }
    public Unit getUSTon() { return unit_list_.get(6); }
    public Unit getImperialTon() { return unit_list_.get(7); }
}
