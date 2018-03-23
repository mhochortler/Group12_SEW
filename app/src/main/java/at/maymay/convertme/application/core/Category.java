package at.maymay.convertme.application.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Category {

    protected abstract void init();

    List<Unit> unit_list_ = new ArrayList<>();

    public List<Unit> getUnitList(){
        return unit_list_;
    }
}
