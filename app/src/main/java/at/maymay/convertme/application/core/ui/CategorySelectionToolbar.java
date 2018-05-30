package at.maymay.convertme.application.core.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;

import com.github.fafaldo.fabtoolbar.widget.FABToolbarLayout;

import at.maymay.convertme.R;
import at.maymay.convertme.application.config.AppConfig;
import at.maymay.convertme.application.core.CategoryContainer;
import at.maymay.convertme.application.core.ICategoryContainer;
import at.maymay.convertme.application.core.model.Category;
import at.maymay.convertme.application.core.Converter;

public class CategorySelectionToolbar implements View.OnClickListener
{
    private FABToolbarLayout layout_toolbar;
    private Category selected_category;
    private Converter main_activity;

    public CategorySelectionToolbar(Context context) {

        main_activity = (Converter) context;
        View view = main_activity.findViewById(R.id.layout_converter_main);

        layout_toolbar = (FABToolbarLayout) view.findViewById(R.id.layout_fabtoolbar);

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

        selected_category = AppConfig.categoryContainer().length();
    }

    public void show()
    {
        layout_toolbar.show();
    }

    public void hide()
    {
        layout_toolbar.hide();
    }

    @Override
    public void onClick(View view) {

        ICategoryContainer container = AppConfig.categoryContainer();

        switch (view.getId()){
            case R.id.btn_length: selected_category = container.length();
                break;
            case R.id.btn_weight: selected_category = container.weight();
                break;
            case R.id.btn_speed: selected_category = container.speed();
                break;
            case R.id.btn_temperature: selected_category = container.temperature();
                break;
            case R.id.btn_volume: selected_category = container.volume();
                break;
            case R.id.btn_currency: selected_category = container.currency();
                break;
        }

        main_activity.newConversion(selected_category);
        hide();
    }
}
