package at.maymay.convertme.application.core.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import at.maymay.convertme.R;
import at.maymay.convertme.application.core.Category;
import at.maymay.convertme.application.core.Converter;
import at.maymay.convertme.application.core.Currency;
import at.maymay.convertme.application.core.CurrencyExchangeAPI;
import at.maymay.convertme.application.core.Unit;

public class ConversionListElement {

    private View view;

    private EditText textview_output;
    private EditText textview_input;
    private Spinner spinner_output;
    private Spinner spinner_input;

    private Category category;

    private Boolean text_already_changed = false;

    public ConversionListElement(Context context, final Category category) {

        LayoutInflater inflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        view = inflater.inflate(R.layout.convert_list_item, null);

        this.textview_input = (EditText) view.findViewById(R.id.ptxt_input);
        this.textview_output = (EditText) view.findViewById(R.id.ptxt_result);
        this.spinner_input = (Spinner) view.findViewById(R.id.input_unit);
        this.spinner_output = (Spinner) view.findViewById(R.id.output_unit);

        this.category = category;

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, R.layout.spinner_style, category.getStringifytUnitList());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_input.setAdapter(adapter);
        spinner_output.setAdapter(adapter);

        spinner_output.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(getRightTextViewInput().getText().length() != 0)
                {
                    setOutput(getRightInput());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner_input.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(getTextViewInput().getText().length() != 0)
                {
                    setLeftOutput(getInput());
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        textview_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(getTextViewInput().getText().length() != 0 && !text_already_changed)
                {
                    text_already_changed = true;
                    if(category.getClass() == Currency.class){
                        CurrencyExchangeAPI api = new CurrencyExchangeAPI();
                        api.execute((Currency)category);
                    }
                    double result = Converter.convert(getSelectedInputUnit(), getSelectedOutputUnit(), getInput());

                    setOutput(result);
                }
                else if(getTextViewInput().getText().length() == 0 && !text_already_changed)
                {
                    text_already_changed = true;
                    textview_output.setText("");
                }
                else text_already_changed = false;

            }


            @Override
            public void afterTextChanged(Editable editable) {


            }
        });

        textview_output.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(getRightTextViewInput().getText().length() != 0 && !text_already_changed)
                {
                    text_already_changed = true;
                    if(category.getClass() == Currency.class){
                        CurrencyExchangeAPI api = new CurrencyExchangeAPI();
                        api.execute((Currency)category);
                    }
                    double result = Converter.convert(getSelectedOutputUnit(), getSelectedInputUnit(), getRightInput());
                    setLeftOutput(result);
                }
                else if(getRightTextViewInput().getText().length() == 0 && !text_already_changed)
                {
                    text_already_changed = true;
                    textview_input.setText("");
                }
                else text_already_changed = false;

            }


            @Override
            public void afterTextChanged(Editable editable) {


            }
        });
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public EditText getTextViewInput(){
        return textview_input;
    }
    public EditText getRightTextViewInput() { return textview_output; }

    public double getInput(){
        if(textview_input.getText().toString().matches("\\d+(?:\\.\\d+)?"))
            return Double.parseDouble(textview_input.getText().toString());
        else
            return 0.0;
    }
    public double getRightInput() {
        if(textview_output.getText().toString().matches("\\d+(?:\\.\\d+)?"))
            return Double.parseDouble(textview_output.getText().toString());
        else
            return 0.0;
    }

    public void setOutput(double output_value){
        textview_output.setText(String.format("%.3f", output_value));
    }
    public void setLeftOutput(double output_value){
        textview_input.setText(String.format("%.3f", output_value));
    }

    public Unit getSelectedInputUnit()
    {
        String shortcut = spinner_input.getSelectedItem().toString();

        for(Unit unit : category.getUnitList())
        {
            if (unit.getShortcut().equals(shortcut))
            {
                return unit;
            }
        }

        return null;
    }

    public Unit getSelectedOutputUnit()
    {
        String shortcut = spinner_output.getSelectedItem().toString();

        for(Unit unit : category.getUnitList())
        {
            if (unit.getShortcut().equals(shortcut))
            {
                return unit;
            }
        }

        return null;
    }
}
