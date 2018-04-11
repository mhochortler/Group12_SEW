package at.maymay.convertme.application.core;

import java.util.List;

public class Length extends Category {

    public Length() { init();}

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
    }
}
