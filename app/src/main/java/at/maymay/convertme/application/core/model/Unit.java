package at.maymay.convertme.application.core.model;

import java.io.Serializable;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Unit")
public class Unit  extends Model implements Serializable {

    @Column(name = "Name")
    private String name_;

    @Column(name = "Shortcut")
    private String shortcut_;

    @Column(name = "Factor")
    private double factor_;

    @Column(name = "remote_id", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    public long remoteId_;

    public Unit()
    {
        super();
    }

    public Unit(String name, String shortcut)
    {
        super();
        name_ = name;
        shortcut_ = shortcut;
        factor_ = 0.0;
    }

    public Unit(String name, String shortcut, long remoteId)
    {
        super();
        name_ = name;
        shortcut_ = shortcut;
        remoteId_ = remoteId;
    }

    public Unit(String name, String shortcut, double factor)
    {
        super();
        name_ = name;
        shortcut_ = shortcut;
        factor_ = factor;
    }

    public Unit(String name, String shortcut, long remoteId, double factor)
    {
        super();
        name_ = name;
        shortcut_ = shortcut;
        factor_ = factor;
        remoteId_ = remoteId;
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
    public double getFactor() {
        return factor_;
    }
    public void setFactor(double factor) { this.factor_ = factor; }
}
