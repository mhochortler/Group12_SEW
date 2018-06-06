package at.maymay.convertme.core;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import at.maymay.convertme.application.core.ICategoryContainer;
import at.maymay.convertme.application.core.Profile;
import at.maymay.convertme.application.core.dao.IDAOProfile;
import at.maymay.convertme.application.core.dao.IDAOTemperature;
import at.maymay.convertme.application.core.model.Temperature;
import at.maymay.convertme.application.core.model.Unit;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ProfileContainerUnitTest {
    /**
     Naming-Convention: UnitOfWork_StateUnderTest_ExpectedBehavior
     Method-Construction: AAA -> Arrange-Act-Assert
     */
    private class DAOProfileMock implements IDAOProfile {
        @Override
        public List<Profile> loadAll(ICategoryContainer container)
        {
            List<Profile> profiles = new ArrayList<>();

            List<Unit> units_austria = new ArrayList<>();
            List<Unit> units_united_states = new ArrayList<>();

            units_austria.add(container.length().getUnitByShortcut("m"));
            units_austria.add(container.currency().getUnitByShortcut("EUR"));
            units_austria.add(container.weight().getUnitByShortcut("kg"));
            units_austria.add(container.volume().getUnitByShortcut("m³"));
            units_austria.add(container.speed().getUnitByShortcut("km/h"));
            units_austria.add(container.temperature().getUnitByShortcut("°C"));

            units_united_states.add(container.length().getUnitByShortcut("mile"));
            units_united_states.add(container.currency().getUnitByShortcut("USD"));
            units_united_states.add(container.weight().getUnitByShortcut("lp"));
            units_united_states.add(container.volume().getUnitByShortcut("m³"));
            units_united_states.add(container.speed().getUnitByShortcut("mile/h"));
            units_united_states.add(container.temperature().getUnitByShortcut("°F"));

            Profile austria = new Profile("Austria", "AUT", units_austria);
            Profile usa = new Profile("United States", "USA", units_united_states);

            profiles.add(austria);
            profiles.add(usa);

            return profiles;
        }
    }

    private class DAOProfileMockEmpty implements IDAOProfile {
        @Override
        public List<Profile> loadAll(ICategoryContainer container) {
            return null;
        }
    }



    IDAOProfile dao;
    IDAOProfile emptyDao;

    @Before
    public void init()
    {
        dao = new DAOProfileMock();
        emptyDao = new DAOProfileMockEmpty();
    }
}