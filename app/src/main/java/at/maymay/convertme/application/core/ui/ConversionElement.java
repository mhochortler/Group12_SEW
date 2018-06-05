package at.maymay.convertme.application.core.ui;

import android.content.Context;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import at.maymay.convertme.R;
import at.maymay.convertme.application.config.AppConfig;
import at.maymay.convertme.application.core.model.Category;
import at.maymay.convertme.application.core.model.Currency;
import at.maymay.convertme.application.dal.CurrencyExchangeAPI;
import at.maymay.convertme.application.core.model.Unit;

public class ConversionElement implements AdapterView.OnItemSelectedListener, View.OnClickListener
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

    ConversionElement(Context context, Category category, ConversionCollection collection)
    {
        LayoutInflater inflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = Objects.requireNonNull(inflater).inflate(R.layout.conversion_element_style,null);

        edittext_left = (EditText) view.findViewById(R.id.edittext_conversion_left);
        edittext_right = (EditText) view.findViewById(R.id.edittext_conversion_right);
        spinner_left = (Spinner) view.findViewById(R.id.spinner_conversion_left);
        spinner_right = (Spinner) view.findViewById(R.id.spinner_conversion_right);
        ImageButton btn_delete = (ImageButton) view.findViewById(R.id.btn_delete);

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

        btn_delete.setOnClickListener(this);

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

    public void transition(int x_pos)
    {
        layout_conversion.animate().translationX(x_pos);
    }

    private double getValueAsDouble(EditText field)
    {
        if(field.getText().toString().matches("\\d+(?:\\.\\d*)?"))
            return Double.parseDouble(field.getText().toString());
        else
            return 0.0;
    }

    private double round(double value, int places)
    {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private void setValue(double value, EditText target)
    {
        String value_str = String.valueOf(value);

        int dot_pos = 0;
        for(char c : value_str.toCharArray())
        {
            dot_pos++;
            if(c == '.') break;
        }

        int b_dot = dot_pos - 1;
        int a_dot = value_str.length() - dot_pos;
        int places = 7 - b_dot;
        double rounded_val;

        if(value_str.length() > 8)
        {
            if(b_dot < 8)
            {
                rounded_val = round(value, places);
                DecimalFormat dec_format = new DecimalFormat("0.######");
                target.setText(dec_format.format(Double.valueOf(rounded_val)));
            }
            else {
                DecimalFormat dec_format = new DecimalFormat("0.#####");
                target.setText(dec_format.format(Double.valueOf(value)));
            }
        }
        else
        {
            DecimalFormat dec_format = new DecimalFormat("0.#####");
            target.setText(dec_format.format(Double.valueOf(value)));
        }


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
            if(category.getClass() == Currency.class) {
                AppConfig.updateFactors();
            }
            double RESULT = category.convert(from, to, getValueAsDouble(input));
            setValue(RESULT, result);
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
                if(edittext_left.getText().length() > 0)
                {
                    double RESULT = getValueAsDouble(edittext_left);
                    setValue(RESULT, edittext_left);
                }
                break;
            case R.id.spinner_conversion_right:
                selected_unit_right = selected_unit;
                if(edittext_left.getText().length() > 0)
                {
                    double RESULT = getValueAsDouble(edittext_left);
                    setValue(RESULT, edittext_left);
                }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {

        switch(view.getId())
        {
            case R.id.btn_delete:
                collection.deleteConversion(this);
                break;
        }
    }
}
