package at.maymay.convertme.application.core;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import at.maymay.convertme.R;
import at.maymay.convertme.application.config.AppConfig;
import at.maymay.convertme.application.core.model.Category;
import at.maymay.convertme.application.core.ui.CategorySelectionToolbar;
import at.maymay.convertme.application.core.ui.ConversionCollection;

public class Converter extends AppCompatActivity implements View.OnClickListener
{
    FloatingActionButton btn_fabtoolbar;
    FloatingActionButton btn_delete;
    CategorySelectionToolbar fabtoolbar;
    ConversionCollection c_collection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        c_collection = new ConversionCollection(this, AppConfig.profileContainer().profiles());
        btn_fabtoolbar = (FloatingActionButton) findViewById(R.id.btn_fabtoolbar);
        btn_delete = (FloatingActionButton) findViewById(R.id.fab_delete);
        fabtoolbar = new CategorySelectionToolbar(this);

        btn_fabtoolbar.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
    }

    public void newConversion(Category category)
    {
        c_collection.addNewConversion(category);
    }

    public void showDeleteButton()
    {
        btn_delete.show();
    }

    public void showToolbarButton()
    {
        btn_fabtoolbar.show();
    }

    @Override
    public void onClick(View view) {

        switch(view.getId())
        {
            case R.id.btn_fabtoolbar:
                if(!c_collection.deleteModeOn())
                {
                    btn_delete.hide();
                    fabtoolbar.show();
                    btn_fabtoolbar.hide();
                }
                break;

            case R.id.fab_delete:
                c_collection.toggleDeleteMode(btn_delete);

                if(c_collection.deleteModeOn()) {
                    btn_fabtoolbar.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#36454f")));
                }
                else{
                    btn_fabtoolbar.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff303f9f")));
                }
        }
    }
}