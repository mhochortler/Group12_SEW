package at.maymay.convertme.core;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import at.maymay.convertme.application.core.dao.IDAOLength;
import at.maymay.convertme.application.core.model.Length;
import at.maymay.convertme.application.core.model.Unit;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LengthUnitTest {
    /**
     Naming-Convention: UnitOfWork_StateUnderTest_ExpectedBehavior
     Method-Construction: AAA -> Arrange-Act-Assert
     */

    private class DAOLengthMock implements IDAOLength {
        @Override
        public Length load()
        {
            Length length = new Length();
            List<Unit> units = length.getUnitList();
            units.clear();

            units.add(new Unit("Name1", "Shortcut1", 1));
            units.add(new Unit("Name2", "Shortcut2", 2));
            units.add(new Unit("Name3", "Shortcut3", 0.5));

            return length;
        }
    }

    private class DAOLengthMockEmpty implements IDAOLength {
        @Override
        public Length load()
        {
            Length length = new Length();
            List<Unit> units = length.getUnitList();
            units.clear();

            return length;
        }
    }

    IDAOLength dao;
    IDAOLength emptyDao;

    @Before
    public void init()
    {
        dao = new LengthUnitTest.DAOLengthMock();
        emptyDao = new LengthUnitTest.DAOLengthMockEmpty();
    }




    @Test
    public void getUnitList_unitsFromEmptyDaoMock_returnsEmptyList() throws Exception {
        Length lengths = emptyDao.load();
        List<Unit> units;

        units = lengths.getUnitList();

        assertEquals(0, units.size());
    }

    @Test
    public void getUnitList_unitsFromDaoMock_returnsListOfUnitsWithCorrectSize() throws Exception {
        Length lengths = dao.load();
        int expectedSize = 3;
        int actualSize;

        actualSize = lengths.getUnitList().size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getUnitList_unitsFromDaoMock_returnsCorrectListOfUnits() throws Exception {
        Length lengths = dao.load();
        List<Unit> actualLengthList;
        List<Unit> expectedLengthList = new ArrayList<>();
        expectedLengthList.add(new Unit("Name1", "Shortcut1", 1));
        expectedLengthList.add(new Unit("Name2", "Shortcut2", 2));
        expectedLengthList.add(new Unit("Name3", "Shortcut3", 0.5));


        actualLengthList = lengths.getUnitList();


        for(int i=0; i<expectedLengthList.size(); i++)
            assertEquals(expectedLengthList.get(i).getShortcut(),
                    actualLengthList.get(i).getShortcut());

        for(int i=0; i<expectedLengthList.size(); i++)
            assertEquals(expectedLengthList.get(i).getName(),
                    actualLengthList.get(i).getName());

        for(int i=0; i<expectedLengthList.size(); i++)
            assertEquals(expectedLengthList.get(i).getFactor(),
                    actualLengthList.get(i).getFactor(), 0.1);
    }




    @Test
    public void getStringifytList_unitsFromEmptyDaoMock_returnsEmptyList() throws Exception {
        Length lengths = emptyDao.load();
        String[] actualStringifytList;

        actualStringifytList = lengths.getStringifytUnitList();

        assertEquals(0, actualStringifytList.length);
    }

    @Test
    public void getStringifytList_unitsFromDaoMock_returnsStringifytUnitListWithCorrectLength() throws Exception {
        Length lengths = dao.load();
        int expectedSize = 3;
        int actualSize;

        actualSize = lengths.getStringifytUnitList().length;

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getStringifytList_unitsFromDaoMock_returnsStringifytUnitListWithCorrectStrings() throws Exception {
        Length lengths = dao.load();
        String[] expectedStringifytList = new String[] {"Shortcut1", "Shortcut2", "Shortcut3" };
        String[] actualStringifytList;

        actualStringifytList = lengths.getStringifytUnitList();

        for(int i=0; i<expectedStringifytList.length; i++)
            assertEquals(expectedStringifytList[i], actualStringifytList[i]);
    }





    @Test
    public void getUnitByShortcut_unitsFromEmptyDaoMock_returnsNullPointer() throws Exception {
        Length lengths = emptyDao.load();
        Unit expectedUnit = null;
        Unit actualUnit;

        actualUnit = lengths.GetUnitByShortcut("Shortcut1");

        assertEquals(expectedUnit, actualUnit);
    }

    @Test
    public void getFirstUnitByShortcut_unitsFromDaoMock_returnsCorrectUnit() throws Exception {
        Length lengths = dao.load();
        Unit expectedUnit = new Unit("Name1", "Shortcut1", 1);
        Unit actualUnit;

        actualUnit = lengths.GetUnitByShortcut("Shortcut1");

        assertEquals(expectedUnit.getShortcut(), actualUnit.getShortcut());
        assertEquals(expectedUnit.getName(), actualUnit.getName());
        assertEquals(expectedUnit.getFactor(), actualUnit.getFactor(), 0.1);
    }

    @Test
    public void getSecondUnitByShortcut_unitsFromDaoMock_returnsCorrectUnit() throws Exception {
        Length lengths = dao.load();
        Unit expectedUnit = new Unit("Name2", "Shortcut2", 2);
        Unit actualUnit;

        actualUnit = lengths.GetUnitByShortcut("Shortcut2");

        assertEquals(expectedUnit.getShortcut(), actualUnit.getShortcut());
        assertEquals(expectedUnit.getName(), actualUnit.getName());
        assertEquals(expectedUnit.getFactor(), actualUnit.getFactor(), 0.1);
    }

    @Test
    public void getThirdUnitByShortcut_unitsFromDaoMock_returnsCorrectUnit() throws Exception {
        Length lengths = dao.load();
        Unit expectedUnit = new Unit("Name3", "Shortcut3", 0.5);
        Unit actualUnit;

        actualUnit = lengths.GetUnitByShortcut("Shortcut3");

        assertEquals(expectedUnit.getShortcut(), actualUnit.getShortcut());
        assertEquals(expectedUnit.getName(), actualUnit.getName());
        assertEquals(expectedUnit.getFactor(), actualUnit.getFactor(), 0.1);
    }

    @Test
    public void getNonExistingUnitByShortcut_unitIsNotCreatedViaDaoMock_returnsNull() throws Exception {
        Length lengths = dao.load();
        Unit expectedUnit = null;
        Unit actualUnit;

        actualUnit = lengths.GetUnitByShortcut("NonExisting");

        assertEquals(expectedUnit, actualUnit);
    }






    @Test(expected = IllegalArgumentException.class)
    public void convertLengthUnits_unitFirstArgumentIsCorrupt_throwsIllegalArgumentException() throws Exception {
        Length lengths = dao.load();
        Unit corruptUnit = new Unit("ErrorName", "ErrorShortcut");
        Unit unit = new Unit("Name1", "Shortcut1");
        int value = 1;

        lengths.convert(corruptUnit, unit, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertLengthUnits_unitSecondArgumentIsCorrupt_throwsIllegalArgumentException() throws Exception {
        Length lengths = dao.load();
        Unit corruptUnit = new Unit("ErrorName", "ErrorShortcut");
        Unit unit = new Unit("Name1", "Shortcut1");
        int value = 1;

        lengths.convert(unit, corruptUnit, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertLengthUnits_unitBothArgumentsAreCorrupt_throwsIllegalArgumentException() throws Exception {
        Length lengths = dao.load();
        Unit corruptUnit = new Unit("ErrorName", "ErrorShortcut");
        int value = 1;

        lengths.convert(corruptUnit, corruptUnit, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertLengthUnits_withEmptyDAO_throwsIllegalArgumentException() throws Exception {
        Length lengths = emptyDao.load();
        Unit unit1 = new Unit("Name1", "Shortcut1");
        Unit unit2 = new Unit("Name2", "Shortcut2");
        int value = 1;

        lengths.convert(unit1, unit2, value);
    }

    @Test(expected = NullPointerException.class)
    public void convertLengthUnits_unitFirstArgumentIsNull_throwsNullPointerException() throws Exception {
        Length lengths = dao.load();
        Unit unit = new Unit("Name1", "Shortcut1");
        int value = 1;

        lengths.convert(null, unit, value);
    }

    @Test(expected = NullPointerException.class)
    public void convertLengthUnits_unitSecondArgumentIsNull_throwsNullPointerException() throws Exception {
        Length lengths = dao.load();
        Unit unit = new Unit("Name1", "Shortcut1");
        int value = 1;

        lengths.convert(unit, null, value);
    }

    @Test(expected = NullPointerException.class)
    public void convertLengthUnits_unitBothArgumentsAreNull_throwsNullPointerException() throws Exception {
        Length lengths = dao.load();
        int value = 1;

        lengths.convert(null, null, value);
    }





    @Test
    public void convertLengthUnits_twoUnitsOfSameType_returnsInputValue() throws Exception {
        Length lengths = dao.load();
        Unit unit1 = new Unit("Name1", "Shortcut1");
        Unit unit2 = new Unit("Name1", "Shortcut1");
        double value = 1.5;

        double retValue = lengths.convert(unit1, unit2, value);
        assertEquals(retValue, value, 0.1);
    }

    @Test
    public void convertLengthUnits_twoUnitsOfSameTypeWithZeroValue_returnsInputValue() throws Exception {
        Length lengths = dao.load();
        Unit unit1 = new Unit("Name1", "Shortcut1");
        Unit unit2 = new Unit("Name1", "Shortcut1");
        double value = 0;

        double retValue = lengths.convert(unit1, unit2, value);
        assertEquals(retValue, value, 0.1);
    }

    @Test
    public void convertLengthUnits_firstUnitToSecondUnit_returnsConvertedValue() throws Exception {
        Length lengths = dao.load();
        Unit unit1 = new Unit("Name1", "Shortcut1");
        Unit unit2 = new Unit("Name2", "Shortcut2");
        double value = 1.5;

        double retValue = lengths.convert(unit1, unit2, value);
        assertEquals(0.75, retValue, 0.01);
    }

    @Test
    public void convertLengthUnits_secondUnitToFirstUnit_returnsConvertedValue() throws Exception {
        Length lengths = dao.load();
        Unit unit1 = new Unit("Name2", "Shortcut2");
        Unit unit2 = new Unit("Name1", "Shortcut1");
        double value = 1.5;

        double retValue = lengths.convert(unit1, unit2, value);
        assertEquals(3, retValue, 0.01);
    }

    @Test
    public void convertLengthUnits_firstUnitToThirdUnit_returnsConvertedValue() throws Exception {
        Length lengths = dao.load();
        Unit unit1 = new Unit("Name1", "Shortcut1");
        Unit unit2 = new Unit("Name3", "Shortcut3");
        double value = 1.5;

        double retValue = lengths.convert(unit1, unit2, value);
        assertEquals(3, retValue, 0.01);
    }

    @Test
    public void convertLengthUnits_thirdUnitToFirstUnit_returnsConvertedValue() throws Exception {
        Length lengths = dao.load();
        Unit unit1 = new Unit("Name3", "Shortcut3");
        Unit unit2 = new Unit("Name1", "Shortcut1");
        double value = 1.5;

        double retValue = lengths.convert(unit1, unit2, value);
        assertEquals(0.75, retValue, 0.01);
    }

    @Test
    public void convertLengthUnits_secondUnitToThirdUnit_returnsConvertedValue() throws Exception {
        Length lengths = dao.load();
        Unit unit1 = new Unit("Name2", "Shortcut2");
        Unit unit2 = new Unit("Name3", "Shortcut3");
        double value = 1.5;

        double retValue = lengths.convert(unit1, unit2, value);
        assertEquals(6, retValue, 0.01);
    }

    @Test
    public void convertLengthUnits_thirdUnitToSecondUnit_returnsConvertedValue() throws Exception {
        Length lengths = dao.load();
        Unit unit1 = new Unit("Name3", "Shortcut3");
        Unit unit2 = new Unit("Name2", "Shortcut2");
        double value = 1.5;

        double retValue = lengths.convert(unit1, unit2, value);
        assertEquals(0.375, retValue, 0.01);
    }
}