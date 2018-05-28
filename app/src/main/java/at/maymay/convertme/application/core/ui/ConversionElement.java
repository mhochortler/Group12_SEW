package at.maymay.convertme.application.core.ui;

import android.content.Context;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import at.maymay.convertme.R;
import at.maymay.convertme.application.core.model.Category;
import at.maymay.convertme.application.core.model.Currency;
import at.maymay.convertme.application.dal.CurrencyExchangeAPI;
import at.maymay.convertme.application.core.model.Unit;

public class ConversionElement implements AdapterView.OnItemSelectedListener, View.OnTouchListener
{
    private View view;

    private ConversionCollection collection;
    private Category category;

    private EditText edittext_right;
    private EditText edittext_left;
    private Spinner spinner_right;
    private Spinner spinner_left;

    private Unit selected_unit_left;
    private Unit selected_unit_right;

    private Boolean updated_conversion = false;

    private ConstraintLayout layout_conversion;

    private float last_x_position;

    ConversionElement(Context context, Category category, ConversionCollection collection)
    {
        LayoutInflater inflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = Objects.requireNonNull(inflater).inflate(R.layout.conversion_element_style,null);

        edittext_left = (EditText) view.findViewById(R.id.edittext_conversion_left);
        edittext_right = (EditText) view.findViewById(R.id.edittext_conversion_right);
        spinner_left = (Spinner) view.findViewById(R.id.spinner_conversion_left);
        spinner_right = (Spinner) view.findViewById(R.id.spinner_conversion_right);

        layout_conversion = (ConstraintLayout) view.findViewById(R.id.layout_conversion_element);
        this.collection = collection;
        this.category = category;

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item,
                category.getStringifytUnitList());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_left.setAdapter(adapter);
        spinner_right.setAdapter(adapter);
        spinner_left.setOnItemSelectedListener(this);
        spinner_right.setOnItemSelectedListener(this);

        layout_conversion.setOnTouchListener(this);

        edittext_left.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
                if(updated_conversion) updated_conversion = false;
                else
                {
                    updateConversion(selected_unit_left, selected_unit_right, edittext_left, edittext_right);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edittext_right.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
                if(updated_conversion) updated_conversion = false;
                else
                {
                    updateConversion(selected_unit_right, selected_unit_left, edittext_right, edittext_left);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public View getView()
    {
        return view;
    }

    public Category getCategory()
    {
        return category;
    }

    private double getValueAsDouble(EditText field)
    {
        if(field.getText().toString().matches("\\d+(?:\\.\\d+)?"))
            return Double.parseDouble(field.getText().toString());
        else
            return 0.0;
    }

    private void setSelectedItem(Spinner spinner, Unit unit)
    {
        List<String> list_units = new ArrayList<>();

        if(unit != null)
        {
            for(int i = 0; i < spinner.getAdapter().getCount(); i++)
            {
                list_units.add(spinner.getAdapter().getItem(i).toString());
            }

            int index = list_units.indexOf(unit.getShortcut());
            if(index < 0) index = list_units.indexOf(unit.getName());

            if(spinner.getSelectedItem() != spinner.getItemAtPosition(index)) {
                spinner.setSelection(index);
            }
        }
    }

    private void updateConversion(Unit from, Unit to, EditText input, EditText result)
    {
        updated_conversion = true;

        if(input.getText().length() > 0)
        {
            if(category.getClass() == Currency.class){
                CurrencyExchangeAPI api = new CurrencyExchangeAPI();
                api.execute((Currency)category);
            }
            double RESULT = category.convert(from, to, getValueAsDouble(input));
            result.setText(String.format("%.3f", RESULT));
        }
        else result.setText("");
    }

    public void updateToNewProfile(Unit new_unit_left, Unit new_unit_right)
    {
        setSelectedItem(spinner_left, new_unit_left);
        setSelectedItem(spinner_right, new_unit_right);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
        String unit_name = adapterView.getSelectedItem().toString();
        Unit selected_unit = category.getUnitByShortcut(unit_name);

        if(selected_unit == null)
        {
            selected_unit = category.getUnitByName(unit_name);
        }

        switch(adapterView.getId())
        {
            case R.id.spinner_conversion_left:
                selected_unit_left = selected_unit;
                if(edittext_right.getText().length() > 0)
                {
                    edittext_right.setText(String.format("%.3f", getValueAsDouble(edittext_right)));
                }
                break;
            case R.id.spinner_conversion_right:
                selected_unit_right = selected_unit;
                if(edittext_left.getText().length() > 0)
                {
                    edittext_left.setText(String.format("%.3f", getValueAsDouble(edittext_left)));
                }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent)
    {
        float current_x_position;

        switch(motionEvent.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                last_x_position = motionEvent.getX();
                return true;

            case MotionEvent.ACTION_MOVE:
                current_x_position = motionEvent.getX();
                if(last_x_position - current_x_position <= 200 && last_x_position - current_x_position >= 0)
                {
                    int color = 255 - ((int)(last_x_position - current_x_position) / 6);
                    layout_conversion.setTranslationX((last_x_position - current_x_position) * -1);
                    layout_conversion.setBackgroundColor(Color.argb(255,color,color,color));
                }
                return true;

            case MotionEvent.ACTION_UP:
                current_x_position = motionEvent.getX();
                if(last_x_position > current_x_position && (last_x_position - current_x_position >= 200))
                {
                    collection.deleteConversion(this);
                }
                else if(last_x_position > current_x_position)
                {
                    layout_conversion.setBackgroundColor(Color.argb(255, 255, 255, 255));
                    layout_conversion.animate().translationX(0);
                }
                return true;
        }
        return false;
    }
}
