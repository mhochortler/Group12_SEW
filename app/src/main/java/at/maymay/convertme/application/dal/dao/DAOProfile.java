package at.maymay.convertme.application.dal.dao;

import java.util.ArrayList;
import java.util.List;

import at.maymay.convertme.application.core.ICategoryContainer;
import at.maymay.convertme.application.core.Profile;
import at.maymay.convertme.application.core.dao.IDAOProfile;
import at.maymay.convertme.application.core.model.Unit;

public class DAOProfile implements IDAOProfile {

    @Override
    public List<Profile> loadAll(ICategoryContainer container)
    {
        if(container == null)
            throw new NullPointerException("Invalid container, NULL-PTR!");

        List<Profile> profiles = new ArrayList<>();

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

        return profiles;
    }
}
