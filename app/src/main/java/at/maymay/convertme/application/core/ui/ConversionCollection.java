package at.maymay.convertme.application.core.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import at.maymay.convertme.R;
import at.maymay.convertme.application.core.Converter;
import at.maymay.convertme.application.core.Profile;
import at.maymay.convertme.application.core.model.Category;
import at.maymay.convertme.application.core.model.Unit;

public class ConversionCollection implements AdapterView.OnItemSelectedListener{

    private View view;
    private Context context;

    private Profile selected_profile_right;
    private Profile selected_profile_left;

    private List<Profile> profiles;
    private List<ConversionElement> conversions;

    private Boolean delete_mode_on = false;

    public ConversionCollection(Context context, List<Profile> profiles)
    {
        ConstraintLayout layout_converter = (ConstraintLayout) ((Converter)context).findViewById(R.id.layout_conversion_collection);

        LayoutInflater inflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = Objects.requireNonNull(inflater).inflate(R.layout.conversion_collection_style, layout_converter, true);

        this.context = context;
        this.profiles = profiles;
        this.conversions = new ArrayList<>();

        selected_profile_left = profiles.get(0);
        selected_profile_right = profiles.get(1);

        Spinner profile_left = (Spinner) view.findViewById(R.id.spinner_profil_left);
        Spinner profile_right = (Spinner) view.findViewById(R.id.spinner_profil_right);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, getStringifytProfileList());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        profile_left.setAdapter(adapter);
        profile_right.setAdapter(adapter);

        profile_left.setSelection(0);
        profile_right.setSelection(1);

        profile_left.setOnItemSelectedListener(this);
        profile_right.setOnItemSelectedListener(this);
    }

    public View getView()
    {
        return view;
    }

    private List<String> getStringifytProfileList()
    {
        List<String> list_profiles = new ArrayList<>();

        for(Profile profile : profiles)
        {
            list_profiles.add(profile.getName());
        }

        return list_profiles;
    }

    private Profile getProfileByName(String name)
    {
        for(Profile profile : profiles)
        {
            if(profile.getName().equals(name))
            {
                return profile;
            }
        }

        throw new IllegalArgumentException("No profile with this name!");
    }

    public Boolean deleteModeOn()
    {
        return delete_mode_on;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
        Object selected_item = adapterView.getSelectedItem();
        Profile selected_profile = getProfileByName(selected_item.toString());

        switch(adapterView.getId())
        {
            case R.id.spinner_profil_left:
                selected_profile_left = selected_profile;
                break;
            case R.id.spinner_profil_right:
                selected_profile_right = selected_profile;
                break;
        }

        updateAllConversions();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }

    private void updateAllConversions()
    {
        Unit unit_left;
        Unit unit_right;

        for(ConversionElement element : conversions)
        {
            unit_left = selected_profile_left.getDefaultUnit(element.getCategory());
            unit_right = selected_profile_right.getDefaultUnit(element.getCategory());

            element.updateToNewProfile(unit_left, unit_right);
        }
    }

    private void updateConversion(ConversionElement element)
    {
        Unit unit_left = selected_profile_left.getDefaultUnit(element.getCategory());
        Unit unit_right = selected_profile_right.getDefaultUnit(element.getCategory());

        element.updateToNewProfile(unit_left, unit_right);
    }

    public void addNewConversion(Category category)
    {
        ConversionElement new_element = new ConversionElement(context, category, this);
        conversions.add(new_element);
        updateConversion(new_element);

        LinearLayout layout_conversions = (LinearLayout) view.findViewById(R.id.layout_conversions);
        if(delete_mode_on)new_element.transition(-200);
        layout_conversions.addView(new_element.getView());

        displayKeyboardAndSetFocus(new_element.getView());
    }

    public void deleteConversion(ConversionElement element)
    {
        conversions.remove(element);

        LinearLayout llayout = (LinearLayout) this.view.findViewById(R.id.layout_conversions);
        llayout.removeView(element.getView());

        hideKeyboardFromView(element.getView());
    }

    public void toggleDeleteMode(FloatingActionButton button)
    {
        if(delete_mode_on) {
            button.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffff4444")));

            for(ConversionElement element : conversions)
            {
                element.transition(0);
            }

            delete_mode_on = false;
        }
        else {

            button.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff669900")));

            for(ConversionElement element : conversions)
            {
                element.transition(-200);
            }

            delete_mode_on = true;
        }
    }

    private void displayKeyboardAndSetFocus(View view)
    {
        if(view != null)
        {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view.findFocus(), InputMethodManager.SHOW_IMPLICIT);
        }
    }

    private void hideKeyboardFromView(View view)
    {
        if(view != null)
        {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
