package at.maymay.convertme.application.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Category {

    protected abstract void init();

    protected List<Unit> unit_list_ = new ArrayList<>();
    protected List<Unit> unit_output_list_;

    public List<Unit> getUnitList(){
        return unit_list_;
    }

    public List<Unit> getOutputUnitList(){
        return unit_output_list_;
    }

    public String[] getStringifytUnitList() {
        List<String> result = new ArrayList<>();

        for(Unit u : unit_list_) {
            result.add(u.getShortcut());
        }

        return result.toArray(new String[result.size()]);
    }

    public String[] getStringifytOutputUnitList() {
        List<String> result = new ArrayList<>();

        for(Unit u : unit_output_list_) {
            result.add(u.getShortcut());
        }

        return result.toArray(new String[result.size()]);
    }

    public Unit GetUnitByShortcut(String shortcut)
    {
        Unit result = null;

        for (Unit u : unit_list_) {
            if (u.getShortcut().equals(shortcut)) {
                result = u;
                break;
            }
        }
        return result;
    }
}
