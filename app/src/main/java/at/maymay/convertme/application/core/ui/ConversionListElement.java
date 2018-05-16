package at.maymay.convertme.application.core.ui;

import android.content.Context;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import at.maymay.convertme.R;
import at.maymay.convertme.application.core.Category;
import at.maymay.convertme.application.core.Converter;
import at.maymay.convertme.application.core.Unit;

public class ConversionListElement extends ConstraintLayout{

    private View view_;

    private EditText textview_output;
    private EditText textview_input;
    private Spinner spinner_output;
    private Spinner spinner_input;

    private Category category;
    private Boolean text_already_changed = false;

    private ConstraintLayout main_layout;

    private float x1, x2;

    public ConversionListElement(final Context context, Category category) {
        super(context);

        LayoutInflater inflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        view_ = inflater.inflate(R.layout.convert_list_item, null);

        this.textview_input = (EditText) view_.findViewById(R.id.ptxt_input);
        this.textview_output = (EditText) view_.findViewById(R.id.ptxt_result);
        this.spinner_input = (Spinner) view_.findViewById(R.id.input_unit);
        this.spinner_output = (Spinner) view_.findViewById(R.id.output_unit);

        this.main_layout = (ConstraintLayout) view_.findViewById(R.id.layout_conversionLine);

        this.category = category;

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, R.layout.spinner_style, category.getStringifytUnitList());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_input.setAdapter(adapter);
        spinner_output.setAdapter(adapter);

        main_layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x1 = motionEvent.getX();
                        x2 = motionEvent.getX();
                        return true;

                    case MotionEvent.ACTION_MOVE:
                        x2 = motionEvent.getX();
                        if(x1 - x2 <= 200 && x1 - x2 >= 0) {

                            int color = 255 - ((int)(x1 - x2) / 6);
                            main_layout.setTranslationX((x1 - x2) * -1);
                            main_layout.setBackgroundColor(Color.argb(255,color,color,color));
                        }
                        return true;

                    case MotionEvent.ACTION_UP:
                        x2 = motionEvent.getX();

                        if(x1 > x2 && (x1 - x2 >= 200)){
                            ((Converter)context).deleteConversionLine(view_);
                        }
                        else if(x1 > x2)
                        {
                            main_layout.setBackgroundColor(Color.argb(255, 255, 255, 255));
                            main_layout.animate().translationX(0);
                        }
                        return true;
                }
                return false;
            }
        });

        spinner_output.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(getRightTextViewInput().getText().length() != 0)
                {
                    setOutput(getRightInput());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });
        spinner_input.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(getTextViewInput().getText().length() != 0)
                {
                    setLeftOutput(getInput());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });
        textview_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(getTextViewInput().getText().length() != 0 && !text_already_changed)
                {
                    text_already_changed = true;
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
            public void afterTextChanged(Editable editable) { }
        });
        textview_output.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(getRightTextViewInput().getText().length() != 0 && !text_already_changed)
                {
                    text_already_changed = true;
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
            public void afterTextChanged(Editable editable) { }
        });
    }

    public View getView() {
        return view_;
    }
    public void setView(View view) {
        this.view_ = view;
    }

    private EditText getTextViewInput(){
        return textview_input;
    }
    private EditText getRightTextViewInput() { return textview_output; }

    private double getInput() {
        return Double.parseDouble(textview_input.getText().toString());
    }
    private double getRightInput() {
        return Double.parseDouble(textview_output.getText().toString());
    }

    private void setOutput(double output_value){
        textview_output.setText(String.format("%.3f", output_value));
    }
    private void setLeftOutput(double output_value){
        textview_input.setText(String.format("%.3f", output_value));
    }

    private Unit getSelectedInputUnit() {
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
    private Unit getSelectedOutputUnit() {
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
