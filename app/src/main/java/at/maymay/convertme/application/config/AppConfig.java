package at.maymay.convertme.application.config;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;

public class AppConfig extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //initDb();
        initCurrencyExchangeRates();
    }

    private void initDb() {
        deleteDatabase("Database_ConvertMe.db");

        Configuration.Builder dbConfiguration = new Configuration.Builder(this);

        dbConfiguration.setDatabaseName("Database_ConvertMe.db");
        dbConfiguration.setDatabaseVersion(1);
        dbConfiguration.addModelClasses();

        ActiveAndroid.initialize(dbConfiguration.create());
    }

    private void initCurrencyExchangeRates() {
        //init exchange rates
        
    }

}
