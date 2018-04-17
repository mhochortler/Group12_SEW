package at.maymay.convertme.application.core;

public class Weight extends Category {

    public Weight(){
        init();
    }

    @Override
    protected void init() {
        Unit kg = new Unit("Kilogram", "kg", 1000.0);
        Unit dag = new Unit("Decagram", "dag", 10.0);
        unit_list_.add(kg);
        unit_list_.add(dag);
    }
}
