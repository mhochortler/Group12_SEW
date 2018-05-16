package at.maymay.convertme.application.core;

import java.util.ArrayList;

public class Weight extends Category {

    public Weight(){
        init();
    }

    @Override
    protected void init() {
        Unit kg = new Unit("Kilogram", "kg", 1000.0);
        Unit dag = new Unit("Decagram", "dag", 10.0);
        Unit oz = new Unit("Ounce", "oz", 28.349);
        Unit lb = new Unit("Pound", "lb", 453.592);
        Unit st = new Unit("Stone", "st", 6350.29);
        Unit ust = new Unit("US Ton", "ust", 907184.28568);
        Unit it = new Unit ("Imperial Ton", "it", 1016050);
        unit_list_.add(kg);
        unit_list_.add(dag);
        unit_list_.add(oz);
        unit_list_.add(lb);
        unit_list_.add(st);
        unit_list_.add(ust);
        unit_list_.add(it);

        unit_output_list_ = new ArrayList<>(unit_list_);
    }

    public void changeList(Profile profile) {
        unit_list_.remove(profile.getDefault_weight());
        unit_list_.add(0, profile.getDefault_weight());
    }

    public void changeOutputList(Profile profile) {
        unit_output_list_.remove(profile.getDefault_weight());
        unit_output_list_.add(0, profile.getDefault_weight());
    }

    public Unit getKilogramm() { return unit_list_.get(0); }
    public Unit getDecagramm() { return unit_list_.get(1); }
    public Unit getOunce() { return unit_list_.get(2); }
    public Unit getPound() { return unit_list_.get(3); }
    public Unit getStone() { return unit_list_.get(4); }
    public Unit getUSTon() { return unit_list_.get(5); }
    public Unit getImperialTon() { return unit_list_.get(6); }
}
