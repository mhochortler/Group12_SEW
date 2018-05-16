package at.maymay.convertme.application.core.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.github.fafaldo.fabtoolbar.widget.FABToolbarLayout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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

    private Spinner input_profile;
    private Spinner output_profile;

    private Profile austria;
    private Profile america;
    private List<Profile> ProfileList = new ArrayList<>();
    private List<String> ProfileShortcuts = new ArrayList<>();

    private FABToolbarLayout layout;

    private Category selected_category;

    private Converter main_activity;

    public CategorySelectionToolbar(Context context) {

        main_activity = (Converter) context;
        View view = ((Converter)context).findViewById(R.id.main_layout);

        this.input_profile = (Spinner) view.findViewById(R.id.input_profile);
        this.output_profile = (Spinner) view.findViewById(R.id.output_profile);

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

        initProfiles();
        initCategories();
        setProfiles();
        changeInputProfileTo(austria);
        changeOutputProfileTo(america);

        ProfileShortcuts.add(austria.getShortcut());
        ProfileShortcuts.add(america.getShortcut());

        ProfileList.add(america);
        ProfileList.add(austria);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, R.layout.spinner_style, ProfileShortcuts);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        input_profile.setAdapter(adapter);
        output_profile.setAdapter(adapter);

        input_profile.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                changeInputProfileTo(getProfileByShortcut(input_profile.getSelectedItem().toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        output_profile.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                changeOutputProfileTo(getProfileByShortcut(output_profile.getSelectedItem().toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

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

    private void changeInputProfileTo(Profile profile) {
        length.changeList(profile);
        speed.changeList(profile);
        temperature.changeList(profile);
        volume.changeList(profile);
        weight.changeList(profile);
        currency.changeList(profile);
    }

    private void changeOutputProfileTo(Profile profile) {
        length.changeOutputList(profile);
        speed.changeOutputList(profile);
        temperature.changeOutputList(profile);
        volume.changeOutputList(profile);
        weight.changeOutputList(profile);
        currency.changeOutputList(profile);
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

    public Profile getProfileByShortcut(String shortcut)
    {
        for(Profile profile : ProfileList)
        {
            if (profile.getShortcut().equals(shortcut))
            {
                return profile;
            }
        }
        return austria;
    }
}
