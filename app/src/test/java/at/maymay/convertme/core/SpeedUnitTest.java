package at.maymay.convertme.core;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import at.maymay.convertme.application.core.dao.IDAOSpeed;
import at.maymay.convertme.application.core.model.Speed;
import at.maymay.convertme.application.core.model.Unit;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SpeedUnitTest {
    /**
     Naming-Convention: UnitOfWork_StateUnderTest_ExpectedBehavior
     Method-Construction: AAA -> Arrange-Act-Assert
     */

    private class DAOSpeedMock implements IDAOSpeed {
        @Override
        public Speed load()
        {
            Speed speed = new Speed();
            List<Unit> units = speed.getUnitList();
            units.clear();

            units.add(new Unit("Name1", "Shortcut1", 1));
            units.add(new Unit("Name2", "Shortcut2", 2));
            units.add(new Unit("Name3", "Shortcut3", 0.5));

            return speed;
        }
    }

    private class DAOSpeedMockEmpty implements IDAOSpeed {
        @Override
        public Speed load()
        {
            Speed speed = new Speed();
            List<Unit> units = speed.getUnitList();
            units.clear();

            return speed;
        }
    }

    IDAOSpeed dao;
    IDAOSpeed emptyDao;

    @Before
    public void init()
    {
        dao = new SpeedUnitTest.DAOSpeedMock();
        emptyDao = new SpeedUnitTest.DAOSpeedMockEmpty();
    }




    @Test
    public void getUnitList_unitsFromEmptyDaoMock_returnsEmptyList() throws Exception {
        Speed speeds = emptyDao.load();
        List<Unit> units;

        units = speeds.getUnitList();

        assertEquals(0, units.size());
    }

    @Test
    public void getUnitList_unitsFromDaoMock_returnsListOfUnitsWithCorrectSize() throws Exception {
        Speed speeds = dao.load();
        int expectedSize = 3;
        int actualSize;

        actualSize = speeds.getUnitList().size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getUnitList_unitsFromDaoMock_returnsCorrectListOfUnits() throws Exception {
        Speed speeds = dao.load();
        List<Unit> actualSpeedList;
        List<Unit> expectedSpeedList = new ArrayList<>();
        expectedSpeedList.add(new Unit("Name1", "Shortcut1", 1));
        expectedSpeedList.add(new Unit("Name2", "Shortcut2", 2));
        expectedSpeedList.add(new Unit("Name3", "Shortcut3", 0.5));


        actualSpeedList = speeds.getUnitList();


        for(int i=0; i<expectedSpeedList.size(); i++)
            assertEquals(expectedSpeedList.get(i).getShortcut(),
                    actualSpeedList.get(i).getShortcut());

        for(int i=0; i<expectedSpeedList.size(); i++)
            assertEquals(expectedSpeedList.get(i).getName(),
                    actualSpeedList.get(i).getName());

        for(int i=0; i<expectedSpeedList.size(); i++)
            assertEquals(expectedSpeedList.get(i).getFactor(),
                    actualSpeedList.get(i).getFactor(), 0.1);
    }




    @Test
    public void getStringifytList_unitsFromEmptyDaoMock_returnsEmptyList() throws Exception {
        Speed speeds = emptyDao.load();
        String[] actualStringifytList;

        actualStringifytList = speeds.getStringifytUnitList();

        assertEquals(0, actualStringifytList.length);
    }

    @Test
    public void getStringifytList_unitsFromDaoMock_returnsStringifytUnitListWithCorrectSpeed() throws Exception {
        Speed speeds = dao.load();
        int expectedSize = 3;
        int actualSize;

        actualSize = speeds.getStringifytUnitList().length;

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getStringifytList_unitsFromDaoMock_returnsStringifytUnitListWithCorrectStrings() throws Exception {
        Speed speeds = dao.load();
        String[] expectedStringifytList = new String[] {"Shortcut1", "Shortcut2", "Shortcut3" };
        String[] actualStringifytList;

        actualStringifytList = speeds.getStringifytUnitList();

        for(int i=0; i<expectedStringifytList.length; i++)
            assertEquals(expectedStringifytList[i], actualStringifytList[i]);
    }





    @Test
    public void getUnitByShortcut_unitsFromEmptyDaoMock_returnsNullPointer() throws Exception {
        Speed speeds = emptyDao.load();
        Unit expectedUnit = null;
        Unit actualUnit;

        actualUnit = speeds.getUnitByShortcut("Shortcut1");

        assertEquals(expectedUnit, actualUnit);
    }

    @Test
    public void getFirstUnitByShortcut_unitsFromDaoMock_returnsCorrectUnit() throws Exception {
        Speed speeds = dao.load();
        Unit expectedUnit = new Unit("Name1", "Shortcut1", 1);
        Unit actualUnit;

        actualUnit = speeds.getUnitByShortcut("Shortcut1");

        assertEquals(expectedUnit.getShortcut(), actualUnit.getShortcut());
        assertEquals(expectedUnit.getName(), actualUnit.getName());
        assertEquals(expectedUnit.getFactor(), actualUnit.getFactor(), 0.1);
    }

    @Test
    public void getSecondUnitByShortcut_unitsFromDaoMock_returnsCorrectUnit() throws Exception {
        Speed speeds = dao.load();
        Unit expectedUnit = new Unit("Name2", "Shortcut2", 2);
        Unit actualUnit;

        actualUnit = speeds.getUnitByShortcut("Shortcut2");

        assertEquals(expectedUnit.getShortcut(), actualUnit.getShortcut());
        assertEquals(expectedUnit.getName(), actualUnit.getName());
        assertEquals(expectedUnit.getFactor(), actualUnit.getFactor(), 0.1);
    }

    @Test
    public void getThirdUnitByShortcut_unitsFromDaoMock_returnsCorrectUnit() throws Exception {
        Speed speeds = dao.load();
        Unit expectedUnit = new Unit("Name3", "Shortcut3", 0.5);
        Unit actualUnit;

        actualUnit = speeds.getUnitByShortcut("Shortcut3");

        assertEquals(expectedUnit.getShortcut(), actualUnit.getShortcut());
        assertEquals(expectedUnit.getName(), actualUnit.getName());
        assertEquals(expectedUnit.getFactor(), actualUnit.getFactor(), 0.1);
    }

    @Test
    public void getNonExistingUnitByShortcut_unitIsNotCreatedViaDaoMock_returnsNull() throws Exception {
        Speed speeds = dao.load();
        Unit expectedUnit = null;
        Unit actualUnit;

        actualUnit = speeds.getUnitByShortcut("NonExisting");

        assertEquals(expectedUnit, actualUnit);
    }






    @Test(expected = IllegalArgumentException.class)
    public void convertSpeedUnits_unitFirstArgumentIsCorrupt_throwsIllegalArgumentException() throws Exception {
        Speed speeds = dao.load();
        Unit corruptUnit = new Unit("ErrorName", "ErrorShortcut");
        Unit unit = new Unit("Name1", "Shortcut1");
        int value = 1;

        speeds.convert(corruptUnit, unit, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertSpeedUnits_unitSecondArgumentIsCorrupt_throwsIllegalArgumentException() throws Exception {
        Speed speeds = dao.load();
        Unit corruptUnit = new Unit("ErrorName", "ErrorShortcut");
        Unit unit = new Unit("Name1", "Shortcut1");
        int value = 1;

        speeds.convert(unit, corruptUnit, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertSpeedUnits_unitBothArgumentsAreCorrupt_throwsIllegalArgumentException() throws Exception {
        Speed speeds = dao.load();
        Unit corruptUnit = new Unit("ErrorName", "ErrorShortcut");
        int value = 1;

        speeds.convert(corruptUnit, corruptUnit, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertSpeedUnits_withEmptyDAO_throwsIllegalArgumentException() throws Exception {
        Speed speeds = emptyDao.load();
        Unit unit1 = new Unit("Name1", "Shortcut1");
        Unit unit2 = new Unit("Name2", "Shortcut2");
        int value = 1;

        speeds.convert(unit1, unit2, value);
    }

    @Test(expected = NullPointerException.class)
    public void convertSpeedUnits_unitFirstArgumentIsNull_throwsNullPointerException() throws Exception {
        Speed speeds = dao.load();
        Unit unit = new Unit("Name1", "Shortcut1");
        int value = 1;

        speeds.convert(null, unit, value);
    }

    @Test(expected = NullPointerException.class)
    public void convertSpeedUnits_unitSecondArgumentIsNull_throwsNullPointerException() throws Exception {
        Speed speeds = dao.load();
        Unit unit = new Unit("Name1", "Shortcut1");
        int value = 1;

        speeds.convert(unit, null, value);
    }

    @Test(expected = NullPointerException.class)
    public void convertSpeedUnits_unitBothArgumentsAreNull_throwsNullPointerException() throws Exception {
        Speed speeds = dao.load();
        int value = 1;

        speeds.convert(null, null, value);
    }





    @Test
    public void convertSpeedUnits_twoUnitsOfSameType_returnsInputValue() throws Exception {
        Speed speeds = dao.load();
        Unit unit1 = new Unit("Name1", "Shortcut1");
        Unit unit2 = new Unit("Name1", "Shortcut1");
        double value = 1.5;

        double retValue = speeds.convert(unit1, unit2, value);
        assertEquals(retValue, value, 0.1);
    }

    @Test
    public void convertSpeedUnits_twoUnitsOfSameTypeWithZeroValue_returnsInputValue() throws Exception {
        Speed speeds = dao.load();
        Unit unit1 = new Unit("Name1", "Shortcut1");
        Unit unit2 = new Unit("Name1", "Shortcut1");
        double value = 0;

        double retValue = speeds.convert(unit1, unit2, value);
        assertEquals(retValue, value, 0.1);
    }

    @Test
    public void convertSpeedUnits_firstUnitToSecondUnit_returnsConvertedValue() throws Exception {
        Speed speeds = dao.load();
        Unit unit1 = new Unit("Name1", "Shortcut1");
        Unit unit2 = new Unit("Name2", "Shortcut2");
        double value = 1.5;

        double retValue = speeds.convert(unit1, unit2, value);
        assertEquals(0.75, retValue, 0.01);
    }

    @Test
    public void convertSpeedUnits_secondUnitToFirstUnit_returnsConvertedValue() throws Exception {
        Speed speeds = dao.load();
        Unit unit1 = new Unit("Name2", "Shortcut2");
        Unit unit2 = new Unit("Name1", "Shortcut1");
        double value = 1.5;

        double retValue = speeds.convert(unit1, unit2, value);
        assertEquals(3, retValue, 0.01);
    }

    @Test
    public void convertSpeedUnits_firstUnitToThirdUnit_returnsConvertedValue() throws Exception {
        Speed speeds = dao.load();
        Unit unit1 = new Unit("Name1", "Shortcut1");
        Unit unit2 = new Unit("Name3", "Shortcut3");
        double value = 1.5;

        double retValue = speeds.convert(unit1, unit2, value);
        assertEquals(3, retValue, 0.01);
    }

    @Test
    public void convertSpeedUnits_thirdUnitToFirstUnit_returnsConvertedValue() throws Exception {
        Speed speeds = dao.load();
        Unit unit1 = new Unit("Name3", "Shortcut3");
        Unit unit2 = new Unit("Name1", "Shortcut1");
        double value = 1.5;

        double retValue = speeds.convert(unit1, unit2, value);
        assertEquals(0.75, retValue, 0.01);
    }

    @Test
    public void convertSpeedUnits_secondUnitToThirdUnit_returnsConvertedValue() throws Exception {
        Speed speeds = dao.load();
        Unit unit1 = new Unit("Name2", "Shortcut2");
        Unit unit2 = new Unit("Name3", "Shortcut3");
        double value = 1.5;

        double retValue = speeds.convert(unit1, unit2, value);
        assertEquals(6, retValue, 0.01);
    }

    @Test
    public void convertSpeedUnits_thirdUnitToSecondUnit_returnsConvertedValue() throws Exception {
        Speed speeds = dao.load();
        Unit unit1 = new Unit("Name3", "Shortcut3");
        Unit unit2 = new Unit("Name2", "Shortcut2");
        double value = 1.5;

        double retValue = speeds.convert(unit1, unit2, value);
        assertEquals(0.375, retValue, 0.01);
    }
}