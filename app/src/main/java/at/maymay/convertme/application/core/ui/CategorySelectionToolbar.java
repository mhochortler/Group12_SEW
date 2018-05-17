package at.maymay.convertme.application.core.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;

import com.github.fafaldo.fabtoolbar.widget.FABToolbarLayout;

import at.maymay.convertme.R;
import at.maymay.convertme.application.core.model.Category;
import at.maymay.convertme.application.core.Converter;
import at.maymay.convertme.application.core.model.Currency;
import at.maymay.convertme.application.core.model.Length;
import at.maymay.convertme.application.core.model.Speed;
import at.maymay.convertme.application.core.model.Temperature;
import at.maymay.convertme.application.core.model.Volume;
import at.maymay.convertme.application.core.model.Weight;

public class CategorySelectionToolbar implements View.OnClickListener{

    private Currency currency;
    private Length length;
    private Speed speed;
    private Temperature temperature;
    private Volume volume;
    private Weight weight;

    private FABToolbarLayout layout;

    private Category selected_category;

    private Converter main_activity;

    public CategorySelectionToolbar(Context context) {

        main_activity = (Converter) context;
        View view = ((Converter)context).findViewById(R.id.main_layout);

        layout = (FABToolbarLayout) view.findViewById(R.id.layout_fabtoolbar);

        ImageButton btn_length = (ImageButton) view.findViewById(R.id.btn_length);
        ImageButton btn_weight = (ImageButton) view.findViewById(R.id.btn_weight);
        ImageButton btn_speed = (ImageButton) view.findViewById(R.id.btn_speed);
        ImageButton btn_temperature = (ImageButton) view.findViewById(R.id.btn_temperature);
        ImageButton btn_volume = (ImageButton) view.findViewById(R.id.btn_volume);
        ImageButton btn_currency = (ImageButton) view.findViewById(R.id.btn_currency);

        btn_length.setOnClickListener(this);
        btn_weight.setOnClickListener(this);
        btn_speed.setOnClickListener(this);
        btn_temperature.setOnClickListener(this);
        btn_volume.setOnClickListener(this);
        btn_currency.setOnClickListener(this);

        initCategories();
        this.selected_category = length;
    }

    public void show()
    {
        layout.show();
    }

    private void initCategories() {
        currency = new Currency();
        length = new Length();
        speed = new Speed();
        temperature = new Temperature();
        volume = new Volume();
        weight = new Weight();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_length: selected_category = length;
                break;
            case R.id.btn_weight: selected_category = weight;
                break;
            case R.id.btn_speed: selected_category = speed;
                break;
            case R.id.btn_temperature: selected_category = temperature;
                break;
            case R.id.btn_volume: selected_category = volume;
                break;
            case R.id.btn_currency: selected_category = currency;
                break;
        }

        main_activity.addNewConversionLine(selected_category);
        layout.hide();
    }
}
