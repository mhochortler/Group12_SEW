package at.maymay.convertme.application.core.model;

import java.util.ArrayList;

import at.maymay.convertme.application.core.Profile;

public class Speed extends Category {

    public Speed(){ }

    public Unit getKmh() { return unit_list_.get(0); }
    public Unit getMph() { return unit_list_.get(1); }
    public Unit getFts() { return unit_list_.get(2); }
    public Unit getMs() { return unit_list_.get(3); }
    public Unit getKnot() { return unit_list_.get(4); }
}
