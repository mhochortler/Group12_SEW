package at.maymay.convertme.core;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import at.maymay.convertme.application.core.dao.IDAOWeight;
import at.maymay.convertme.application.core.model.Unit;
import at.maymay.convertme.application.core.model.Weight;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class WeightUnitTest {
    /**
     Naming-Convention: UnitOfWork_StateUnderTest_ExpectedBehavior
     Method-Construction: AAA -> Arrange-Act-Assert
     */
    private class DAOWeightMock implements IDAOWeight {
        @Override
        public Weight load()
        {
            Weight weight = new Weight();
            List<Unit> units = weight.getUnitList();
            units.clear();

            units.add(new Unit("Name1", "Shortcut1", 1));
            units.add(new Unit("Name2", "Shortcut2", 2));
            units.add(new Unit("Name3", "Shortcut3", 0.5));

            return weight;
        }
    }

    private class DAOWeightMockEmpty implements IDAOWeight {
        @Override
        public Weight load()
        {
            Weight weight = new Weight();
            List<Unit> units = weight.getUnitList();
            units.clear();

            return weight;
        }
    }

    IDAOWeight dao;
    IDAOWeight emptyDao;

    @Before
    public void init()
    {
        dao = new DAOWeightMock();
        emptyDao = new DAOWeightMockEmpty();
    }




    @Test
    public void getUnitList_unitsFromEmptyDaoMock_returnsEmptyList() throws Exception {
        Weight weights = emptyDao.load();
        List<Unit> units;

        units = weights.getUnitList();

        assertEquals(0, units.size());
    }

    @Test
    public void getUnitList_unitsFromDaoMock_returnsListOfUnitsWithCorrectSize() throws Exception {
        Weight weights = dao.load();
        int expectedSize = 3;
        int actualSize;

        actualSize = weights.getUnitList().size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getUnitList_unitsFromDaoMock_returnsCorrectListOfUnits() throws Exception {
        Weight weights = dao.load();
        List<Unit> actualWeightList;
        List<Unit> expectedWeightList = new ArrayList<>();
        expectedWeightList.add(new Unit("Name1", "Shortcut1", 1));
        expectedWeightList.add(new Unit("Name2", "Shortcut2", 2));
        expectedWeightList.add(new Unit("Name3", "Shortcut3", 0.5));


        actualWeightList = weights.getUnitList();


        for(int i=0; i<expectedWeightList.size(); i++)
            assertEquals(expectedWeightList.get(i).getShortcut(),
                    actualWeightList.get(i).getShortcut());

        for(int i=0; i<expectedWeightList.size(); i++)
            assertEquals(expectedWeightList.get(i).getName(),
                    actualWeightList.get(i).getName());

        for(int i=0; i<expectedWeightList.size(); i++)
            assertEquals(expectedWeightList.get(i).getFactor(),
                    actualWeightList.get(i).getFactor(), 0.1);
    }




    @Test
    public void getStringifytList_unitsFromEmptyDaoMock_returnsEmptyList() throws Exception {
        Weight weights = emptyDao.load();
        String[] actualStringifytList;

        actualStringifytList = weights.getStringifytUnitList();

        assertEquals(0, actualStringifytList.length);
    }

    @Test
    public void getStringifytList_unitsFromDaoMock_returnsStringifytUnitListWithCorrectLength() throws Exception {
        Weight weights = dao.load();
        int expectedSize = 3;
        int actualSize;

        actualSize = weights.getStringifytUnitList().length;

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getStringifytList_unitsFromDaoMock_returnsStringifytUnitListWithCorrectStrings() throws Exception {
        Weight weights = dao.load();
        String[] expectedStringifytList = new String[] {"Shortcut1", "Shortcut2", "Shortcut3" };
        String[] actualStringifytList;

        actualStringifytList = weights.getStringifytUnitList();

        for(int i=0; i<expectedStringifytList.length; i++)
            assertEquals(expectedStringifytList[i], actualStringifytList[i]);
    }





    @Test
    public void getUnitByShortcut_unitsFromEmptyDaoMock_returnsNullPointer() throws Exception {
        Weight weights = emptyDao.load();
        Unit expectedUnit = null;
        Unit actualUnit;

        actualUnit = weights.getUnitByShortcut("Shortcut1");

        assertEquals(expectedUnit, actualUnit);
    }

    @Test
    public void getFirstUnitByShortcut_unitsFromDaoMock_returnsCorrectUnit() throws Exception {
        Weight weights = dao.load();
        Unit expectedUnit = new Unit("Name1", "Shortcut1", 1);
        Unit actualUnit;

        actualUnit = weights.getUnitByShortcut("Shortcut1");

        assertEquals(expectedUnit.getShortcut(), actualUnit.getShortcut());
        assertEquals(expectedUnit.getName(), actualUnit.getName());
        assertEquals(expectedUnit.getFactor(), actualUnit.getFactor(), 0.1);
    }

    @Test
    public void getSecondUnitByShortcut_unitsFromDaoMock_returnsCorrectUnit() throws Exception {
        Weight weights = dao.load();
        Unit expectedUnit = new Unit("Name2", "Shortcut2", 2);
        Unit actualUnit;

        actualUnit = weights.getUnitByShortcut("Shortcut2");

        assertEquals(expectedUnit.getShortcut(), actualUnit.getShortcut());
        assertEquals(expectedUnit.getName(), actualUnit.getName());
        assertEquals(expectedUnit.getFactor(), actualUnit.getFactor(), 0.1);
    }

    @Test
    public void getThirdUnitByShortcut_unitsFromDaoMock_returnsCorrectUnit() throws Exception {
        Weight weights = dao.load();
        Unit expectedUnit = new Unit("Name3", "Shortcut3", 0.5);
        Unit actualUnit;

        actualUnit = weights.getUnitByShortcut("Shortcut3");

        assertEquals(expectedUnit.getShortcut(), actualUnit.getShortcut());
        assertEquals(expectedUnit.getName(), actualUnit.getName());
        assertEquals(expectedUnit.getFactor(), actualUnit.getFactor(), 0.1);
    }

    @Test
    public void getNonExistingUnitByShortcut_unitIsNotCreatedViaDaoMock_returnsNull() throws Exception {
        Weight weights = dao.load();
        Unit expectedUnit = null;
        Unit actualUnit;

        actualUnit = weights.getUnitByShortcut("NonExisting");

        assertEquals(expectedUnit, actualUnit);
    }






    @Test(expected = IllegalArgumentException.class)
    public void convertWeightUnits_unitFirstArgumentIsCorrupt_throwsIllegalArgumentException() throws Exception {
        Weight weights = dao.load();
        Unit corruptUnit = new Unit("ErrorName", "ErrorShortcut");
        Unit unit = new Unit("Name1", "Shortcut1");
        int value = 1;

        weights.convert(corruptUnit, unit, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertWeightUnits_unitSecondArgumentIsCorrupt_throwsIllegalArgumentException() throws Exception {
        Weight weights = dao.load();
        Unit corruptUnit = new Unit("ErrorName", "ErrorShortcut");
        Unit unit = new Unit("Name1", "Shortcut1");
        int value = 1;

        weights.convert(unit, corruptUnit, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertWeightUnits_unitBothArgumentsAreCorrupt_throwsIllegalArgumentException() throws Exception {
        Weight weights = dao.load();
        Unit corruptUnit = new Unit("ErrorName", "ErrorShortcut");
        int value = 1;

        weights.convert(corruptUnit, corruptUnit, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertWeightUnits_withEmptyDAO_throwsIllegalArgumentException() throws Exception {
        Weight weights = emptyDao.load();
        Unit unit1 = new Unit("Name1", "Shortcut1");
        Unit unit2 = new Unit("Name2", "Shortcut2");
        int value = 1;

        weights.convert(unit1, unit2, value);
    }

    @Test(expected = NullPointerException.class)
    public void convertWeightUnits_unitFirstArgumentIsNull_throwsNullPointerException() throws Exception {
        Weight weights = dao.load();
        Unit unit = new Unit("Name1", "Shortcut1");
        int value = 1;

        weights.convert(null, unit, value);
    }

    @Test(expected = NullPointerException.class)
    public void convertWeightUnits_unitSecondArgumentIsNull_throwsNullPointerException() throws Exception {
        Weight weights = dao.load();
        Unit unit = new Unit("Name1", "Shortcut1");
        int value = 1;

        weights.convert(unit, null, value);
    }

    @Test(expected = NullPointerException.class)
    public void convertWeightUnits_unitBothArgumentsAreNull_throwsNullPointerException() throws Exception {
        Weight weights = dao.load();
        int value = 1;

        weights.convert(null, null, value);
    }





    @Test
    public void convertWeightUnits_twoUnitsOfSameType_returnsInputValue() throws Exception {
        Weight weights = dao.load();
        Unit unit1 = new Unit("Name1", "Shortcut1");
        Unit unit2 = new Unit("Name1", "Shortcut1");
        double value = 1.5;

        double retValue = weights.convert(unit1, unit2, value);
        assertEquals(retValue, value, 0.1);
    }

    @Test
    public void convertWeightUnits_twoUnitsOfSameTypeWithZeroValue_returnsInputValue() throws Exception {
        Weight weights = dao.load();
        Unit unit1 = new Unit("Name1", "Shortcut1");
        Unit unit2 = new Unit("Name1", "Shortcut1");
        double value = 0;

        double retValue = weights.convert(unit1, unit2, value);
        assertEquals(retValue, value, 0.1);
    }

    @Test
    public void convertWeightUnits_firstUnitToSecondUnit_returnsConvertedValue() throws Exception {
        Weight weights = dao.load();
        Unit unit1 = new Unit("Name1", "Shortcut1");
        Unit unit2 = new Unit("Name2", "Shortcut2");
        double value = 1.5;

        double retValue = weights.convert(unit1, unit2, value);
        assertEquals(0.75, retValue, 0.01);
    }

    @Test
    public void convertWeightUnits_secondUnitToFirstUnit_returnsConvertedValue() throws Exception {
        Weight weights = dao.load();
        Unit unit1 = new Unit("Name2", "Shortcut2");
        Unit unit2 = new Unit("Name1", "Shortcut1");
        double value = 1.5;

        double retValue = weights.convert(unit1, unit2, value);
        assertEquals(3, retValue, 0.01);
    }

    @Test
    public void convertWeightUnits_firstUnitToThirdUnit_returnsConvertedValue() throws Exception {
        Weight weights = dao.load();
        Unit unit1 = new Unit("Name1", "Shortcut1");
        Unit unit2 = new Unit("Name3", "Shortcut3");
        double value = 1.5;

        double retValue = weights.convert(unit1, unit2, value);
        assertEquals(3, retValue, 0.01);
    }

    @Test
    public void convertWeightUnits_thirdUnitToFirstUnit_returnsConvertedValue() throws Exception {
        Weight weights = dao.load();
        Unit unit1 = new Unit("Name3", "Shortcut3");
        Unit unit2 = new Unit("Name1", "Shortcut1");
        double value = 1.5;

        double retValue = weights.convert(unit1, unit2, value);
        assertEquals(0.75, retValue, 0.01);
    }

    @Test
    public void convertWeightUnits_secondUnitToThirdUnit_returnsConvertedValue() throws Exception {
        Weight weights = dao.load();
        Unit unit1 = new Unit("Name2", "Shortcut2");
        Unit unit2 = new Unit("Name3", "Shortcut3");
        double value = 1.5;

        double retValue = weights.convert(unit1, unit2, value);
        assertEquals(6, retValue, 0.01);
    }

    @Test
    public void convertWeightUnits_thirdUnitToSecondUnit_returnsConvertedValue() throws Exception {
        Weight weights = dao.load();
        Unit unit1 = new Unit("Name3", "Shortcut3");
        Unit unit2 = new Unit("Name2", "Shortcut2");
        double value = 1.5;

        double retValue = weights.convert(unit1, unit2, value);
        assertEquals(0.375, retValue, 0.01);
    }

}