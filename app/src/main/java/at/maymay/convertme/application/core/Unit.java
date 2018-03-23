package at.maymay.convertme.application.core;

import java.io.Serializable;

/**
 * Created by mmalte on 21.03.18.
 */

public class Unit implements Serializable {

    private String name;
    private String shortcut;
    private UnitTyp type;
    private double factor;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getShortcut() {
        return shortcut;
    }
    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }
    public UnitTyp getType() {
        return type;
    }
    public void setType(UnitTyp typ) {
        this.type = typ;
    }
    public double getFactor() {
        return factor;
    }
    public void setFactor(double factor) {
        this.factor = factor;
    }
}
