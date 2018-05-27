package at.maymay.convertme.dal;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import at.maymay.convertme.application.core.model.Unit;
import at.maymay.convertme.application.core.model.Temperature;
import at.maymay.convertme.application.dal.dao.DAOTemperature;

import static org.junit.Assert.assertEquals;

public class DAOTemperatureUnitTest {
    /**
     Naming-Convention: UnitOfWork_StateUnderTest_ExpectedBehavior
     Method-Construction: AAA -> Arrange-Act-Assert
     */

    DAOTemperature dao;

    @Before
    public void init()
    {
        dao = new DAOTemperature();
    }

    @Test
    public void createTemperatureCategory_daoTemperatureLoadMethod_ReturnsNonEmptyListOfUnits() throws Exception {
        Temperature temperatures = dao.load();

        List<Unit> temperatureList = temperatures.getUnitList();
        boolean isEmpty = temperatureList.isEmpty();

        assertEquals(false, isEmpty);
    }

    @Test
    public void createTemperatureCategory_daoTemperatureLoadMethod_ReturnsListOfUnitsWithCorrectSize() throws Exception {
        Temperature temperatures = dao.load();

        List<Unit> temperatureList = temperatures.getUnitList();
        int size = temperatureList.size();

        assertEquals(3, size);
    }

    @Test
    public void createTemperatureCategory_daoTemperatureLoadMethod_ReturnsListOfUnitsWithCorrectShortcuts() throws Exception {
        Temperature temperatures = dao.load();
        String[] expectedShortcuts = new String[] {"°C", "°F", "K"};

        List<Unit> temperatureList = temperatures.getUnitList();

        for(int i=0; i<expectedShortcuts.length; i++)
            assertEquals(expectedShortcuts[i], temperatureList.get(i).getShortcut());
    }

    @Test
    public void createTemperatureCategory_daoTemperatureLoadMethod_ReturnsListOfUnitsWithCorrectNames() throws Exception {
        Temperature temperatures = dao.load();
        String[] expectedNames = new String[] {"Celsius", "Fahrenheit", "Kelvin"};

        List<Unit> temperatureList = temperatures.getUnitList();

        for(int i=0; i<expectedNames.length; i++)
            assertEquals(expectedNames[i], temperatureList.get(i).getName());
    }

    @Test
    public void createTemperatureCategory_daoTemperatureLoadMethod_ReturnsListOfUnitsWithCorrectFactors() throws Exception {
        Temperature temperatures = dao.load();
        double[] expectedFactors = new double[] {1.0, 1.8, 273.15};

        List<Unit> temperatureList = temperatures.getUnitList();

        for(int i=0; i<expectedFactors.length; i++)
            assertEquals(expectedFactors[i], temperatureList.get(i).getFactor(), 0.0001);
    }
}
