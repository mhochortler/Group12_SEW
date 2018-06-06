package at.maymay.convertme.application.core.model;


public class Unit  {
    private String name_;
    private String shortcut_;
    private double factor_;

    public Unit(String name, String shortcut, double factor)
    {
        super();
        name_ = name;
        shortcut_ = shortcut;
        factor_ = factor;
    }

    public String getName() {
        return name_;
    }
    public String getShortcut() {
        return shortcut_;
    }
    public double getFactor() {
        return factor_;
    }
    public void setFactor(double factor) { this.factor_ = factor; }
}
