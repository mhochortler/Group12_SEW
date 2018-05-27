package at.maymay.convertme.application.core.model;

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

    public double convert(Unit from, Unit to, double value) {
        if(from == null || to == null)
            throw new NullPointerException("One unit is a Null-Ptr!");

        String shortcutFrom = from.getShortcut();
        String shortcutTo = to.getShortcut();
        Unit validUnitFrom = GetUnitByShortcut(shortcutFrom);
        Unit validUnitTo = GetUnitByShortcut(shortcutTo);

        if(validUnitFrom == null || validUnitTo == null)
            throw new IllegalArgumentException("Unit is not part of the category!");

        return (value * validUnitFrom.getFactor()) / validUnitTo.getFactor();
    }

    public void saveUnitListToDB()
    {
        /*
        for (Unit unit: unit_list_) {
            if(unit != null)
                unit.save();
        }
        */
    }
}
