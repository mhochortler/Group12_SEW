package at.maymay.convertme.application.dal.dao;

import com.activeandroid.query.Select;
import com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import at.maymay.convertme.application.core.ICategoryContainer;
import at.maymay.convertme.application.core.Profile;
import at.maymay.convertme.application.core.dao.IDAOProfile;
import at.maymay.convertme.application.core.model.Unit;
import at.maymay.convertme.application.dal.ListTypeSerializer;
import at.maymay.convertme.application.dal.dalmodel.DALProfile;

public class DAOProfile implements IDAOProfile {

    @Override
    public List<Profile> loadAll(ICategoryContainer container)
    {
        if(container == null)
            throw new NullPointerException("Invalid container, NULL-PTR!");

        List<DALProfile> DALProfiles;
        List<Profile> profiles = new ArrayList<>();

        DALProfiles = loadDALProfiles();

        if(DALProfiles == null) {

            List<Unit> units_austria = new ArrayList<>();
            List<Unit> units_united_states = new ArrayList<>();

            units_austria.add(container.length().getMeter());
            units_austria.add(container.currency().getEuro());
            units_austria.add(container.weight().getKilogramm());
            units_austria.add(container.volume().getCubicMetre());
            units_austria.add(container.speed().getKmh());
            units_austria.add(container.temperature().getCelsius());

            units_united_states.add(container.length().getMile());
            units_united_states.add(container.currency().getUSD());
            units_united_states.add(container.weight().getPound());
            units_united_states.add(container.volume().getCubicMetre());
            units_united_states.add(container.speed().getMph());
            units_united_states.add(container.temperature().getFahrenheit());

            Profile austria = new Profile("Austria", "AUT", units_austria);
            Profile usa = new Profile("United States", "USA", units_united_states);

            profiles.add(austria);
            profiles.add(usa);

            DALProfiles = createDALProfileList(profiles);
            saveProfiles(DALProfiles);
        }
        else {
            profiles = convertDALProfilesToProfiles(DALProfiles);
        }
        return profiles;
    }

    private List<DALProfile> createDALProfileList(List<Profile> profiles_)
    {
        List<DALProfile> DALProfiles_ = new ArrayList<>();
        long remoteID = 1;
        for(Profile profile : profiles_)
        {
            DALProfile DALprofile = new DALProfile(profile.getName(), profile.getShortcut(), profile.getUnitList(), remoteID++);
            DALProfiles_.add(DALprofile);
        }
        return DALProfiles_;
    }

    private void saveProfiles(List<DALProfile> DALProfiles_)
    {
        if(DALProfiles_ == null)
            return;
        for(DALProfile DALProfile_ : DALProfiles_)
        {
            DALProfile_.serializeList();
            DALProfile_.save();
        }
    }

    private DALProfile loadProfileByID(long remoteID)
    {
        DALProfile profile_ = DALProfile.load(DALProfile.class, remoteID);
        profile_.deserializeList();
        return profile_;
    }

    private List<DALProfile> loadDALProfiles()
    {
        List<DALProfile> DALProfiles_;
        DALProfiles_ = new Select().from(DALProfile.class).execute();
        for(DALProfile DALProfile_ : DALProfiles_)
            DALProfile_.deserializeList();

        return  DALProfiles_;
    }

    private List<Profile> convertDALProfilesToProfiles(List<DALProfile> DALProfiles_)
    {
        List<Profile> profiles_ = new ArrayList<>();
        for(DALProfile DALProfile_ : DALProfiles_)
            profiles_.add(new Profile(DALProfile_.getName(), DALProfile_.getShortcut(), DALProfile_.getStandard_units()));
        return profiles_;
    }
}
