package at.maymay.convertme.application.core;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import at.maymay.convertme.R;
import at.maymay.convertme.application.core.ui.CategorySelectionToolbar;
import at.maymay.convertme.application.core.ui.ConversionListElement;

public class Converter extends AppCompatActivity implements View.OnClickListener{

    FloatingActionButton btn_fabtoolbar;
    CategorySelectionToolbar fabtoolbar;

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
        return (value * from.getFactor()) / to.getFactor();
    }

    @Override
    public void onClick(View view) {

        switch(view.getId())
        {
            case R.id.btn_fabtoolbar:
                fabtoolbar.show();
                break;
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