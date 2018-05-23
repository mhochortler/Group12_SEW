package at.maymay.convertme.core;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import at.maymay.convertme.application.core.Unit;
import at.maymay.convertme.application.core.Temperature;

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
        Temperature temperatures =  new Temperature();


        Unit k = temperatures.GetUnitByShortcut("K");
        double factor = k.getFactor();

        assertEquals(273.15, factor, 0.001);
    }





    @Test(expected = IllegalArgumentException.class)
    public void convertTemperatureUnits_unitFirstArgumentIsCorrupt_ThrowsIllegalArgumentException() throws Exception {
        Temperature temperatures =  new Temperature();
        Unit corruptUnit = new Unit("ErrorName", "ErrorShortcut");
        Unit unit = new Unit("Celsius", "°C");
        int value = 1;

        temperatures.convert(corruptUnit, unit, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertTemperatureUnits_unitSecondArgumentIsCorrupt_ThrowsIllegalArgumentException() throws Exception {
        Temperature temperatures =  new Temperature();
        Unit corruptUnit = new Unit("ErrorName", "ErrorShortcut");
        Unit unit = new Unit("Celsius", "°C");
        int value = 1;

        temperatures.convert(unit, corruptUnit, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertTemperatureUnits_unitBothArgumentsAreCorrupt_ThrowsIllegalArgumentException() throws Exception {
        Temperature temperatures =  new Temperature();
        Unit corruptUnit = new Unit("ErrorName", "ErrorShortcut");
        int value = 1;

        temperatures.convert(corruptUnit, corruptUnit, value);
    }

    @Test(expected = NullPointerException.class)
    public void convertTemperatureUnits_unitFirstArgumentIsNull_ThrowsNullPointerException() throws Exception {
        Temperature temperatures =  new Temperature();
        Unit unit = new Unit("Celsius", "°C");
        int value = 1;

        temperatures.convert(null, unit, value);
    }

    @Test(expected = NullPointerException.class)
    public void convertTemperatureUnits_unitSecondArgumentIsNull_ThrowsNullPointerException() throws Exception {
        Temperature temperatures =  new Temperature();
        Unit unit = new Unit("Celsius", "°C");
        int value = 1;

        temperatures.convert(unit, null, value);
    }

    @Test(expected = NullPointerException.class)
    public void convertTemperatureUnits_unitBothArgumentsAreNull_ThrowsNullPointerException() throws Exception {
        Temperature temperatures =  new Temperature();
        int value = 1;

        temperatures.convert(null, null, value);
    }





    @Test
    public void convertTemperatureUnits_twoUnitsOfSameType_ReturnsImputValue() throws Exception {
        Temperature temperatures =  new Temperature();
        Unit unit1 = new Unit("Celsius", "°C");
        Unit unit2 = new Unit("Celsius", "°C");
        double value = 1.5;

        double retValue = temperatures.convert(unit1, unit2, value);
        assertEquals(retValue, value, 0.0001);
    }

    @Test
    public void convertTemperatureUnits_twoUnitsOfSameTypeWithZeroValue_ReturnsImputValue() throws Exception {
        Temperature temperatures =  new Temperature();
        Unit unit1 = new Unit("Celsius", "°C");
        Unit unit2 = new Unit("Celsius", "°C");
        double value = 0;

        double retValue = temperatures.convert(unit1, unit2, value);
        assertEquals(retValue, value, 0.0001);
    }

    @Test
    public void convertTemperatureUnits_celsiusToFahrenheit_ReturnsConvertedValue() throws Exception {
        Temperature temperatures =  new Temperature();
        Unit unit1 = new Unit("Celsius", "°C");
        Unit unit2 = new Unit("Fahrenheit", "°F");
        double value = 1;

        double retValue = temperatures.convert(unit1, unit2, value);
        assertEquals(33.8, retValue, 0.0001);
    }

    @Test
    public void convertTemperatureUnits_fahrenheitToCelsius_ReturnsConvertedValue() throws Exception {
        Temperature temperatures =  new Temperature();
        Unit unit1 = new Unit("Fahrenheit", "°F");
        Unit unit2 = new Unit("Celsius", "°C");
        double value = 1;

        double retValue = temperatures.convert(unit1, unit2, value);
        assertEquals(-17.2222, retValue, 0.0001);
    }

    @Test
    public void convertTemperatureUnits_celsiusToKelvin_ReturnsConvertedValue() throws Exception {
        Temperature temperatures =  new Temperature();
        Unit unit1 = new Unit("Celsius", "°C");
        Unit unit2 = new Unit("Kelvin", "K");
        double value = 1;

        double retValue = temperatures.convert(unit1, unit2, value);
        assertEquals(274.15, retValue, 0.01);
    }

    @Test
    public void convertTemperatureUnits_kelvinToCelsius_ReturnsConvertedValue() throws Exception {
        Temperature temperatures =  new Temperature();
        Unit unit1 = new Unit("Kelvin", "K");
        Unit unit2 = new Unit("Celsius", "°C");
        double value = 1;

        double retValue = temperatures.convert(unit1, unit2, value);
        assertEquals(-272.15, retValue, 0.01);
    }

    @Test
    public void convertTemperatureUnits_fahrenheitToKelvin_ReturnsConvertedValue() throws Exception {
        Temperature temperatures =  new Temperature();
        Unit unit1 = new Unit("Fahrenheit", "°F");
        Unit unit2 = new Unit("Kelvin", "K");
        double value = 1;

        double retValue = temperatures.convert(unit1, unit2, value);
        assertEquals(255.92, retValue, 0.01);
    }

    @Test
    public void convertTemperatureUnits_kelvinToFahrenheit_ReturnsConvertedValue() throws Exception {
        Temperature temperatures =  new Temperature();
        Unit unit1 = new Unit("Kelvin", "K");
        Unit unit2 = new Unit("Fahrenheit", "°F");
        double value = 1;

        double retValue = temperatures.convert(unit1, unit2, value);
        assertEquals(-457.87, retValue, 0.01);
    }
}