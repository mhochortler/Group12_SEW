package at.maymay.convertme.dal;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import at.maymay.convertme.application.core.ICategoryContainer;
import at.maymay.convertme.application.core.model.Currency;
import at.maymay.convertme.application.core.model.Length;
import at.maymay.convertme.application.core.model.Speed;
import at.maymay.convertme.application.core.model.Temperature;
import at.maymay.convertme.application.core.model.Unit;
import at.maymay.convertme.application.core.Profile;
import at.maymay.convertme.application.core.model.Volume;
import at.maymay.convertme.application.core.model.Weight;
import at.maymay.convertme.application.dal.dao.DAOProfile;

import static org.junit.Assert.assertEquals;

public class DAOProfileUnitTest {
    /**
     Naming-Convention: UnitOfWork_StateUnderTest_ExpectedBehavior
     Method-Construction: AAA -> Arrange-Act-Assert
     */

    DAOProfile dao_;
    ICategoryContainer categoryContainerContainer_;

    private class CategoryContainerMock implements ICategoryContainer
    {
        @Override
        public Currency currency(){
            Currency currency = new Currency();
            List<Unit> units = currency.getUnitList();
            units.clear();

            units.add(new Unit("Curr1", "C1", 1));
            units.add(new Unit("Curr2", "C2", 2));
            units.add(new Unit("Curr3", "C3", 0.5));

            return currency;
        }
        @Override
        public Length length(){
            return null;
        }
        @Override
        public Speed speed(){
            return null;
        }
        @Override
        public Temperature temperature(){
            return null;
        }
        @Override
        public Volume volume(){
            return null;
        }
        @Override
        public Weight weight(){
            return null;
        }
    }

    @Before
    public void init()
    {
        dao_ = new DAOProfile();
    }

    /*
    @Test
    public void createWeightCategory_daoWeightLoadAllMethod_ReturnsNonEmptyListOfUnits() throws Exception {
        List<Profile> profiles = dao.loadAll();

        List<Unit> weightList = weights.getUnitList();
        boolean isEmpty = weightList.isEmpty();

        assertEquals(false, isEmpty);
    }

    @Test
    public void createWeightCategory_daoWeightLoadMethod_ReturnsListOfUnitsWithCorrectSize() throws Exception {
        Weight weights = dao.load();

        List<Unit> weightList = weights.getUnitList();
        int size = weightList.size();

        assertEquals(8, size);
    }

    @Test
    public void createWeightCategory_daoWeightLoadMethod_ReturnsListOfUnitsWithCorrectShortcuts() throws Exception {
        Weight weights = dao.load();
        String[] expectedShortcuts = new String[] {"g","kg", "dag", "oz", "lb", "st", "ust", "it" };

        List<Unit> weightList = weights.getUnitList();

        for(int i=0; i<expectedShortcuts.length; i++)
            assertEquals(expectedShortcuts[i], weightList.get(i).getShortcut());
    }

    @Test
    public void createWeightCategory_daoWeightLoadMethod_ReturnsListOfUnitsWithCorrectNames() throws Exception {
        Weight weights = dao.load();
        String[] expectedNames = new String[] {"Gram", "Kilogram", "Decagram", "Ounce",
                "Pound", "Stone", "US Ton", "Imperial Ton" };

        List<Unit> weightList = weights.getUnitList();

        for(int i=0; i<expectedNames.length; i++)
            assertEquals(expectedNames[i], weightList.get(i).getName());
    }

    @Test
    public void createWeightCategory_daoWeightLoadMethod_ReturnsListOfUnitsWithCorrectFactors() throws Exception {
        Weight weights = dao.load();
        double[] expectedFactors = new double[] {1, 1000.0, 10.0, 28.349,
                453.592,6350.29, 907184.28568,1016050.0 };

        List<Unit> weightList = weights.getUnitList();

        for(int i=0; i<expectedFactors.length; i++)
            assertEquals(expectedFactors[i], weightList.get(i).getFactor(), 0.0001);
    }
    */
}
