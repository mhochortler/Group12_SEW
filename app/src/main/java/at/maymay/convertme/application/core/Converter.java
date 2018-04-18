package at.maymay.convertme.application.core;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import at.maymay.convertme.R;

public class Converter extends AppCompatActivity implements View.OnClickListener {

    Button btn_convert;
    EditText ptxt_input;
    EditText ptxt_result;
    Spinner input_unit;
    Spinner output_unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        btn_convert = (Button) findViewById(R.id.btn_convert);
        ptxt_result = (EditText) findViewById(R.id.ptxt_result);
        ptxt_input = (EditText) findViewById(R.id.ptxt_input);
        input_unit = (Spinner) findViewById(R.id.input_unit);
        output_unit = (Spinner) findViewById(R.id.output_unit);

        String[] length_items = new String[]{"m", "ft", "in", "yd", "mile", "nmi"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_style, length_items);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        input_unit.setAdapter(adapter);
        output_unit.setAdapter(adapter);

        btn_convert.setOnClickListener(this);
    }

    public static double convert(Unit from, Unit to, double value) {
        return (value * from.getFactor()) / to.getFactor();
    }


    @Override
    public void onClick(View view) {

        switch(view.getId())
        {
            case R.id.btn_convert:
                Unit kg = new Unit("kilogram", "kg", 1000.0);
                Unit dag = new Unit("decagram", "dag", 10.0);
                double result = convert(kg, dag, Double.parseDouble(ptxt_input.getText().toString()));
                ptxt_result.setText(String.valueOf(result));

                break;
        }
    }
}

