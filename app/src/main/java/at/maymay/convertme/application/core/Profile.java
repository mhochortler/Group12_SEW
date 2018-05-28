package at.maymay.convertme.application.core;

import java.util.List;

import at.maymay.convertme.application.core.model.Category;
import at.maymay.convertme.application.core.model.Unit;

public class Profile
{
    private String name_;
    private String shortcut_;

    private List<Unit> standard_units;

    public Profile(String name, String shortcut, List<Unit> standard_units)
    {
        name_ = name;
        shortcut_ = shortcut;

        this.standard_units = standard_units;
    }

    public String getName() { return name_; }
    public String getShortcut() { return shortcut_; }

    public List<Unit> getUnitList()
    {
        return standard_units;
    }

    public Unit getDefaultUnit(Category category)
    {
        List<Unit> units = category.getUnitList();

        Unit result = null;

        for(Unit unit : units)
        {
            if(standard_units.contains(unit))
            {
                result = unit;
                break;
            }
        }

        return result;
    }
}
