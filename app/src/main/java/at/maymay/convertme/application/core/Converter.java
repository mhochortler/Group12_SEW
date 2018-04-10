package at.maymay.convertme.application.core;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import at.maymay.convertme.R;

public class Converter extends AppCompatActivity implements View.OnClickListener {

    Button btn_convert;
    EditText ptxt_input;
    EditText ptxt_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        btn_convert = findViewById(R.id.btn_convert);
        ptxt_result = findViewById(R.id.ptxt_result);
        ptxt_input = findViewById(R.id.ptxt_input);

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

