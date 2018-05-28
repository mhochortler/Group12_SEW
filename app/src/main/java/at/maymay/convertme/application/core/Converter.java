package at.maymay.convertme.application.core;

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
    CategorySelectionToolbar fabtoolbar;
    ConversionCollection c_collection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        c_collection = new ConversionCollection(this, AppConfig.profileContainer().profiles());
        btn_fabtoolbar = (FloatingActionButton) findViewById(R.id.btn_fabtoolbar);
        fabtoolbar = new CategorySelectionToolbar(this);

        btn_fabtoolbar.setOnClickListener(this);
    }

    public void newConversion(Category category)
    {
        c_collection.addNewConversion(category);
    }

    @Override
    public void onClick(View view) {

        switch(view.getId())
        {
            case R.id.btn_fabtoolbar:
                fabtoolbar.show();
                break;
        }
    }
}