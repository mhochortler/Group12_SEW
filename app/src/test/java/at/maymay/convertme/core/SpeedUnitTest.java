package at.maymay.convertme.core;

import org.junit.Test;

import java.util.List;

import at.maymay.convertme.application.core.model.Speed;
import at.maymay.convertme.application.core.model.Unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SpeedUnitTest {
    /**
     Naming-Convention: UnitOfWork_StateUnderTest_ExpectedBehavior
     Methode-Construction: AAA -> Arrange-Act-Assert
     */

    @Test
    public void createSpeedCategory_standardConstructor_ReturnsNonEmptyListOfUnits() throws Exception {
        Speed speeds = new Speed();

        List<Unit> speedList = speeds.getUnitList();
        boolean isEmpty = speedList.isEmpty();

        assertEquals(false, isEmpty);
    }

    @Test
    public void createSpeedCategory_standardConstructor_ReturnsListOfUnitsWithCorrectSize() throws Exception {
        Speed speeds = new Speed();

        List<Unit> speedList = speeds.getUnitList();
        int size = speedList.size();

        assertEquals(5, size);
    }

    @Test
    public void createSpeedCategory_standardConstructor_ReturnsListOfUnitsWithCorrectShortcuts() throws Exception {
        Speed speeds = new Speed();
        String[] expectedShortcuts = new String[] {"km/h", "mile/h", "ft/s", "m/s", "kn"};

        List<Unit> speedList = speeds.getUnitList();

        for(int i=0; i<expectedShortcuts.length; i++)
            assertEquals(expectedShortcuts[i], speedList.get(i).getShortcut());
    }

    @Test
    public void createSpeedCategory_standardConstructor_ReturnsStringifytUnitList() throws Exception {
        Speed speeds = new Speed();
        String[] expectedList = new String[] {"km/h", "mile/h", "ft/s", "m/s", "kn"};

        String[] stringifytList = speeds.getStringifytUnitList();

        for(int i=0; i<expectedList.length; i++)
            assertEquals(expectedList[i], stringifytList[i]);
    }





    @Test
    public void createSpeedCategory_standardConstructor_ReturnsKilometersHoursUnit() throws Exception {
        Speed speeds = new Speed();

        Unit unit =  speeds.GetUnitByShortcut("km/h");

        assertNotEquals(null, unit);
    }

    @Test
    public void createSpeedCategory_standardConstructor_RefKilometersHoursUnitByShortcutAndRefBySpeedUnitListIsEqual() throws Exception {
        Speed speeds = new Speed();
        List<Unit> speedList = speeds.getUnitList();

        Unit speed = speeds.GetUnitByShortcut("km/h");
        Unit speedFromList = speedList.get(0);

        assertEquals(speed, speedFromList);
    }

    @Test
    public void createSpeedCategory_standardConstructor_KilometersHoursUnitHasRightName() throws Exception {
        Speed speeds = new Speed();

        Unit unit =  speeds.GetUnitByShortcut("km/h");
        String name = unit.getName();

        assertEquals("KilometersHours", name);
    }

    @Test
    public void createSpeedTemperatureCategory_standardConstructor_KilometersHoursUnitHasRightFactor() throws Exception {
        Speed speeds = new Speed();

        Unit unit =  speeds.GetUnitByShortcut("km/h");
        double factor = unit.getFactor();

        assertEquals(1, factor, 0.1);
    }





    @Test
    public void createSpeedCategory_standardConstructor_ReturnsMilesHoursUnit() throws Exception {
        Speed speeds = new Speed();

        Unit unit =  speeds.GetUnitByShortcut("mile/h");

        assertNotEquals(null, unit);
    }

    @Test
    public void createSpeedCategory_standardConstructor_RefMilesHoursUnitByShortcutAndRefBySpeedUnitListIsEqual() throws Exception {
        Speed speeds = new Speed();
        List<Unit> speedList = speeds.getUnitList();

        Unit speed = speeds.GetUnitByShortcut("mile/h");
        Unit speedFromList = speedList.get(1);

        assertEquals(speed, speedFromList);
    }

    @Test
    public void createSpeedCategory_standardConstructor_MilesHoursUnitHasRightName() throws Exception {
        Speed speeds = new Speed();

        Unit unit =  speeds.GetUnitByShortcut("mile/h");
        String name = unit.getName();

        assertEquals("MilesHours", name);
    }

    @Test
    public void createSpeedTemperatureCategory_standardConstructor_MilesHoursUnitHasRightFactor() throws Exception {
        Speed speeds = new Speed();

        Unit unit =  speeds.GetUnitByShortcut("mile/h");
        double factor = unit.getFactor();

        assertEquals(1.6093445, factor, 0.0000001);
    }





    @Test
    public void createSpeedCategory_standardConstructor_ReturnsFootSecondsUnit() throws Exception {
        Speed speeds = new Speed();

        Unit unit =  speeds.GetUnitByShortcut("ft/s");

        assertNotEquals(null, unit);
    }

    @Test
    public void createSpeedCategory_standardConstructor_RefFootSecondsUnitByShortcutAndRefBySpeedUnitListIsEqual() throws Exception {
        Speed speeds = new Speed();
        List<Unit> speedList = speeds.getUnitList();

        Unit speed = speeds.GetUnitByShortcut("ft/s");
        Unit speedFromList = speedList.get(2);

        assertEquals(speed, speedFromList);
    }

    @Test
    public void createSpeedCategory_standardConstructor_FootSecondsUnitHasRightName() throws Exception {
        Speed speeds = new Speed();

        Unit unit =  speeds.GetUnitByShortcut("ft/s");
        String name = unit.getName();

        assertEquals("FootSeconds", name);
    }

    @Test
    public void createSpeedTemperatureCategory_standardConstructor_FootSecondsUnitHasRightFactor() throws Exception {
        Speed speeds = new Speed();

        Unit unit =  speeds.GetUnitByShortcut("ft/s");
        double factor = unit.getFactor();

        assertEquals(1.0972805, factor, 0.0000001);
    }





    @Test
    public void createSpeedCategory_standardConstructor_ReturnsMeterSecondsUnit() throws Exception {
        Speed speeds = new Speed();

        Unit unit =  speeds.GetUnitByShortcut("m/s");

        assertNotEquals(null, unit);
    }

    @Test
    public void createSpeedCategory_standardConstructor_RefMeterSecondsUnitByShortcutAndRefBySpeedUnitListIsEqual() throws Exception {
        Speed speeds = new Speed();
        List<Unit> speedList = speeds.getUnitList();

        Unit speed = speeds.GetUnitByShortcut("m/s");
        Unit speedFromList = speedList.get(3);

        assertEquals(speed, speedFromList);
    }

    @Test
    public void createSpeedCategory_standardConstructor_MeterSecondsUnitHasRightName() throws Exception {
        Speed speeds = new Speed();

        Unit unit =  speeds.GetUnitByShortcut("m/s");
        String name = unit.getName();

        assertEquals("MeterSeconds", name);
    }

    @Test
    public void createSpeedTemperatureCategory_standardConstructor_MeterSecondsUnitHasRightFactor() throws Exception {
        Speed speeds = new Speed();

        Unit unit =  speeds.GetUnitByShortcut("m/s");
        double factor = unit.getFactor();

        assertEquals(3.6, factor, 0.1);
    }





    @Test
    public void createSpeedCategory_standardConstructor_ReturnsKnotUnit() throws Exception {
        Speed speeds = new Speed();

        Unit unit =  speeds.GetUnitByShortcut("kn");

        assertNotEquals(null, unit);
    }

    @Test
    public void createSpeedCategory_standardConstructor_RefKnotUnitByShortcutAndRefBySpeedUnitListIsEqual() throws Exception {
        Speed speeds = new Speed();
        List<Unit> speedList = speeds.getUnitList();

        Unit speed = speeds.GetUnitByShortcut("kn");
        Unit speedFromList = speedList.get(4);

        assertEquals(speed, speedFromList);
    }

    @Test
    public void createSpeedCategory_standardConstructor_KnotUnitHasRightName() throws Exception {
        Speed speeds = new Speed();

        Unit unit =  speeds.GetUnitByShortcut("kn");
        String name = unit.getName();

        assertEquals("Knot", name);
    }

    @Test
    public void createSpeedTemperatureCategory_standardConstructor_KnotUnitHasRightFactor() throws Exception {
        Speed speeds = new Speed();

        Unit unit =  speeds.GetUnitByShortcut("kn");
        double factor = unit.getFactor();

        assertEquals(1.8519993, factor, 0.1);
    }
}