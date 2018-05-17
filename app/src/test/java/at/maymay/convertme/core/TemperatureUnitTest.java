package at.maymay.convertme.core;

import org.junit.Test;

import java.util.List;

import at.maymay.convertme.application.core.model.Unit;
import at.maymay.convertme.application.core.model.Temperature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TemperatureUnitTest {
    /**
     Naming-Convention: UnitOfWork_StateUnderTest_ExpectedBehavior
     Methode-Construction: AAA -> Arrange-Act-Assert
     */

    @Test
    public void createTemperatureCategory_standardConstructor_ReturnsNonEmptyListOfUnits() throws Exception {
        Temperature temperatures = new Temperature();

        List<Unit> temperatureList = temperatures.getUnitList();
        boolean isEmpty = temperatureList.isEmpty();

        assertEquals(false, isEmpty);
    }

    @Test
    public void createTemperatureCategory_standardConstructor_ReturnsListOfUnitsWithCorrectSize() throws Exception {
        Temperature temperatures = new Temperature();

        List<Unit> temperatureList = temperatures.getUnitList();
        int size = temperatureList.size();

        assertEquals(3, size);
    }

    @Test
    public void createTemperatureCategory_standardConstructor_ReturnsListOfUnitsWithCorrectShortcuts() throws Exception {
        Temperature temperatures = new Temperature();
        String[] expectedShortcuts = new String[] {"°C", "°F", "K"};

        List<Unit> temperatureList = temperatures.getUnitList();

        for(int i=0; i<expectedShortcuts.length; i++)
            assertEquals(expectedShortcuts[i], temperatureList.get(i).getShortcut());
    }

    @Test
    public void createTemperatureCategory_standardConstructor_ReturnsStringifytUnitList() throws Exception {
        Temperature temperatures = new Temperature();
        String[] expectedList = new String[] {"°C", "°F", "K"};

        String[] stringifytList = temperatures.getStringifytUnitList();

        for(int i=0; i<expectedList.length; i++)
            assertEquals(expectedList[i], stringifytList[i]);
    }




    @Test
    public void createTemperatureCategory_standardConstructor_ReturnsCelsiusUnit() throws Exception {
        Temperature temperatures = new Temperature();

        Unit c =  temperatures.GetUnitByShortcut("°C");

        assertNotEquals(null, c);
    }

    @Test
    public void createTemperatureCategory_standardConstructor_RefCelsiusUnitByShortcutAndRefByTemperatureUnitListIsEqual() throws Exception {
        Temperature temperatures = new Temperature();
        List<Unit> temperatureList = temperatures.getUnitList();

        Unit temperature = temperatures.GetUnitByShortcut("°C");
        Unit temperatureFromList = temperatureList.get(0);

        assertEquals(temperature, temperatureFromList);
    }

    @Test
    public void createTemperatureCategory_standardConstructor_CelsiusUnitHasRightName() throws Exception {
        Temperature temperatures = new Temperature();

        Unit c = temperatures.GetUnitByShortcut("°C");
        String name = c.getName();

        assertEquals("Celsius", name);
    }

    @Test
    public void createTemperatureCategory_standardConstructor_CelsiusUnitHasRightFactor() throws Exception {
        Temperature temperatures = new Temperature();

        Unit c = temperatures.GetUnitByShortcut("°C");
        double factor = c.getFactor();

        assertEquals(1, factor, 0.001);
    }




    @Test
    public void createTemperatureCategory_standardConstructor_ReturnsFahrenheitUnit() throws Exception {
        Temperature temperatures = new Temperature();

        Unit f = temperatures.GetUnitByShortcut("°F");

        assertNotEquals(null, f);
    }

    @Test
    public void createTemperatureCategory_standardConstructor_RefFahrenheitUnitByShortcutAndRefByTemperatureUnitListIsEqual() throws Exception {
        Temperature temperatures = new Temperature();
        List<Unit> temperatureList = temperatures.getUnitList();

        Unit temperature = temperatures.GetUnitByShortcut("°F");
        Unit temperatureFromList = temperatureList.get(1);

        assertEquals(temperature, temperatureFromList);
    }

    @Test
    public void createTemperatureCategory_standardConstructor_FahrenheitUnitHasRightName() throws Exception {
        Temperature temperatures = new Temperature();

        Unit f = temperatures.GetUnitByShortcut("°F");
        String name = f.getName();

        assertEquals("Fahrenheit", name);
    }

    @Test
    public void createTemperatureCategory_standardConstructor_FahrenheitUnitHasRightFactor() throws Exception {
        Temperature temperatures = new Temperature();

        Unit f = temperatures.GetUnitByShortcut("°F");
        double factor = f.getFactor();

        assertEquals(1.8, factor, 0.001);
    }




    @Test
    public void createTemperatureCategory_standardConstructor_ReturnsKelvinUnit() throws Exception {
        Temperature temperatures = new Temperature();

        Unit k = temperatures.GetUnitByShortcut("K");

        assertNotEquals(null, k);
    }

    @Test
    public void createTemperatureCategory_standardConstructor_RefKelvinUnitByShortcutAndRefByTemperatureUnitListIsEqual() throws Exception {
        Temperature temperatures = new Temperature();
        List<Unit> temperatureList = temperatures.getUnitList();

        Unit temperature = temperatures.GetUnitByShortcut("K");
        Unit temperatureFromList = temperatureList.get(2);

        assertEquals(temperature, temperatureFromList);
    }


    @Test
    public void createTemperatureCategory_standardConstructor_KelvinUnitHasRightName() throws Exception {
        Temperature temperatures = new Temperature();

        Unit k = temperatures.GetUnitByShortcut("K");
        String name = k.getName();

        assertEquals("Kelvin", name);
    }

    @Test
    public void createTemperatureCategory_standardConstructor_KelvinUnitHasRightFactor() throws Exception {
        Temperature temperatures = new Temperature();

        Unit k = temperatures.GetUnitByShortcut("K");
        double factor = k.getFactor();

        assertEquals(274.15, factor, 0.001);
    }
}