package at.maymay.convertme.application.core;

import java.io.Serializable;


public class Unit implements Serializable {

    public Unit(String name, String shortcut)
    {
        name_ = name;
        shortcut_ = shortcut;
        factor_ = 0.0;
    }

    public Unit(String name, String shortcut, double factor)
    {
        name_ = name;
        shortcut_ = shortcut;
        factor_ = factor;
    }

    private String name_;
    private String shortcut_;
    private double factor_;

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
    public void setFactor(double factor) {
        this.factor_ = factor;
    }
}
