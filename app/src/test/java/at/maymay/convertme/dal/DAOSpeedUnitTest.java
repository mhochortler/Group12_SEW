package at.maymay.convertme.dal;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import at.maymay.convertme.application.core.model.Unit;
import at.maymay.convertme.application.core.model.Speed;
import at.maymay.convertme.application.dal.dao.DAOSpeed;

import static org.junit.Assert.assertEquals;

public class DAOSpeedUnitTest {
    /**
     * Naming-Convention: UnitOfWork_StateUnderTest_ExpectedBehavior
     * Method-Construction: AAA -> Arrange-Act-Assert
     */

    DAOSpeed dao;

    @Before
    public void init() {
        dao = new DAOSpeed();
    }

    @Test
    public void createSpeedCategory_daoSpeedLoadMethod_ReturnsNonEmptyListOfUnits() throws Exception {
        Speed speeds = dao.load();

        List<Unit> speedList = speeds.getUnitList();
        boolean isEmpty = speedList.isEmpty();

        assertEquals(false, isEmpty);
    }

    @Test
    public void createSpeedCategory_daoSpeedLoadMethod_ReturnsListOfUnitsWithCorrectSize() throws Exception {
        Speed speeds = dao.load();

        List<Unit> speedList = speeds.getUnitList();
        int size = speedList.size();

        assertEquals(5, size);
    }

    @Test
    public void createSpeedCategory_daoSpeedLoadMethod_ReturnsListOfUnitsWithCorrectShortcuts() throws Exception {
        Speed speeds = dao.load();
        String[] expectedShortcuts = new String[]{"km/h", "mile/h", "m/s", "ft/s", "kn"};

        List<Unit> speedList = speeds.getUnitList();

        for (int i = 0; i < expectedShortcuts.length; i++)
            assertEquals(expectedShortcuts[i], speedList.get(i).getShortcut());
    }

    @Test
    public void createSpeedCategory_daoSpeedLoadMethod_ReturnsListOfUnitsWithCorrectNames() throws Exception {
        Speed speeds = dao.load();
        String[] expectedNames = new String[]{"KilometersHours", "MilesHours", "MeterSeconds", "FootSeconds",
                "Knot"};

        List<Unit> speedList = speeds.getUnitList();

        for (int i = 0; i < expectedNames.length; i++)
            assertEquals(expectedNames[i], speedList.get(i).getName());
    }

    @Test
    public void createSpeedCategory_daoSpeedLoadMethod_ReturnsListOfUnitsWithCorrectFactors() throws Exception {
        Speed speeds = dao.load();
        double[] expectedFactors = new double[]{1.0, 1.6093445, 3.6, 1.0972805, 1.8519993};

        List<Unit> speedList = speeds.getUnitList();

        for (int i = 0; i < expectedFactors.length; i++)
            assertEquals(expectedFactors[i], speedList.get(i).getFactor(), 0.0001);
    }
}
