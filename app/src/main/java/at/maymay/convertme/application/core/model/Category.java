package at.maymay.convertme.application.core.model;

import java.util.ArrayList;
import java.util.List;

import at.maymay.convertme.application.dal.dalmodel.DALUnit;

public abstract class Category {

    protected List<Unit> unit_list_ = new ArrayList<>();

    public List<Unit> getUnitList(){
        return unit_list_;
    }

    public String[] getStringifytUnitList()
    {
        List<String> result = new ArrayList<>();

        for(Unit u : unit_list_) {
            result.add(u.getShortcut());
        }

        return result.toArray(new String[result.size()]);
    }

    public Unit getUnitByShortcut(String shortcut)
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

    public Unit getUnitByName(String name)
    {
        Unit result = null;

        for (Unit u : unit_list_) {
            if (u.getName().equals(name)) {
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
        Unit validUnitFrom = getUnitByShortcut(shortcutFrom);
        Unit validUnitTo = getUnitByShortcut(shortcutTo);

        if(validUnitFrom == null || validUnitTo == null)
            throw new IllegalArgumentException("Unit is not part of the category!");

        return (value * validUnitFrom.getFactor()) / validUnitTo.getFactor();
    }
}
