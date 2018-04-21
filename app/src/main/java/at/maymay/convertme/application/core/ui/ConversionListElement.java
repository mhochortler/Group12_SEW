package at.maymay.convertme.application.core.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import at.maymay.convertme.R;
import at.maymay.convertme.application.core.Category;
import at.maymay.convertme.application.core.Unit;

public class ConversionListElement {

    private View view;

    private TextView textview_output;
    private EditText textview_input;
    private Spinner spinner_output;
    private Spinner spinner_input;

    private Category category;

    public ConversionListElement(Context context, Category category) {

        LayoutInflater inflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        view = inflater.inflate(R.layout.convert_list_item, null);

        this.textview_input = (EditText) view.findViewById(R.id.ptxt_input);
        this.textview_output = (TextView) view.findViewById(R.id.ptxt_result);
        this.spinner_input = (Spinner) view.findViewById(R.id.input_unit);
        this.spinner_output = (Spinner) view.findViewById(R.id.output_unit);

        this.category = category;

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

    public EditText getTextViewInput(){
        return textview_input;
    }

    public double getInput(){
        return Double.parseDouble(textview_input.getText().toString());
    }

    public void setOutput(double output_value){
        textview_output.setText(String.valueOf(output_value));
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
