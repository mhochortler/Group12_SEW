package at.maymay.convertme.application.core;

import java.util.ArrayList;

public class Volume extends Category {

    public Volume(){
        init();
    }

    @Override
    protected void init() {
        Unit l = new Unit("Litre", "l", 1);
        Unit uslg = new Unit("US liquid gallon", "USlg", 3.78541);
        Unit uslq = new Unit("US liquid quart", "uslq", 0.946353);
        Unit uslp = new Unit("US liquid pint", "uslp", 0.473176);
        Unit uslc = new Unit("US liquid cup", "uslc", 0.24);
        Unit usfo = new Unit("US fluid ounce", "usfo", 0.0295735);
        Unit ustap = new Unit("US tablespoon", "ustap", 0.0147868);
        Unit usts = new Unit("US teaspoon", "usts", 0.00492892);
        Unit ig = new Unit("imperial gallon", "ig", 4.54609);
        Unit iq = new Unit("imperial quart", "iq", 1.13652);
        Unit ip = new Unit("imperial pint", "ip", 0.568261);
        Unit ic = new Unit("imperial cup", "ic", 0.284131);
        Unit ifo = new Unit("imperial fluid ounce", "ifo", 0.0284131);
        Unit itap = new Unit("imperial tablespoon", "itap", 0.0177582);
        Unit its = new Unit("imperial teaspoon", "its", 0.00591939);
        Unit m3 = new Unit("cubic metre", "m³", 1000);
        Unit ft3 = new Unit("cubic foot", "ft³", 28.3168);
        Unit in3 = new Unit("cubic inch", "in³", 0.0163871);
        unit_list_.add(l);
        unit_list_.add(uslg);
        unit_list_.add(uslq);
        unit_list_.add(uslp);
        unit_list_.add(uslc);
        unit_list_.add(usfo);
        unit_list_.add(ustap);
        unit_list_.add(usts);
        unit_list_.add(ig);
        unit_list_.add(iq);
        unit_list_.add(ip);
        unit_list_.add(ic);
        unit_list_.add(ifo);
        unit_list_.add(itap);
        unit_list_.add(its);
        unit_list_.add(m3);
        unit_list_.add(ft3);
        unit_list_.add(in3);

        unit_output_list_ = new ArrayList<>(unit_list_);

    }
    public void changeList(Profile profile) {
        unit_list_.remove(profile.getDefault_volume());
        unit_list_.add(0, profile.getDefault_volume());
    }

    public void changeOutputList(Profile profile) {
        unit_output_list_.remove(profile.getDefault_volume());
        unit_output_list_.add(0, profile.getDefault_volume());
    }

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
