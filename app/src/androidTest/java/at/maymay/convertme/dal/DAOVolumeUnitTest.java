package at.maymay.convertme.dal;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import at.maymay.convertme.application.core.model.Unit;
import at.maymay.convertme.application.core.model.Volume;
import at.maymay.convertme.application.dal.dao.DAOVolume;

import static org.junit.Assert.assertEquals;

public class DAOVolumeUnitTest {
    /**
     Naming-Convention: UnitOfWork_StateUnderTest_ExpectedBehavior
     Method-Construction: AAA -> Arrange-Act-Assert
     */

    DAOVolume dao;

    @Before
    public void init()
    {
        dao = new DAOVolume();
    }

    @Test
    public void createVolumeCategory_daoVolumeLoadMethod_ReturnsNonEmptyListOfUnits() throws Exception {
        Volume volumes = dao.load();

        List<Unit> volumeList = volumes.getUnitList();
        boolean isEmpty = volumeList.isEmpty();

        assertEquals(false, isEmpty);
    }

    @Test
    public void createVolumeCategory_daoVolumeLoadMethod_ReturnsListOfUnitsWithCorrectSize() throws Exception {
        Volume volumes = dao.load();

        List<Unit> volumeList = volumes.getUnitList();
        int size = volumeList.size();

        assertEquals(18, size);
    }

    @Test
    public void createVolumeCategory_daoVolumeLoadMethod_ReturnsListOfUnitsWithCorrectShortcuts() throws Exception {
        Volume volumes = dao.load();
        String[] expectedShortcuts = new String[] {"L", "uslg", "uslq", "uslp", "uslc", "usfo", "ustap", "usts",
                "ig", "iq", "ip", "ic", "ifo", "itap", "its", "m³", "ft³", "in³"};

        List<Unit> volumeList = volumes.getUnitList();

        for(int i=0; i<expectedShortcuts.length; i++)
            assertEquals(expectedShortcuts[i], volumeList.get(i).getShortcut());
    }

    @Test
    public void createVolumeCategory_daoVolumeLoadMethod_ReturnsListOfUnitsWithCorrectNames() throws Exception {
        Volume volumes = dao.load();
        String[] expectedNames = new String[] {"Litre", "US liquid gallon", "US liquid quart", "US liquid pint",
                "US liquid cup", "US fluid ounce", "US tablespoon", "US teaspoon", "Imperial gallon",
                "Imperial quart", "Imperial pint", "Imperial cup", "Imperial fluid ounce", "Imperial tablespoon",
                "Imperial teaspoon", "Cubic metre", "Cubic foot", "Cubic inch"};

        List<Unit> volumeList = volumes.getUnitList();

        for(int i=0; i<expectedNames.length; i++)
            assertEquals(expectedNames[i], volumeList.get(i).getName());
    }

    @Test
    public void createVolumeCategory_daoVolumeLoadMethod_ReturnsListOfUnitsWithCorrectFactors() throws Exception {
        Volume volumes = dao.load();
        double[] expectedFactors = new double[] {1.0, 3.78541, 0.946353, 0.473176, 0.24, 0.0295735, 0.0147868,
                0.00492892, 4.54609, 1.13652, 0.568261, 0.284131, 0.0284131, 0.0177582, 0.00591939,
                1000.0, 28.3168, 0.0163871};

        List<Unit> volumeList = volumes.getUnitList();

        for(int i=0; i<expectedFactors.length; i++)
            assertEquals(expectedFactors[i], volumeList.get(i).getFactor(), 0.0001);
    }
}
