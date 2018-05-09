package at.maymay.convertme.application.core.ui;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.github.fafaldo.fabtoolbar.widget.FABToolbarLayout;

import at.maymay.convertme.R;
import at.maymay.convertme.application.core.Category;
import at.maymay.convertme.application.core.Converter;
import at.maymay.convertme.application.core.Currency;
import at.maymay.convertme.application.core.Length;
import at.maymay.convertme.application.core.Profile;
import at.maymay.convertme.application.core.Speed;
import at.maymay.convertme.application.core.Temperature;
import at.maymay.convertme.application.core.Unit;
import at.maymay.convertme.application.core.Volume;
import at.maymay.convertme.application.core.Weight;

public class CategorySelectionToolbar implements View.OnClickListener{

    private Currency currency;
    private Length length;
    private Speed speed;
    private Temperature temperature;
    private Volume volume;
    private Weight weight;

    private Profile austria;
    private Profile america;

    private FABToolbarLayout layout;

    private Category selected_category;

    private Converter main_activity;

    public CategorySelectionToolbar(Context context) {

        main_activity = (Converter) context;
        View view = ((Converter)context).findViewById(R.id.main_layout);

        layout = (FABToolbarLayout) ((Converter) context).findViewById(R.id.layout_fabtoolbar);

        Button btn_length = (Button)view.findViewById(R.id.btn_length);
        Button btn_weight = (Button) view.findViewById(R.id.btn_weight);
        Button btn_speed = (Button) view.findViewById(R.id.btn_speed);
        Button btn_temperature = (Button) view.findViewById(R.id.btn_temperature);
        Button btn_volume = (Button) view.findViewById(R.id.btn_volume);
        Button btn_currency = (Button) view.findViewById(R.id.btn_currency);

        btn_length.setOnClickListener(this);
        btn_weight.setOnClickListener(this);
        btn_speed.setOnClickListener(this);
        btn_temperature.setOnClickListener(this);
        btn_volume.setOnClickListener(this);
        btn_currency.setOnClickListener(this);

        initProfiles();
        initCategories();
        setProfiles();
        changeProfileTo(austria);

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

    private void initProfiles() {
        austria = new Profile("Austria", "AT");
        america = new Profile("America", "US");
    }

    private void setProfiles() {
        setOneProfile(austria, length.getMeter(), speed.getKmh(), temperature.getCelsius(),
                volume.getLiter(), weight.getKilogramm(), currency.getEuro());

        setOneProfile(america, length.getYard(), speed.getMph(), temperature.getKelvin(),
                volume.getCubicFoot(), weight.getPound(), currency.getUSD());
    }

    private void setOneProfile(Profile profile, Unit length, Unit speed, Unit temperature,
                               Unit volume, Unit weight, Unit currency) {
        profile.setDefault_length(length);
        profile.setDefault_speed(speed);
        profile.setDefault_temperature(temperature);
        profile.setDefault_volume(volume);
        profile.setDefault_weight(weight);
        profile.setDefault_currency(currency);
    }

    private void changeProfileTo(Profile profile) {
        length.changeList(profile);
        speed.changeList(profile);
        temperature.changeList(profile);
        volume.changeList(profile);
        weight.changeList(profile);
        currency.changeList(profile);
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
