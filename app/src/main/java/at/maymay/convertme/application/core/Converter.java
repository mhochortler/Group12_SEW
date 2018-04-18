package at.maymay.convertme.application.core;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import at.maymay.convertme.R;

public class Converter extends AppCompatActivity implements View.OnClickListener {

    Button btn_convert;
    EditText ptxt_input;
    EditText ptxt_result;
    TextView input_unit;
    TextView output_unit;

    private Currency currency;
    private Length length;
    private Speed speed;
    private Temperature temperature;
    private Volume volume;
    private Weight weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        btn_convert = (Button) findViewById(R.id.btn_convert);
        ptxt_result = (EditText) findViewById(R.id.ptxt_result);
        ptxt_input = (EditText) findViewById(R.id.ptxt_input);
        input_unit = (TextView) findViewById(R.id.input_unit);
        output_unit = (TextView) findViewById(R.id.output_unit);

        btn_convert.setOnClickListener(this);

        initCategories();
    }

    public void initCategories() {
        currency = new Currency();
        length = new Length();
        speed = new Speed();
        temperature = new Temperature();
        volume = new Volume();
        weight = new Weight();
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
                input_unit.setText(kg.getShortcut());
                output_unit.setText(dag.getShortcut());
                double result = convert(kg, dag, Double.parseDouble(ptxt_input.getText().toString()));
                ptxt_result.setText(String.valueOf(result));

                break;
        }
    }
}

