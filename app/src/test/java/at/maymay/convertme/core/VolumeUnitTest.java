package at.maymay.convertme.core;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import at.maymay.convertme.application.core.dao.IDAOVolume;
import at.maymay.convertme.application.core.model.Volume;
import at.maymay.convertme.application.core.model.Unit;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class VolumeUnitTest {
    /**
     Naming-Convention: UnitOfWork_StateUnderTest_ExpectedBehavior
     Method-Construction: AAA -> Arrange-Act-Assert
     */

    private class DAOVolumeMock implements IDAOVolume {
        @Override
        public Volume load()
        {
            Volume volume = new Volume();
            List<Unit> units = volume.getUnitList();
            units.clear();

            units.add(new Unit("Name1", "Shortcut1", 1));
            units.add(new Unit("Name2", "Shortcut2", 2));
            units.add(new Unit("Name3", "Shortcut3", 0.5));

            return volume;
        }
    }

    private class DAOVolumeMockEmpty implements IDAOVolume {
        @Override
        public Volume load()
        {
            Volume volume = new Volume();
            List<Unit> units = volume.getUnitList();
            units.clear();

            return volume;
        }
    }

    IDAOVolume dao;
    IDAOVolume emptyDao;

    @Before
    public void init()
    {
        dao = new VolumeUnitTest.DAOVolumeMock();
        emptyDao = new VolumeUnitTest.DAOVolumeMockEmpty();
    }




    @Test
    public void getUnitList_unitsFromEmptyDaoMock_returnsEmptyList() throws Exception {
        Volume volumes = emptyDao.load();
        List<Unit> units;

        units = volumes.getUnitList();

        assertEquals(0, units.size());
    }

    @Test
    public void getUnitList_unitsFromDaoMock_returnsListOfUnitsWithCorrectSize() throws Exception {
        Volume volumes = dao.load();
        int expectedSize = 3;
        int actualSize;

        actualSize = volumes.getUnitList().size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getUnitList_unitsFromDaoMock_returnsCorrectListOfUnits() throws Exception {
        Volume volumes = dao.load();
        List<Unit> actualVolumeList;
        List<Unit> expectedVolumeList = new ArrayList<>();
        expectedVolumeList.add(new Unit("Name1", "Shortcut1", 1));
        expectedVolumeList.add(new Unit("Name2", "Shortcut2", 2));
        expectedVolumeList.add(new Unit("Name3", "Shortcut3", 0.5));


        actualVolumeList = volumes.getUnitList();


        for(int i=0; i<expectedVolumeList.size(); i++)
            assertEquals(expectedVolumeList.get(i).getShortcut(),
                    actualVolumeList.get(i).getShortcut());

        for(int i=0; i<expectedVolumeList.size(); i++)
            assertEquals(expectedVolumeList.get(i).getName(),
                    actualVolumeList.get(i).getName());

        for(int i=0; i<expectedVolumeList.size(); i++)
            assertEquals(expectedVolumeList.get(i).getFactor(),
                    actualVolumeList.get(i).getFactor(), 0.1);
    }




    @Test
    public void getStringifytList_unitsFromEmptyDaoMock_returnsEmptyList() throws Exception {
        Volume volumes = emptyDao.load();
        String[] actualStringifytList;

        actualStringifytList = volumes.getStringifytUnitList();

        assertEquals(0, actualStringifytList.length);
    }

    @Test
    public void getStringifytList_unitsFromDaoMock_returnsStringifytUnitListWithCorrectVolume() throws Exception {
        Volume volumes = dao.load();
        int expectedSize = 3;
        int actualSize;

        actualSize = volumes.getStringifytUnitList().length;

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getStringifytList_unitsFromDaoMock_returnsStringifytUnitListWithCorrectStrings() throws Exception {
        Volume volumes = dao.load();
        String[] expectedStringifytList = new String[] {"Shortcut1", "Shortcut2", "Shortcut3" };
        String[] actualStringifytList;

        actualStringifytList = volumes.getStringifytUnitList();

        for(int i=0; i<expectedStringifytList.length; i++)
            assertEquals(expectedStringifytList[i], actualStringifytList[i]);
    }





    @Test
    public void getUnitByShortcut_unitsFromEmptyDaoMock_returnsNullPointer() throws Exception {
        Volume volumes = emptyDao.load();
        Unit expectedUnit = null;
        Unit actualUnit;

        actualUnit = volumes.GetUnitByShortcut("Shortcut1");

        assertEquals(expectedUnit, actualUnit);
    }

    @Test
    public void getFirstUnitByShortcut_unitsFromDaoMock_returnsCorrectUnit() throws Exception {
        Volume volumes = dao.load();
        Unit expectedUnit = new Unit("Name1", "Shortcut1", 1);
        Unit actualUnit;

        actualUnit = volumes.GetUnitByShortcut("Shortcut1");

        assertEquals(expectedUnit.getShortcut(), actualUnit.getShortcut());
        assertEquals(expectedUnit.getName(), actualUnit.getName());
        assertEquals(expectedUnit.getFactor(), actualUnit.getFactor(), 0.1);
    }

    @Test
    public void getSecondUnitByShortcut_unitsFromDaoMock_returnsCorrectUnit() throws Exception {
        Volume volumes = dao.load();
        Unit expectedUnit = new Unit("Name2", "Shortcut2", 2);
        Unit actualUnit;

        actualUnit = volumes.GetUnitByShortcut("Shortcut2");

        assertEquals(expectedUnit.getShortcut(), actualUnit.getShortcut());
        assertEquals(expectedUnit.getName(), actualUnit.getName());
        assertEquals(expectedUnit.getFactor(), actualUnit.getFactor(), 0.1);
    }

    @Test
    public void getThirdUnitByShortcut_unitsFromDaoMock_returnsCorrectUnit() throws Exception {
        Volume volumes = dao.load();
        Unit expectedUnit = new Unit("Name3", "Shortcut3", 0.5);
        Unit actualUnit;

        actualUnit = volumes.GetUnitByShortcut("Shortcut3");

        assertEquals(expectedUnit.getShortcut(), actualUnit.getShortcut());
        assertEquals(expectedUnit.getName(), actualUnit.getName());
        assertEquals(expectedUnit.getFactor(), actualUnit.getFactor(), 0.1);
    }

    @Test
    public void getNonExistingUnitByShortcut_unitIsNotCreatedViaDaoMock_returnsNull() throws Exception {
        Volume volumes = dao.load();
        Unit expectedUnit = null;
        Unit actualUnit;

        actualUnit = volumes.GetUnitByShortcut("NonExisting");

        assertEquals(expectedUnit, actualUnit);
    }






    @Test(expected = IllegalArgumentException.class)
    public void convertVolumeUnits_unitFirstArgumentIsCorrupt_throwsIllegalArgumentException() throws Exception {
        Volume volumes = dao.load();
        Unit corruptUnit = new Unit("ErrorName", "ErrorShortcut");
        Unit unit = new Unit("Name1", "Shortcut1");
        int value = 1;

        volumes.convert(corruptUnit, unit, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertVolumeUnits_unitSecondArgumentIsCorrupt_throwsIllegalArgumentException() throws Exception {
        Volume volumes = dao.load();
        Unit corruptUnit = new Unit("ErrorName", "ErrorShortcut");
        Unit unit = new Unit("Name1", "Shortcut1");
        int value = 1;

        volumes.convert(unit, corruptUnit, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertVolumeUnits_unitBothArgumentsAreCorrupt_throwsIllegalArgumentException() throws Exception {
        Volume volumes = dao.load();
        Unit corruptUnit = new Unit("ErrorName", "ErrorShortcut");
        int value = 1;

        volumes.convert(corruptUnit, corruptUnit, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertVolumeUnits_withEmptyDAO_throwsIllegalArgumentException() throws Exception {
        Volume volumes = emptyDao.load();
        Unit unit1 = new Unit("Name1", "Shortcut1");
        Unit unit2 = new Unit("Name2", "Shortcut2");
        int value = 1;

        volumes.convert(unit1, unit2, value);
    }

    @Test(expected = NullPointerException.class)
    public void convertVolumeUnits_unitFirstArgumentIsNull_throwsNullPointerException() throws Exception {
        Volume volumes = dao.load();
        Unit unit = new Unit("Name1", "Shortcut1");
        int value = 1;

        volumes.convert(null, unit, value);
    }

    @Test(expected = NullPointerException.class)
    public void convertVolumeUnits_unitSecondArgumentIsNull_throwsNullPointerException() throws Exception {
        Volume volumes = dao.load();
        Unit unit = new Unit("Name1", "Shortcut1");
        int value = 1;

        volumes.convert(unit, null, value);
    }

    @Test(expected = NullPointerException.class)
    public void convertVolumeUnits_unitBothArgumentsAreNull_throwsNullPointerException() throws Exception {
        Volume volumes = dao.load();
        int value = 1;

        volumes.convert(null, null, value);
    }





    @Test
    public void convertVolumeUnits_twoUnitsOfSameType_returnsInputValue() throws Exception {
        Volume volumes = dao.load();
        Unit unit1 = new Unit("Name1", "Shortcut1");
        Unit unit2 = new Unit("Name1", "Shortcut1");
        double value = 1.5;

        double retValue = volumes.convert(unit1, unit2, value);
        assertEquals(retValue, value, 0.1);
    }

    @Test
    public void convertVolumeUnits_twoUnitsOfSameTypeWithZeroValue_returnsInputValue() throws Exception {
        Volume volumes = dao.load();
        Unit unit1 = new Unit("Name1", "Shortcut1");
        Unit unit2 = new Unit("Name1", "Shortcut1");
        double value = 0;

        double retValue = volumes.convert(unit1, unit2, value);
        assertEquals(retValue, value, 0.1);
    }

    @Test
    public void convertVolumeUnits_firstUnitToSecondUnit_returnsConvertedValue() throws Exception {
        Volume volumes = dao.load();
        Unit unit1 = new Unit("Name1", "Shortcut1");
        Unit unit2 = new Unit("Name2", "Shortcut2");
        double value = 1.5;

        double retValue = volumes.convert(unit1, unit2, value);
        assertEquals(0.75, retValue, 0.01);
    }

    @Test
    public void convertVolumeUnits_secondUnitToFirstUnit_returnsConvertedValue() throws Exception {
        Volume volumes = dao.load();
        Unit unit1 = new Unit("Name2", "Shortcut2");
        Unit unit2 = new Unit("Name1", "Shortcut1");
        double value = 1.5;

        double retValue = volumes.convert(unit1, unit2, value);
        assertEquals(3, retValue, 0.01);
    }

    @Test
    public void convertVolumeUnits_firstUnitToThirdUnit_returnsConvertedValue() throws Exception {
        Volume volumes = dao.load();
        Unit unit1 = new Unit("Name1", "Shortcut1");
        Unit unit2 = new Unit("Name3", "Shortcut3");
        double value = 1.5;

        double retValue = volumes.convert(unit1, unit2, value);
        assertEquals(3, retValue, 0.01);
    }

    @Test
    public void convertVolumeUnits_thirdUnitToFirstUnit_returnsConvertedValue() throws Exception {
        Volume volumes = dao.load();
        Unit unit1 = new Unit("Name3", "Shortcut3");
        Unit unit2 = new Unit("Name1", "Shortcut1");
        double value = 1.5;

        double retValue = volumes.convert(unit1, unit2, value);
        assertEquals(0.75, retValue, 0.01);
    }

    @Test
    public void convertVolumeUnits_secondUnitToThirdUnit_returnsConvertedValue() throws Exception {
        Volume volumes = dao.load();
        Unit unit1 = new Unit("Name2", "Shortcut2");
        Unit unit2 = new Unit("Name3", "Shortcut3");
        double value = 1.5;

        double retValue = volumes.convert(unit1, unit2, value);
        assertEquals(6, retValue, 0.01);
    }

    @Test
    public void convertVolumeUnits_thirdUnitToSecondUnit_returnsConvertedValue() throws Exception {
        Volume volumes = dao.load();
        Unit unit1 = new Unit("Name3", "Shortcut3");
        Unit unit2 = new Unit("Name2", "Shortcut2");
        double value = 1.5;

        double retValue = volumes.convert(unit1, unit2, value);
        assertEquals(0.375, retValue, 0.01);
    }
}