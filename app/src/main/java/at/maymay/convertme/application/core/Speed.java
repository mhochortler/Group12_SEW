package at.maymay.convertme.application.core;

import java.util.List;

public class Speed extends Category {

    public Speed(){init();
    }

    @Override
    protected void init() {
        Unit kmh = new Unit ("KilometersHours", "km/h", 1);
        Unit mileh = new Unit ("MilesHours", "mile/h", 1.6093445);
        Unit fts = new Unit ("FootSeconds", "ft/s", 1.0972805);
        Unit ms = new Unit ("MeterSeconds", "m/s", 3.6);
        Unit knot = new Unit ("Knot", "kn", 1.8519993);
        unit_list_.add(kmh);
        unit_list_.add(mileh);
        unit_list_.add(fts);
        unit_list_.add(ms);
        unit_list_.add(knot);
    }
}
