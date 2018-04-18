package at.maymay.convertme.application.core;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import at.maymay.convertme.R;

public class Converter extends AppCompatActivity implements View.OnClickListener {

    Button btn_convert;
    Button btn_addNewLine;

    List<ConversionListElement> list_elements = new ArrayList<>();

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

        initCategories();
        addNewConversionLine(length);

        btn_convert = (Button) findViewById(R.id.btn_convert);
        btn_addNewLine = (Button) findViewById(R.id.btn_addNewLine);

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
                Unit kg = new Unit("kilogram", "kg", 1000.0);
                Unit dag = new Unit("decagram", "dag", 10.0);
                for(ConversionListElement element : list_elements)
                {
                    if(element.getTextViewInput().getText().length() != 0)
                    {
                        double result = convert(kg, dag, element.getInput());
                        element.setOutput(result);
                    }
                }
                break;

            case R.id.btn_addNewLine:
                addNewConversionLine(length);
                break;
        }
    }

    private void initCategories() {
        currency = new Currency();
        length = new Length();
        speed = new Speed();
        temperature = new Temperature();
        volume = new Volume();
        weight = new Weight();
    }

    private void addNewConversionLine(Category category)
    {
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        View view = inflater.inflate(R.layout.convert_list_item, null);

        ConversionListElement new_element = new ConversionListElement(this, view, category);
        list_elements.add(new_element);

        LinearLayout llayout = (LinearLayout) findViewById(R.id.layout_conversions);
        llayout.addView(view);
    }

    public Currency getCurrency() {
        return currency;
    }
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
    public Length getLength() {
        return length;
    }
    public void setLength(Length length) {
        this.length = length;
    }
    public Speed getSpeed() {
        return speed;
    }
    public void setSpeed(Speed speed) {
        this.speed = speed;
    }
    public Temperature getTemperature() {
        return temperature;
    }
    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }
    public Volume getVolume() {
        return volume;
    }
    public void setVolume(Volume volume) {
        this.volume = volume;
    }
    public Weight getWeight() {
        return weight;
    }
    public void setWeight(Weight weight) {
        this.weight = weight;
    }
}