package at.maymay.convertme.application.dal.dalmodel;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;

import java.io.Serializable;
import java.util.List;

import at.maymay.convertme.application.core.model.Unit;

/*public class DALProfile extends Model implements Serializable {

    ListTypeSerializer listSerializer = new ListTypeSerializer();

    @Column(name = "Name")
    private String name_;

    @Column(name = "Shortcut")
    private String shortcut_;

    @Column(name = "StandardUnits")
    private String sst_unit_list;

    @Column(name = "REMOTE_ID", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    private long remote_id;

    private List<Unit> standard_units;

    public DALProfile()
    {
        super();
    }

    public DALProfile(String name, String shortcut, List<Unit> standard_units, long remote_id_)
    {
        sst_unit_list = null;
        remote_id = remote_id_;
        name_ = name;
        shortcut_ = shortcut;
        this.standard_units = standard_units;
    }

    public void serializeList()
    {
        this.sst_unit_list = listSerializer.serialize(standard_units);
    }

    public void deserializeList()
    {
        if(sst_unit_list != null)
            this.standard_units = listSerializer.deserialize(sst_unit_list);
    }

    public String getName() {
        return name_;
    }
    public void setName(String name) {
        this.name_ = name;
    }
    public String getShortcut() {
        return shortcut_;
    }
    public void setShortcut(String shortcut) {
        this.shortcut_ = shortcut;
    }
    public List<Unit> getStandard_units() {
        return standard_units;
    }
    public void setStandard_units(List<Unit> standard_units_) { this.standard_units = standard_units_; }
}
*/