package at.maymay.convertme.application.core;

public class Weight extends Category {

    public Weight(){
        init();
    }

    @Override
    protected void init() {
        Unit kg = new Unit("Kilogram", "kg", 1000.0);
        Unit dag = new Unit("Decagram", "dag", 10.0);
        Unit oz = new Unit("Ounce", "oz", 0.0283495);
        Unit lb = new Unit("Pound", "lb", 0.453592);
        Unit st = new Unit("Stone", "st", 6.35029);
        Unit ust = new Unit("US Ton", "ust", 907.18428568);
        Unit it = new Unit ("Imperial Ton", "it", 1016.05);
        unit_list_.add(kg);
        unit_list_.add(dag);
        unit_list_.add(oz);
        unit_list_.add(lb);
        unit_list_.add(st);
        unit_list_.add(ust);
        unit_list_.add(it);
    }
}
