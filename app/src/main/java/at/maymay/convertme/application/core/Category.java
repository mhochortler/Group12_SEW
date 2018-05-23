package at.maymay.convertme.application.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Category {

    protected abstract void init();

    protected List<Unit> unit_list_ = new ArrayList<>();

    public List<Unit> getUnitList(){
        return unit_list_;
    }

    public String[] getStringifytUnitList() {
        List<String> result = new ArrayList<>();

        for(Unit u : unit_list_) {
            result.add(u.getShortcut());
        }

        return result.toArray(new String[result.size()]);
    }

    public void saveUnitListToDB()
    {
        for (Unit unit: unit_list_) {
            if(unit != null)
                unit.save();
        }
    }
}