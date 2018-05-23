package at.maymay.convertme.application.core;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import at.maymay.convertme.R;
import at.maymay.convertme.application.core.model.Category;
import at.maymay.convertme.application.core.model.Temperature;
import at.maymay.convertme.application.core.model.Unit;
import at.maymay.convertme.application.core.ui.CategorySelectionToolbar;
import at.maymay.convertme.application.core.ui.ConversionListElement;

public class Converter extends AppCompatActivity implements View.OnClickListener{

    private static Context context;

    private List<ConversionListElement> conversion_collection;

    FloatingActionButton btn_fabtoolbar;
    CategorySelectionToolbar fabtoolbar;
    ToggleButton tb_shortcut_settings;
    Boolean tb_state= true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Converter.context = getApplicationContext();
        setContentView(R.layout.activity_converter);

        btn_fabtoolbar = (FloatingActionButton) findViewById(R.id.btn_fabtoolbar);
        fabtoolbar = new CategorySelectionToolbar(this);
        tb_shortcut_settings = (ToggleButton) findViewById(R.id.tb_shortcut_setting);

        conversion_collection = new ArrayList<>();

        btn_fabtoolbar.setOnClickListener(this);
        tb_shortcut_settings.setOnClickListener(this);
    }

    public static double convert(Unit from, Unit to, double value) {
        Category cat = new Temperature();
        String[] strings = cat.getStringifytUnitList();
        if(Arrays.asList(strings).contains(from.getShortcut()))
            return convertTemperature(from, to, value);
        return (value * from.getFactor()) / to.getFactor();
    }

    public static double convertTemperature(Unit from, Unit to, double value)
    {
        if(from.getShortcut().equals("K"))
            value -= from.getFactor();
        switch (to.getShortcut()){
            case "°C":
                if(from.getShortcut().equals("°F"))
                    return (value - 32.0) / 1.8;
                break;
            case "°F":
                value = value * 1.8 + 32.0;
                break;
            case "K":
                if(from.getShortcut().equals("°F"))
                    value =  ((value - 32.0)/from.getFactor());
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

    public void changeshortcut() {
        tb_state = !tb_state;

        for (ConversionListElement element : conversion_collection)
        {
            element.changeUnitList(tb_state);
        }
    }


    public void addNewConversionLine(Category category)
    {
        ConversionListElement new_element = new ConversionListElement(this, category);

        LinearLayout llayout = (LinearLayout) findViewById(R.id.layout_conversions);
        llayout.addView(new_element.getView());
        conversion_collection.add(new_element);

        if(new_element.getView() != null)
        {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            assert imm != null;
            imm.showSoftInput(new_element.getView().findFocus(), InputMethodManager.SHOW_IMPLICIT);
        }
    }

    public void deleteConversionLine(ConversionListElement element)
    {
        LinearLayout llayout = (LinearLayout) findViewById(R.id.layout_conversions);
        llayout.removeView(element.getView());
        conversion_collection.remove(element);

        if(element.getView() != null)
        {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            assert imm != null;
            imm.hideSoftInputFromWindow(element.getView().getWindowToken(), 0);
        }
    }

    public static Context getAppContext()
    {
        return Converter.context;
    }
}