package at.maymay.convertme.core;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import at.maymay.convertme.application.core.dao.IDAOTemperature;
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
     Method-Construction: AAA -> Arrange-Act-Assert
     */
    private class DAOTemperatureMock implements IDAOTemperature {
        @Override
        public Temperature load()
        {
            Temperature temperature = new Temperature();
            List<Unit> units = temperature.getUnitList();
            units.clear();

            units.add(new Unit("Celsius", "°C", 1));
            units.add(new Unit("Fahrenheit", "°F", 1.8));
            units.add(new Unit("Kelvin", "K", 273.15));

            return temperature;
        }
    }

    private class DAOTemperatureMockEmpty implements IDAOTemperature {
        @Override
        public Temperature load()
        {
            Temperature temperature = new Temperature();
            List<Unit> units = temperature.getUnitList();
            units.clear();

            return temperature;
        }
    }

    IDAOTemperature dao;
    IDAOTemperature emptyDao;

    @Before
    public void init()
    {
        dao = new DAOTemperatureMock();
        emptyDao = new DAOTemperatureMockEmpty();
    }

    @Test
    public void getUnitList_unitsFromEmptyDaoMock_returnsEmptyList() throws Exception {
        Temperature temperatures = emptyDao.load();
        List<Unit> units;

        units = temperatures.getUnitList();

        assertEquals(0, units.size());
    }

    @Test
    public void getUnitList_unitsFromDaoMock_returnsListOfUnitsWithCorrectSize() throws Exception {
        Temperature temperatures = dao.load();
        int expectedSize = 3;
        int actualSize;

        actualSize = temperatures.getUnitList().size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getUnitList_unitsFromDaoMock_returnsCorrectListOfUnits() throws Exception {
        Temperature temperatures = dao.load();
        List<Unit> actualTemperatureList;
        List<Unit> expectedTemperatureList = new ArrayList<>();
        expectedTemperatureList.add(new Unit("Celsius", "°C", 1));
        expectedTemperatureList.add(new Unit("Fahrenheit", "°F", 1.8));
        expectedTemperatureList.add(new Unit("Kelvin", "K", 273.15));


        actualTemperatureList = temperatures.getUnitList();


        for(int i=0; i<expectedTemperatureList.size(); i++)
            assertEquals(expectedTemperatureList.get(i).getShortcut(),
                    actualTemperatureList.get(i).getShortcut());

        for(int i=0; i<expectedTemperatureList.size(); i++)
            assertEquals(expectedTemperatureList.get(i).getName(),
                    actualTemperatureList.get(i).getName());

        for(int i=0; i<expectedTemperatureList.size(); i++)
            assertEquals(expectedTemperatureList.get(i).getFactor(),
                    actualTemperatureList.get(i).getFactor(), 0.1);
    }




    @Test
    public void getStringifytList_unitsFromEmptyDaoMock_returnsEmptyList() throws Exception {
        Temperature temperatures = emptyDao.load();
        String[] actualStringifytList;

        actualStringifytList = temperatures.getStringifytUnitList();

        assertEquals(0, actualStringifytList.length);
    }

    @Test
    public void getStringifytList_unitsFromDaoMock_returnsStringifytUnitListWithCorrectLength() throws Exception {
        Temperature temperatures = dao.load();
        int expectedSize = 3;
        int actualSize;

        actualSize = temperatures.getStringifytUnitList().length;

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getStringifytList_unitsFromDaoMock_returnsStringifytUnitListWithCorrectStrings() throws Exception {
        Temperature temperatures = dao.load();
        String[] expectedStringifytList = new String[] {"°C", "°F", "K" };
        String[] actualStringifytList;

        actualStringifytList = temperatures.getStringifytUnitList();

        for(int i=0; i<expectedStringifytList.length; i++)
            assertEquals(expectedStringifytList[i], actualStringifytList[i]);
    }





    @Test
    public void getUnitByShortcut_unitsFromEmptyDaoMock_returnsNullPointer() throws Exception {
        Temperature temperatures = emptyDao.load();
        Unit expectedUnit = null;
        Unit actualUnit;

        actualUnit = temperatures.getUnitByShortcut("°C");

        assertEquals(expectedUnit, actualUnit);
    }

    @Test
    public void getFirstUnitByShortcut_unitsFromDaoMock_returnsCorrectUnit() throws Exception {
        Temperature temperatures = dao.load();
        Unit expectedUnit = new Unit("Celsius", "°C", 1);
        Unit actualUnit;

        actualUnit = temperatures.getUnitByShortcut("°C");

        assertEquals(expectedUnit.getShortcut(), actualUnit.getShortcut());
        assertEquals(expectedUnit.getName(), actualUnit.getName());
        assertEquals(expectedUnit.getFactor(), actualUnit.getFactor(), 0.1);
    }

    @Test
    public void getSecondUnitByShortcut_unitsFromDaoMock_returnsCorrectUnit() throws Exception {
        Temperature temperatures = dao.load();
        Unit expectedUnit = new Unit("Fahrenheit", "°F", 1.8);
        Unit actualUnit;

        actualUnit = temperatures.getUnitByShortcut("°F");

        assertEquals(expectedUnit.getShortcut(), actualUnit.getShortcut());
        assertEquals(expectedUnit.getName(), actualUnit.getName());
        assertEquals(expectedUnit.getFactor(), actualUnit.getFactor(), 0.1);
    }

    @Test
    public void getThirdUnitByShortcut_unitsFromDaoMock_returnsCorrectUnit() throws Exception {
        Temperature temperatures = dao.load();
        Unit expectedUnit = new Unit("Kelvin", "K", 273.15);
        Unit actualUnit;

        actualUnit = temperatures.getUnitByShortcut("K");

        assertEquals(expectedUnit.getShortcut(), actualUnit.getShortcut());
        assertEquals(expectedUnit.getName(), actualUnit.getName());
        assertEquals(expectedUnit.getFactor(), actualUnit.getFactor(), 0.1);
    }

    @Test
    public void getNonExistingUnitByShortcut_unitIsNotCreatedViaDaoMock_returnsNull() throws Exception {
        Temperature temperatures = dao.load();
        Unit expectedUnit = null;
        Unit actualUnit;

        actualUnit = temperatures.getUnitByShortcut("NonExisting");

        assertEquals(expectedUnit, actualUnit);
    }






    @Test(expected = IllegalArgumentException.class)
    public void convertTemperatureUnits_unitFirstArgumentIsCorrupt_throwsIllegalArgumentException() throws Exception {
        Temperature temperatures = dao.load();
        Unit corruptUnit = new Unit("ErrorName", "ErrorShortcut");
        Unit unit = new Unit("Celsius", "°C");
        int value = 1;

        temperatures.convert(corruptUnit, unit, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertTemperatureUnits_unitSecondArgumentIsCorrupt_throwsIllegalArgumentException() throws Exception {
        Temperature temperatures = dao.load();
        Unit corruptUnit = new Unit("ErrorName", "ErrorShortcut");
        Unit unit = new Unit("Celsius", "°C");
        int value = 1;

        temperatures.convert(unit, corruptUnit, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertTemperatureUnits_unitBothArgumentsAreCorrupt_throwsIllegalArgumentException() throws Exception {
        Temperature temperatures = dao.load();
        Unit corruptUnit = new Unit("ErrorName", "ErrorShortcut");
        int value = 1;

        temperatures.convert(corruptUnit, corruptUnit, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertTemperatureUnits_withEmptyDAO_throwsIllegalArgumentException() throws Exception {
        Temperature temperatures = emptyDao.load();
        Unit unit1 = new Unit("Celsius", "°C");
        Unit unit2 = new Unit("Fahrenheit", "°F");
        int value = 1;

        temperatures.convert(unit1, unit2, value);
    }

    @Test(expected = NullPointerException.class)
    public void convertTemperatureUnits_unitFirstArgumentIsNull_throwsNullPointerException() throws Exception {
        Temperature temperatures = dao.load();
        Unit unit = new Unit("Celsius", "°C");
        int value = 1;

        temperatures.convert(null, unit, value);
    }

    @Test(expected = NullPointerException.class)
    public void convertTemperatureUnits_unitSecondArgumentIsNull_throwsNullPointerException() throws Exception {
        Temperature temperatures = dao.load();
        Unit unit = new Unit("Celsius", "°C");
        int value = 1;

        temperatures.convert(unit, null, value);
    }

    @Test(expected = NullPointerException.class)
    public void convertTemperatureUnits_unitBothArgumentsAreNull_throwsNullPointerException() throws Exception {
        Temperature temperatures = dao.load();
        int value = 1;

        temperatures.convert(null, null, value);
    }





    @Test
    public void convertTemperatureUnits_twoUnitsOfSameType_returnsInputValue() throws Exception {
        Temperature temperatures = dao.load();
        Unit unit1 = new Unit("Celsius", "°C");
        Unit unit2 = new Unit("Celsius", "°C");
        double value = 1.5;

        double retValue = temperatures.convert(unit1, unit2, value);
        assertEquals(retValue, value, 0.1);
    }

    @Test
    public void convertTemperatureUnits_twoUnitsOfSameTypeWithZeroValue_returnsInputValue() throws Exception {
        Temperature temperatures = dao.load();
        Unit unit1 = new Unit("Celsius", "°C");
        Unit unit2 = new Unit("Celsius", "°C");
        double value = 0;

        double retValue = temperatures.convert(unit1, unit2, value);
        assertEquals(retValue, value, 0.1);
    }

    @Test
    public void convertTemperatureUnits_firstUnitToSecondUnit_returnsConvertedValue() throws Exception {
        Temperature temperatures = dao.load();
        Unit unit1 = new Unit("Celsius", "°C");
        Unit unit2 = new Unit("Fahrenheit", "°F");
        double value = 1.5;

        double retValue = temperatures.convert(unit1, unit2, value);
        assertEquals(34.7, retValue, 0.01);
    }

    @Test
    public void convertTemperatureUnits_secondUnitToFirstUnit_returnsConvertedValue() throws Exception {
        Temperature temperatures = dao.load();
        Unit unit1 = new Unit("Fahrenheit", "°F");
        Unit unit2 = new Unit("Celsius", "°C");
        double value = 1.5;

        double retValue = temperatures.convert(unit1, unit2, value);
        assertEquals(-16.9444, retValue, 0.01);
    }

    @Test
    public void convertTemperatureUnits_firstUnitToThirdUnit_returnsConvertedValue() throws Exception {
        Temperature temperatures = dao.load();
        Unit unit1 = new Unit("Celsius", "°C");
        Unit unit2 = new Unit("Kelvin", "K");
        double value = 1.5;

        double retValue = temperatures.convert(unit1, unit2, value);
        assertEquals(274.65, retValue, 0.01);
    }

    @Test
    public void convertTemperatureUnits_thirdUnitToFirstUnit_returnsConvertedValue() throws Exception {
        Temperature temperatures = dao.load();
        Unit unit1 = new Unit("Kelvin", "K");
        Unit unit2 = new Unit("Celsius", "°C");
        double value = 1.5;

        double retValue = temperatures.convert(unit1, unit2, value);
        assertEquals(-271.65, retValue, 0.01);
    }

    @Test
    public void convertTemperatureUnits_secondUnitToThirdUnit_returnsConvertedValue() throws Exception {
        Temperature temperatures = dao.load();
        Unit unit1 = new Unit("Fahrenheit", "°F");
        Unit unit2 = new Unit("Kelvin", "K");
        double value = 1.5;

        double retValue = temperatures.convert(unit1, unit2, value);
        assertEquals(256.206, retValue, 0.01);
    }

    @Test
    public void convertTemperatureUnits_thirdUnitToSecondUnit_returnsConvertedValue() throws Exception {
        Temperature temperatures = dao.load();
        Unit unit1 = new Unit("Kelvin", "K");
        Unit unit2 = new Unit("Fahrenheit", "°F");
        double value = 1.5;

        double retValue = temperatures.convert(unit1, unit2, value);
        assertEquals(-456.97, retValue, 0.01);
    }
}