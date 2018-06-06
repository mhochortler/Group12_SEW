package at.maymay.convertme.application.core;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.support.v7.widget.Toolbar;

import at.maymay.convertme.R;
import at.maymay.convertme.application.config.AppConfig;
import at.maymay.convertme.application.core.model.Category;
import at.maymay.convertme.application.core.ui.CategorySelectionToolbar;
import at.maymay.convertme.application.core.ui.ConversionCollection;
import at.maymay.convertme.application.core.ui.Settings;


public class Converter extends AppCompatActivity implements View.OnClickListener {
    FloatingActionButton btn_fabtoolbar;
    CategorySelectionToolbar fabtoolbar;
    ConversionCollection c_collection;
    static Context context;

    MenuItem item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_converter);

        c_collection = new ConversionCollection(this, AppConfig.profileContainer().profiles());
        btn_fabtoolbar = (FloatingActionButton) findViewById(R.id.btn_fabtoolbar);
        fabtoolbar = new CategorySelectionToolbar(this);
        btn_fabtoolbar.setOnClickListener(this);
      //  item = (MenuItem) new MenuItem();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem setting = menu.findItem(R.id.action_settings);
        setting.setEnabled(true);
      //  setting.setOnMenuItemClickListener(this);
        return true;
    }

    public void newConversion(Category category) {
        c_collection.addNewConversion(category);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_fabtoolbar:
                fabtoolbar.show();
                break;

        }
    }

    private void startActivity(Class object) {
        Intent myIntent = new Intent(Converter.this, object);
        Converter.this.startActivity(myIntent);
    }


    public static Context getAppContext() {
        return context;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(Settings.class);
                return true;
           /* case R.id.Help:
                showHelp();
                return true;
     */       default:
                return super.onOptionsItemSelected(item);
        }
    }
}
