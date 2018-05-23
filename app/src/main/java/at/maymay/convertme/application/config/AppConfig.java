package at.maymay.convertme.application.config;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;

import at.maymay.convertme.application.core.model.Unit;

public class AppConfig extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initDb();
    }

    private void initDb() {
        deleteDatabase("Database_ConvertMe.db");

        Configuration.Builder dbConfiguration = new Configuration.Builder(this);

        dbConfiguration.setDatabaseName("Database_ConvertMe.db");
        dbConfiguration.setDatabaseVersion(1);
        dbConfiguration.addModelClasses(Unit.class);

        ActiveAndroid.initialize(dbConfiguration.create());
    }

}
