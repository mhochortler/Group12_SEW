package at.maymay.convertme.application.core.model;

public class Volume extends Category {

    public Volume(){
        init();
    }

    @Override
    protected void init() {
        Unit l = new Unit("Litre", "l", 1);
        Unit uslg = new Unit("US liquid gallon", "uslg", 3.78541);
        Unit uslq = new Unit("US liquid quart", "uslq", 0.946353);
        Unit uslp = new Unit("US liquid pint", "uslp", 0.473176);
        Unit uslc = new Unit("US liquid cup", "uslc", 0.24);
        Unit usfo = new Unit("US fluid ounce", "usfo", 0.0295735);
        Unit ustap = new Unit("US tablespoon", "ustap", 0.0147868);
        Unit usts = new Unit("US teaspoon", "usts", 0.00492892);
        Unit ig = new Unit("Imperial gallon", "ig", 4.54609);
        Unit iq = new Unit("Imperial quart", "iq", 1.13652);
        Unit ip = new Unit("Imperial pint", "ip", 0.568261);
        Unit ic = new Unit("Imperial cup", "ic", 0.284131);
        Unit ifo = new Unit("Imperial fluid ounce", "ifo", 0.0284131);
        Unit itap = new Unit("Imperial tablespoon", "itap", 0.0177582);
        Unit its = new Unit("Imperial teaspoon", "its", 0.00591939);
        Unit m3 = new Unit("Cubic metre", "m³", 1000);
        Unit ft3 = new Unit("Cubic foot", "ft³", 28.3168);
        Unit in3 = new Unit("Cubic inch", "in³", 0.0163871);

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

    }
}
