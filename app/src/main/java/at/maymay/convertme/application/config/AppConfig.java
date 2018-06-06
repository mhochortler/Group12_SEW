package at.maymay.convertme.application.config;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;

import at.maymay.convertme.application.core.CategoryContainer;
import at.maymay.convertme.application.core.ICategoryContainer;
import at.maymay.convertme.application.core.ProfileContainer;
import at.maymay.convertme.application.core.dao.IDAOCurrency;
import at.maymay.convertme.application.core.dao.IDAOLength;
import at.maymay.convertme.application.core.dao.IDAOProfile;
import at.maymay.convertme.application.core.dao.IDAOSpeed;
import at.maymay.convertme.application.core.dao.IDAOTemperature;
import at.maymay.convertme.application.core.dao.IDAOVolume;
import at.maymay.convertme.application.core.dao.IDAOWeight;
import at.maymay.convertme.application.core.model.Currency;
import at.maymay.convertme.application.core.model.Length;
import at.maymay.convertme.application.core.model.Speed;
import at.maymay.convertme.application.core.model.Temperature;

import at.maymay.convertme.application.core.model.Volume;
import at.maymay.convertme.application.core.model.Weight;
import at.maymay.convertme.application.dal.dao.DAOCurrency;
import at.maymay.convertme.application.dal.dao.DAOLength;
import at.maymay.convertme.application.dal.dao.DAOProfile;
import at.maymay.convertme.application.dal.dao.DAOSpeed;
import at.maymay.convertme.application.dal.dao.DAOTemperature;
import at.maymay.convertme.application.dal.dao.DAOVolume;
import at.maymay.convertme.application.dal.dao.DAOWeight;

public class AppConfig extends Application {

    static ICategoryContainer container_;
    static ProfileContainer profile_container_;

    IDAOWeight daoWeight_;
    IDAOVolume daoVolume_;
    IDAOTemperature daoTemperature_;
    IDAOSpeed daoSpeed_;
    IDAOLength daoLength_;
    IDAOProfile daoProfile_;
    static IDAOCurrency daoCurrency_;

    @Override
    public void onCreate() {
        super.onCreate();
        //initDb();
        configureDAOInterface();
        initCategoryContainer();
        initProfileContainer();
    }

    static public ICategoryContainer categoryContainer()
    {
        return container_;
    }

    static public ProfileContainer profileContainer()
    {
        return profile_container_;
    }

    /*private void initDb() {
        //deleteDatabase("Database_ConvertMe.db");

        Configuration.Builder dbConfiguration = new Configuration.Builder(this);

        dbConfiguration.setDatabaseName("Database_ConvertMe.db");
        dbConfiguration.setDatabaseVersion(1);
       // dbConfiguration.addModelClasses(DALUnit.class);
        dbConfiguration.addModelClasses(DALProfile.class);

        ActiveAndroid.initialize(dbConfiguration.create());
    }*/

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
        profile_container_ = new ProfileContainer(daoProfile_.loadAll(container_));
    }

    private void configureDAOInterface()
    {
        daoWeight_ = new DAOWeight();
        daoVolume_ = new DAOVolume();
        daoTemperature_ = new DAOTemperature();
        daoSpeed_ = new DAOSpeed();
        daoLength_ = new DAOLength();
        daoCurrency_ = new DAOCurrency();

        daoProfile_ = new DAOProfile();
    }

    /*public static void updateFactors()
    {
        daoCurrency_.update();
    }*/
}
