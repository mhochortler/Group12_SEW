package at.maymay.convertme.application.core;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import at.maymay.convertme.R;
import at.maymay.convertme.application.core.ui.CategorySelectionToolbar;
import at.maymay.convertme.application.core.ui.ConversionListElement;

import static java.lang.Math.round;

public class Converter extends AppCompatActivity implements View.OnClickListener{

    FloatingActionButton btn_fabtoolbar;
    CategorySelectionToolbar fabtoolbar;
    ToggleButton tb_shortcut_settings;
    Boolean tb_state= false;

    private List<ConversionListElement> list_elements = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        btn_fabtoolbar = (FloatingActionButton) findViewById(R.id.btn_fabtoolbar);
        fabtoolbar = new CategorySelectionToolbar(this);

        btn_fabtoolbar.setOnClickListener(this);
    }

    public static double convert(Unit from, Unit to, double value) {
        Category cat = new Temperature();
        String[] strings = cat.getStringifytUnitList();
        if(Arrays.asList(strings).contains(from.getName()))
            return convertTemperature(from, to, value);
        else
        if(Arrays.asList(strings).contains(from.getShortcut()))
            return convertTemperature(from, to, value);
        return (value * from.getFactor()) / to.getFactor();
    }

    public static double convertTemperature(Unit from, Unit to, double value)
    {
        if(from.getName().equals("Kelvin"))
            value -= from.getFactor();
        switch (to.getName()) {
            case "Celsius":
                if (from.getName().equals("Fahrenheit"))
                    return (value - 32.0) / 1.8;
                break;
            case "Fahrenheit":
                value = value * 1.8 + 32.0;
                break;
            case "Kelvin":
                if (from.getName().equals("Fahrenheit"))
                    value = ((value - 32.0) / from.getFactor());
                value += to.getFactor();
            default:
                return value;


        }
        return value;
    }

    @Override
    public void onClick(View view) {

        switch(view.getId())
        {
            case R.id.btn_fabtoolbar:
                fabtoolbar.show();
                break;

            case R.id.tb_shortcut_setting:
                changeshortcut();
                break;
        }
    }

    public void changeshortcut()

    {
        if (tb_state== false)
        {
            tb_state= true;
        }else
        {
            tb_state= false;

        }
    }


    public void addNewConversionLine(Category category)
    {
        ConversionListElement new_element = new ConversionListElement(this, category);
        list_elements.add(new_element);

        LinearLayout llayout = (LinearLayout) findViewById(R.id.layout_conversions);
        llayout.addView(new_element.getView());
    }
}