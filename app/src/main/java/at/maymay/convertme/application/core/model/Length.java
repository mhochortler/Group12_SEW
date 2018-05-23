package at.maymay.convertme.application.core.model;

import java.util.ArrayList;

public class Length extends Category {

    public Length() {
        init();
    }

    @Override
    protected void init() {
        Unit m = new Unit( "Meter", "m", 1);
        Unit ft = new Unit ("Foot", "ft", 0.3048);
        Unit in = new Unit ("Inch", "in", 0.0254);
        Unit yd = new Unit ("Yard", "yd", 0.9144);
        Unit mile = new Unit ("Mile", "mile", 1609.34);
        Unit nmi = new Unit ("Nautical Mile", "nmi", 1852);
        unit_list_.add(m);
        unit_list_.add(ft);
        unit_list_.add(in);
        unit_list_.add(yd);
        unit_list_.add(mile);
        unit_list_.add(nmi);

        unit_output_list_ = new ArrayList<>(unit_list_);
    }

    public void changeList(Profile profile) {
        unit_list_.remove(profile.getDefault_length());
        unit_list_.add(0, profile.getDefault_length());
    }

    public void changeOutputList(Profile profile) {
        unit_output_list_.remove(profile.getDefault_length());
        unit_output_list_.add(0, profile.getDefault_length());
    }

    public Unit getMeter() { return unit_list_.get(0); }
    public Unit getFoot() { return unit_list_.get(1); }
    public Unit getInch() { return unit_list_.get(2); }
    public Unit getYard() { return unit_list_.get(3); }
    public Unit getMile() { return unit_list_.get(4); }
    public Unit getNauticMile() { return unit_list_.get(5); }

}
