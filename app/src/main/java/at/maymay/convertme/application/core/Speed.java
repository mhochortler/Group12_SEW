package at.maymay.convertme.application.core;

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

    public void changeList(Profile profile) {
        unit_list_.remove(profile.getDefault_speed());
        unit_list_.add(0, profile.getDefault_speed());
    }

    public Unit getKmh() { return unit_list_.get(0); }
    public Unit getMph() { return unit_list_.get(1); }
    public Unit getFts() { return unit_list_.get(2); }
    public Unit getMs() { return unit_list_.get(3); }
    public Unit getKnot() { return unit_list_.get(4); }
}
