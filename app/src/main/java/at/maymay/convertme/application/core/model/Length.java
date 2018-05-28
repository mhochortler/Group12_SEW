package at.maymay.convertme.application.core.model;

import java.util.ArrayList;

import at.maymay.convertme.application.core.Profile;

public class Length extends Category {

    public Length() { }

    public Unit getMeter() { return unit_list_.get(0); }
    public Unit getFoot() { return unit_list_.get(1); }
    public Unit getInch() { return unit_list_.get(2); }
    public Unit getYard() { return unit_list_.get(3); }
    public Unit getMile() { return unit_list_.get(4); }
    public Unit getNauticMile() { return unit_list_.get(5); }

}
