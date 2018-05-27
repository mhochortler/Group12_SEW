package at.maymay.convertme.dal;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import at.maymay.convertme.application.core.model.Unit;
import at.maymay.convertme.application.core.model.Weight;
import at.maymay.convertme.application.dal.dao.DAOWeight;

import static org.junit.Assert.assertEquals;

public class DAOWeightUnitTest {
    /**
     Naming-Convention: UnitOfWork_StateUnderTest_ExpectedBehavior
     Method-Construction: AAA -> Arrange-Act-Assert
     */

    DAOWeight dao;

    @Before
    public void init()
    {
        dao = new DAOWeight();
    }

    @Test
    public void createWeightCategory_daoWeightLoadMethod_ReturnsNonEmptyListOfUnits() throws Exception {
        Weight weights = dao.load();

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
}
