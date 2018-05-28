package at.maymay.convertme.application.config;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;

import java.util.ArrayList;
import java.util.List;

import at.maymay.convertme.application.core.CategoryContainer;
import at.maymay.convertme.application.core.Profile;
import at.maymay.convertme.application.core.ProfileContainer;
import at.maymay.convertme.application.core.dao.IDAOCurrency;
import at.maymay.convertme.application.core.dao.IDAOLength;
import at.maymay.convertme.application.core.dao.IDAOSpeed;
import at.maymay.convertme.application.core.dao.IDAOTemperature;
import at.maymay.convertme.application.core.dao.IDAOVolume;
import at.maymay.convertme.application.core.dao.IDAOWeight;
import at.maymay.convertme.application.core.model.Currency;
import at.maymay.convertme.application.core.model.Length;
import at.maymay.convertme.application.core.model.Speed;
import at.maymay.convertme.application.core.model.Temperature;
import at.maymay.convertme.application.core.model.Unit;
import at.maymay.convertme.application.core.model.Volume;
import at.maymay.convertme.application.core.model.Weight;
import at.maymay.convertme.application.dal.dalmodel.DALUnit;
import at.maymay.convertme.application.dal.dao.DAOCurrency;
import at.maymay.convertme.application.dal.dao.DAOLength;
import at.maymay.convertme.application.dal.dao.DAOSpeed;
import at.maymay.convertme.application.dal.dao.DAOTemperature;
import at.maymay.convertme.application.dal.dao.DAOVolume;
import at.maymay.convertme.application.dal.dao.DAOWeight;

public class AppConfig extends Application {

    static CategoryContainer container_;
    static ProfileContainer profile_container_;

    IDAOWeight daoWeight_;
    IDAOVolume daoVolume_;
    IDAOTemperature daoTemperature_;
    IDAOSpeed daoSpeed_;
    IDAOLength daoLength_;
    IDAOCurrency daoCurrency_;

    @Override
    public void onCreate() {
        super.onCreate();
        initDb();
        configureDAOInterface();
        initCategoryContainer();
        initProfileContainer();
    }

    static public CategoryContainer categoryContainer()
    {
        return container_;
    }

    static public ProfileContainer profileContainer()
    {
        return profile_container_;
    }

    private void initDb() {
        deleteDatabase("Database_ConvertMe.db");

        Configuration.Builder dbConfiguration = new Configuration.Builder(this);

        dbConfiguration.setDatabaseName("Database_ConvertMe.db");
        dbConfiguration.setDatabaseVersion(1);
        dbConfiguration.addModelClasses(DALUnit.class);

        ActiveAndroid.initialize(dbConfiguration.create());
    }

    private void initCategoryContainer()
    {
        Currency currency = daoCurrency_.load();
        Length length = daoLength_.load();
        Speed speed = daoSpeed_.load();
        Temperature temperature = daoTemperature_.load();
        Volume volume = daoVolume_.load();
        Weight weight = daoWeight_.load();

        container_ = new CategoryContainer(currency, length, speed, temperature, volume, weight);
    }

    private void initProfileContainer()
    {
        List<Profile> profiles = new ArrayList<>();

        List<Unit> units_austria = new ArrayList<>();
        List<Unit> units_united_states = new ArrayList<>();

        units_austria.add(container_.length().getMeter());
        units_austria.add(container_.currency().getEuro());
        units_austria.add(container_.weight().getKilogramm());
        units_austria.add(container_.volume().getCubicMetre());
        units_austria.add(container_.speed().getKmh());
        units_austria.add(container_.temperature().getCelsius());

        units_united_states.add(container_.length().getMile());
        units_united_states.add(container_.currency().getUSD());
        units_united_states.add(container_.weight().getPound());
        units_united_states.add(container_.volume().getCubicMetre());
        units_united_states.add(container_.speed().getMph());
        units_united_states.add(container_.temperature().getFahrenheit());

        Profile austria = new Profile("Austria", "AUT", units_austria);
        Profile usa = new Profile("United States", "USA", units_united_states);

        profiles.add(austria);
        profiles.add(usa);

        profile_container_ = new ProfileContainer(profiles);
    }

    private void configureDAOInterface()
    {
        daoWeight_ = new DAOWeight();
        daoVolume_ = new DAOVolume();
        daoTemperature_ = new DAOTemperature();
        daoSpeed_ = new DAOSpeed();
        daoLength_ = new DAOLength();
        daoCurrency_ = new DAOCurrency();
    }
}
