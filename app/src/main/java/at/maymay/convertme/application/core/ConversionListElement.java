package at.maymay.convertme.application.core;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import at.maymay.convertme.R;

public class ConversionListElement {

    private View view;

    private TextView textview_output;
    private EditText textview_input;
    private Spinner spinner_output;
    private Spinner spinner_input;

    public ConversionListElement(Context context, View view, Category category) {
        this.view = view;
        this.textview_input = (EditText) view.findViewById(R.id.ptxt_input);
        this.textview_output = (TextView) view.findViewById(R.id.ptxt_result);
        this.spinner_input = (Spinner) view.findViewById(R.id.input_unit);
        this.spinner_output = (Spinner) view.findViewById(R.id.output_unit);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, R.layout.spinner_style, category.getStringifytUnitList());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_input.setAdapter(adapter);
        spinner_output.setAdapter(adapter);
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public TextView getTextViewOutput(){
        return textview_output;
    }

    public EditText getTextViewInput(){
        return textview_input;
    }

    public Spinner getSpinnerOuput(){
        return spinner_output;
    }

    public Spinner getSpinnerInput(){
        return spinner_input;
    }

    public double getInput(){
        return Double.parseDouble(textview_input.getText().toString());
    }

    public void setOutput(double output_value){
        textview_output.setText(String.valueOf(output_value));
    }
}
