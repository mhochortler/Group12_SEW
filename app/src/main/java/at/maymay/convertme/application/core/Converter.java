package at.maymay.convertme.application.core;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import at.maymay.convertme.R;
import at.maymay.convertme.application.core.ui.CategorySelectionMenu;
import at.maymay.convertme.application.core.ui.ConversionListElement;

public class Converter extends AppCompatActivity implements View.OnClickListener{

    Button btn_convert;
    FloatingActionButton btn_addNewLine;
    CategorySelectionMenu category_selection;

    private List<ConversionListElement> list_elements = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        category_selection = new CategorySelectionMenu(this);

        btn_convert = (Button) findViewById(R.id.btn_convert);
        btn_addNewLine = (FloatingActionButton) findViewById(R.id.btn_addNewLine);

        btn_convert.setOnClickListener(this);
        btn_addNewLine.setOnClickListener(this);
    }

    public static double convert(Unit from, Unit to, double value) {
        return (value * from.getFactor()) / to.getFactor();
    }

    @Override
    public void onClick(View view) {

        switch(view.getId())
        {
            case R.id.btn_convert:
                for(ConversionListElement element : list_elements)
                {
                    Unit input_unit = element.getSelectedInputUnit();
                    Unit output_unit = element.getSelectedOutputUnit();

                    if(element.getTextViewInput().getText().length() != 0)
                    {
                        double result = convert(input_unit, output_unit, element.getInput());
                        element.setOutput(result);
                    }
                }
                break;

            case R.id.btn_addNewLine:
                if(category_selection.getView().isShown())
                {
                    closeSelectCategoryMenu();
                }
                else openSelectCategoryMenu();
                break;
        }
    }

    private void openSelectCategoryMenu()
    {
        ConstraintLayout main_layout = (ConstraintLayout) findViewById(R.id.main_layout);
        main_layout.addView(category_selection.getView());
    }

    public void closeSelectCategoryMenu()
    {
        ConstraintLayout main_layout = (ConstraintLayout) findViewById(R.id.main_layout);
        main_layout.removeView(category_selection.getView());
    }

    public void addNewConversionLine(Category category)
    {
        ConversionListElement new_element = new ConversionListElement(this, category);
        list_elements.add(new_element);

        LinearLayout llayout = (LinearLayout) findViewById(R.id.layout_conversions);
        llayout.addView(new_element.getView());
    }
}