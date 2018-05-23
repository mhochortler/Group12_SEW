package at.maymay.convertme.application.core;

import java.util.List;

import at.maymay.convertme.application.core.model.Unit;

public class Profile {

    public Profile(String name, String shortcut)
    {
        name_ = name;
        shortcut_ = shortcut;
    }

    public Profile(String name, String shortcut, Unit default_length, Unit default_speed,
                   Unit default_temperature, Unit default_volume, Unit default_weight,
                   Unit default_currency)
    {
        name_ = name;
        shortcut_ = shortcut;

        default_length_ = default_length;
        default_speed_ = default_speed;
        default_temperature_ = default_temperature;
        default_volume_ = default_volume;
        default_weight_ = default_weight;
        default_currency_ = default_currency;
    }

    private String name_;
    private String shortcut_;
    private Unit default_length_;
    private Unit default_speed_;
    private Unit default_temperature_;
    private Unit default_volume_;
    private Unit default_weight_;
    private Unit default_currency_;

    public String getName() { return name_; }
    public String getShortcut() { return shortcut_; }
    public Unit getDefault_length() { return default_length_; }
    public Unit getDefault_speed() { return default_speed_; }
    public Unit getDefault_temperature() { return default_temperature_; }
    public Unit getDefault_volume() { return default_volume_; }
    public Unit getDefault_weight() { return default_weight_; }
    public Unit getDefault_currency() { return default_currency_; }

    public void setDefault_length(Unit length) { default_length_ = length; }
    public void setDefault_speed(Unit speed) { default_speed_ = speed; }
    public void setDefault_temperature(Unit temperature) { default_temperature_ = temperature; }
    public void setDefault_volume(Unit volume) { default_volume_ = volume; }
    public void setDefault_weight(Unit weight) { default_weight_ = weight; }
    public void setDefault_currency(Unit currency) { default_currency_ = currency; }

}
