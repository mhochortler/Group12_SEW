package at.maymay.convertme.core;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import at.maymay.convertme.application.core.dao.IDAOCurrency;
import at.maymay.convertme.application.core.model.Currency;
import at.maymay.convertme.application.core.model.Unit;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CurrencyUnitTest {
    /**
     Naming-Convention: UnitOfWork_StateUnderTest_ExpectedBehavior
     Method-Construction: AAA -> Arrange-Act-Assert
     */

    private class DAOCurrencyMock implements IDAOCurrency {
        @Override
        public Currency load()
        {
            Currency currency = new Currency();
            List<Unit> units = currency.getUnitList();
            units.clear();

            units.add(new Unit("Name1", "Shortcut1", 1));
            units.add(new Unit("Name2", "Shortcut2", 2));
            units.add(new Unit("Name3", "Shortcut3", 0.5));

            return currency;
        }
    }

    private class DAOCurrencyMockEmpty implements IDAOCurrency {
        @Override
        public Currency load()
        {
            Currency currency = new Currency();
            List<Unit> units = currency.getUnitList();
            units.clear();

            return currency;
        }
    }

    IDAOCurrency dao;
    IDAOCurrency emptyDao;

    @Before
    public void init()
    {
        dao = new CurrencyUnitTest.DAOCurrencyMock();
        emptyDao = new CurrencyUnitTest.DAOCurrencyMockEmpty();
    }




    @Test
    public void getUnitList_unitsFromEmptyDaoMock_returnsEmptyList() throws Exception {
        Currency currencies = emptyDao.load();
        List<Unit> units;

        units = currencies.getUnitList();

        assertEquals(0, units.size());
    }

    @Test
    public void getUnitList_unitsFromDaoMock_returnsListOfUnitsWithCorrectSize() throws Exception {
        Currency currencies = dao.load();
        int expectedSize = 3;
        int actualSize;

        actualSize = currencies.getUnitList().size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getUnitList_unitsFromDaoMock_returnsCorrectListOfUnits() throws Exception {
        Currency currencies = dao.load();
        List<Unit> actualCurrencyList;
        List<Unit> expectedCurrencyList = new ArrayList<>();
        expectedCurrencyList.add(new Unit("Name1", "Shortcut1", 1));
        expectedCurrencyList.add(new Unit("Name2", "Shortcut2", 2));
        expectedCurrencyList.add(new Unit("Name3", "Shortcut3", 0.5));


        actualCurrencyList = currencies.getUnitList();


        for(int i=0; i<expectedCurrencyList.size(); i++)
            assertEquals(expectedCurrencyList.get(i).getShortcut(),
                    actualCurrencyList.get(i).getShortcut());

        for(int i=0; i<expectedCurrencyList.size(); i++)
            assertEquals(expectedCurrencyList.get(i).getName(),
                    actualCurrencyList.get(i).getName());

        for(int i=0; i<expectedCurrencyList.size(); i++)
            assertEquals(expectedCurrencyList.get(i).getFactor(),
                    actualCurrencyList.get(i).getFactor(), 0.1);
    }




    @Test
    public void getStringifytList_unitsFromEmptyDaoMock_returnsEmptyList() throws Exception {
        Currency currencies = emptyDao.load();
        String[] actualStringifytList;

        actualStringifytList = currencies.getStringifytUnitList();

        assertEquals(0, actualStringifytList.length);
    }

    @Test
    public void getStringifytList_unitsFromDaoMock_returnsStringifytUnitListWithCorrectCurrency() throws Exception {
        Currency currencies = dao.load();
        int expectedSize = 3;
        int actualSize;

        actualSize = currencies.getStringifytUnitList().length;

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getStringifytList_unitsFromDaoMock_returnsStringifytUnitListWithCorrectStrings() throws Exception {
        Currency currencies = dao.load();
        String[] expectedStringifytList = new String[] {"Shortcut1", "Shortcut2", "Shortcut3" };
        String[] actualStringifytList;

        actualStringifytList = currencies.getStringifytUnitList();

        for(int i=0; i<expectedStringifytList.length; i++)
            assertEquals(expectedStringifytList[i], actualStringifytList[i]);
    }





    @Test
    public void getUnitByShortcut_unitsFromEmptyDaoMock_returnsNullPointer() throws Exception {
        Currency currencies = emptyDao.load();
        Unit expectedUnit = null;
        Unit actualUnit;

        actualUnit = currencies.getUnitByShortcut("Shortcut1");

        assertEquals(expectedUnit, actualUnit);
    }

    @Test
    public void getFirstUnitByShortcut_unitsFromDaoMock_returnsCorrectUnit() throws Exception {
        Currency currencies = dao.load();
        Unit expectedUnit = new Unit("Name1", "Shortcut1", 1);
        Unit actualUnit;

        actualUnit = currencies.getUnitByShortcut("Shortcut1");

        assertEquals(expectedUnit.getShortcut(), actualUnit.getShortcut());
        assertEquals(expectedUnit.getName(), actualUnit.getName());
        assertEquals(expectedUnit.getFactor(), actualUnit.getFactor(), 0.1);
    }

    @Test
    public void getSecondUnitByShortcut_unitsFromDaoMock_returnsCorrectUnit() throws Exception {
        Currency currencies = dao.load();
        Unit expectedUnit = new Unit("Name2", "Shortcut2", 2);
        Unit actualUnit;

        actualUnit = currencies.getUnitByShortcut("Shortcut2");

        assertEquals(expectedUnit.getShortcut(), actualUnit.getShortcut());
        assertEquals(expectedUnit.getName(), actualUnit.getName());
        assertEquals(expectedUnit.getFactor(), actualUnit.getFactor(), 0.1);
    }

    @Test
    public void getThirdUnitByShortcut_unitsFromDaoMock_returnsCorrectUnit() throws Exception {
        Currency currencies = dao.load();
        Unit expectedUnit = new Unit("Name3", "Shortcut3", 0.5);
        Unit actualUnit;

        actualUnit = currencies.getUnitByShortcut("Shortcut3");

        assertEquals(expectedUnit.getShortcut(), actualUnit.getShortcut());
        assertEquals(expectedUnit.getName(), actualUnit.getName());
        assertEquals(expectedUnit.getFactor(), actualUnit.getFactor(), 0.1);
    }

    @Test
    public void getNonExistingUnitByShortcut_unitIsNotCreatedViaDaoMock_returnsNull() throws Exception {
        Currency currencies = dao.load();
        Unit expectedUnit = null;
        Unit actualUnit;

        actualUnit = currencies.getUnitByShortcut("NonExisting");

        assertEquals(expectedUnit, actualUnit);
    }

    @Test
    public void getUnitByName_unitsFromEmptyDaoMock_returnsNullPointer() throws Exception {
        Currency currencies = emptyDao.load();
        Unit expectedUnit = null;
        Unit actualUnit;

        actualUnit = currencies.getUnitByName("Name1");

        assertEquals(expectedUnit, actualUnit);
    }

    @Test
    public void getFirstUnitByName_unitsFromDaoMock_returnsCorrectUnit() throws Exception {
        Currency currencies = dao.load();
        Unit expectedUnit = new Unit("Name1", "Shortcut1", 1);
        Unit actualUnit;

        actualUnit = currencies.getUnitByName("Name1");

        assertEquals(expectedUnit.getShortcut(), actualUnit.getShortcut());
        assertEquals(expectedUnit.getName(), actualUnit.getName());
        assertEquals(expectedUnit.getFactor(), actualUnit.getFactor(), 0.1);
    }






    @Test(expected = IllegalArgumentException.class)
    public void convertCurrencyUnits_unitFirstArgumentIsCorrupt_throwsIllegalArgumentException() throws Exception {
        Currency currencies = dao.load();
        Unit corruptUnit = new Unit("ErrorName", "ErrorShortcut");
        Unit unit = new Unit("Name1", "Shortcut1");
        int value = 1;

        currencies.convert(corruptUnit, unit, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertCurrencyUnits_unitSecondArgumentIsCorrupt_throwsIllegalArgumentException() throws Exception {
        Currency currencies = dao.load();
        Unit corruptUnit = new Unit("ErrorName", "ErrorShortcut");
        Unit unit = new Unit("Name1", "Shortcut1");
        int value = 1;

        currencies.convert(unit, corruptUnit, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertCurrencyUnits_unitBothArgumentsAreCorrupt_throwsIllegalArgumentException() throws Exception {
        Currency currencies = dao.load();
        Unit corruptUnit = new Unit("ErrorName", "ErrorShortcut");
        int value = 1;

        currencies.convert(corruptUnit, corruptUnit, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertCurrencyUnits_withEmptyDAO_throwsIllegalArgumentException() throws Exception {
        Currency currencies = emptyDao.load();
        Unit unit1 = new Unit("Name1", "Shortcut1");
        Unit unit2 = new Unit("Name2", "Shortcut2");
        int value = 1;

        currencies.convert(unit1, unit2, value);
    }

    @Test(expected = NullPointerException.class)
    public void convertCurrencyUnits_unitFirstArgumentIsNull_throwsNullPointerException() throws Exception {
        Currency currencies = dao.load();
        Unit unit = new Unit("Name1", "Shortcut1");
        int value = 1;

        currencies.convert(null, unit, value);
    }

    @Test(expected = NullPointerException.class)
    public void convertCurrencyUnits_unitSecondArgumentIsNull_throwsNullPointerException() throws Exception {
        Currency currencies = dao.load();
        Unit unit = new Unit("Name1", "Shortcut1");
        int value = 1;

        currencies.convert(unit, null, value);
    }

    @Test(expected = NullPointerException.class)
    public void convertCurrencyUnits_unitBothArgumentsAreNull_throwsNullPointerException() throws Exception {
        Currency currencies = dao.load();
        int value = 1;

        currencies.convert(null, null, value);
    }





    @Test
    public void convertCurrencyUnits_twoUnitsOfSameType_returnsInputValue() throws Exception {
        Currency currencies = dao.load();
        Unit unit1 = new Unit("Name1", "Shortcut1");
        Unit unit2 = new Unit("Name1", "Shortcut1");
        double value = 1.5;

        double retValue = currencies.convert(unit1, unit2, value);
        assertEquals(retValue, value, 0.1);
    }

    @Test
    public void convertCurrencyUnits_twoUnitsOfSameTypeWithZeroValue_returnsInputValue() throws Exception {
        Currency currencies = dao.load();
        Unit unit1 = new Unit("Name1", "Shortcut1");
        Unit unit2 = new Unit("Name1", "Shortcut1");
        double value = 0;

        double retValue = currencies.convert(unit1, unit2, value);
        assertEquals(retValue, value, 0.1);
    }

    @Test
    public void convertCurrencyUnits_firstUnitToSecondUnit_returnsConvertedValue() throws Exception {
        Currency currencies = dao.load();
        Unit unit1 = new Unit("Name1", "Shortcut1");
        Unit unit2 = new Unit("Name2", "Shortcut2");
        double value = 1.5;

        double retValue = currencies.convert(unit1, unit2, value);
        assertEquals(0.75, retValue, 0.01);
    }

    @Test
    public void convertCurrencyUnits_secondUnitToFirstUnit_returnsConvertedValue() throws Exception {
        Currency currencies = dao.load();
        Unit unit1 = new Unit("Name2", "Shortcut2");
        Unit unit2 = new Unit("Name1", "Shortcut1");
        double value = 1.5;

        double retValue = currencies.convert(unit1, unit2, value);
        assertEquals(3, retValue, 0.01);
    }

    @Test
    public void convertCurrencyUnits_firstUnitToThirdUnit_returnsConvertedValue() throws Exception {
        Currency currencies = dao.load();
        Unit unit1 = new Unit("Name1", "Shortcut1");
        Unit unit2 = new Unit("Name3", "Shortcut3");
        double value = 1.5;

        double retValue = currencies.convert(unit1, unit2, value);
        assertEquals(3, retValue, 0.01);
    }

    @Test
    public void convertCurrencyUnits_thirdUnitToFirstUnit_returnsConvertedValue() throws Exception {
        Currency currencies = dao.load();
        Unit unit1 = new Unit("Name3", "Shortcut3");
        Unit unit2 = new Unit("Name1", "Shortcut1");
        double value = 1.5;

        double retValue = currencies.convert(unit1, unit2, value);
        assertEquals(0.75, retValue, 0.01);
    }

    @Test
    public void convertCurrencyUnits_secondUnitToThirdUnit_returnsConvertedValue() throws Exception {
        Currency currencies = dao.load();
        Unit unit1 = new Unit("Name2", "Shortcut2");
        Unit unit2 = new Unit("Name3", "Shortcut3");
        double value = 1.5;

        double retValue = currencies.convert(unit1, unit2, value);
        assertEquals(6, retValue, 0.01);
    }

    @Test
    public void convertCurrencyUnits_thirdUnitToSecondUnit_returnsConvertedValue() throws Exception {
        Currency currencies = dao.load();
        Unit unit1 = new Unit("Name3", "Shortcut3");
        Unit unit2 = new Unit("Name2", "Shortcut2");
        double value = 1.5;

        double retValue = currencies.convert(unit1, unit2, value);
        assertEquals(0.375, retValue, 0.01);
    }
}