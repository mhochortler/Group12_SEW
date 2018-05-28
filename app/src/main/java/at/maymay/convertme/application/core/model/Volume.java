package at.maymay.convertme.application.core.model;

import java.util.ArrayList;

import at.maymay.convertme.application.core.Profile;

public class Volume extends Category {

    public Volume(){ }

    public Unit getLiter() { return unit_list_.get(0); }
    public Unit getLiqGallon() { return unit_list_.get(1); }
    public Unit getLiqQuart() { return unit_list_.get(2); }
    public Unit getLiqPint() { return unit_list_.get(3); }
    public Unit getLiqCup() { return unit_list_.get(4); }
    public Unit getLiqOunce() { return unit_list_.get(5); }
    public Unit getTablespoon() { return unit_list_.get(6); }
    public Unit getTeaspoon() { return unit_list_.get(7); }
    public Unit getImpGallon() { return unit_list_.get(8); }
    public Unit getImpQuart() { return unit_list_.get(9); }
    public Unit getImpPint() { return unit_list_.get(10); }
    public Unit getImpCup() { return unit_list_.get(11); }
    public Unit getImpOunce() { return unit_list_.get(12); }
    public Unit getImpTablespoon() { return unit_list_.get(13); }
    public Unit getImpTeaspoon() { return unit_list_.get(14); }
    public Unit getCubicMetre() { return unit_list_.get(15); }
    public Unit getCubicFoot() { return unit_list_.get(16); }
    public Unit getCubicInch() { return unit_list_.get(17); }
}
