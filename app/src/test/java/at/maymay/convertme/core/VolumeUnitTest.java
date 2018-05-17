package at.maymay.convertme.core;

import org.junit.Test;

import java.util.List;

import at.maymay.convertme.application.core.model.Volume;
import at.maymay.convertme.application.core.model.Unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class VolumeUnitTest {
    /**
     Naming-Convention: UnitOfWork_StateUnderTest_ExpectedBehavior
     Methode-Construction: AAA -> Arrange-Act-Assert
     */

    @Test
    public void createVolumeCategory_standardConstructor_ReturnsNonEmptyListOfUnits() throws Exception {
        Volume volumes = new Volume();

        List<Unit> volumeList = volumes.getUnitList();
        boolean isEmpty = volumeList.isEmpty();

        assertEquals(false, isEmpty);
    }

    @Test
    public void createVolumeCategory_standardConstructor_ReturnsListOfUnitsWithCorrectSize() throws Exception {
        Volume volumes = new Volume();

        List<Unit> volumeList = volumes.getUnitList();
        int size = volumeList.size();

        assertEquals(18, size);
    }

    @Test
    public void createVolumeCategory_standardConstructor_ReturnsListOfUnitsWithCorrectShortcuts() throws Exception {
        Volume volumes = new Volume();
        String[] expectedShortcuts = new String[] {"l", "uslg", "uslq", "uslp", "uslc", "usfo", "ustap", "usts",
                                                   "ig", "iq", "ip", "ic", "ifo", "itap", "its",
                                                   "m³", "ft³", "in³"};

        List<Unit> volumeList = volumes.getUnitList();

        for(int i=0; i<expectedShortcuts.length; i++)
            assertEquals(expectedShortcuts[i], volumeList.get(i).getShortcut());
    }

    @Test
    public void createVolumeCategory_standardConstructor_ReturnsStringifytUnitList() throws Exception {
        Volume volumes = new Volume();
        String[] expectedList = new String[] {"l", "uslg", "uslq", "uslp", "uslc", "usfo", "ustap", "usts",
                                              "ig", "iq", "ip", "ic", "ifo", "itap", "its",
                                              "m³", "ft³", "in³"};

        String[] stringifytList = volumes.getStringifytUnitList();

        for(int i=0; i<expectedList.length; i++)
            assertEquals(expectedList[i], stringifytList[i]);
    }




    @Test
    public void createVolumeCategory_standardConstructor_ReturnsLitreUnit() throws Exception {
        Volume volumes = new Volume();

        Unit unit = volumes.GetUnitByShortcut("l");

        assertNotEquals(null, unit);
    }

    @Test
    public void createVolumeCategory_standardConstructor_RefLitreUnitByShortcutAndRefByVolumeUnitListIsEqual() throws Exception {
        Volume volumes = new Volume();
        List<Unit> volumeList = volumes.getUnitList();

        Unit volume = volumes.GetUnitByShortcut("l");
        Unit volumeFromList = volumeList.get(0);

        assertEquals(volume, volumeFromList);
    }

    @Test
    public void createVolumeCategory_standardConstructor_LitreUnitHasRightName() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("l");
        String name = unit.getName();

        assertEquals("Litre", name);
    }

    @Test
    public void createVolumeCategory_standardConstructor_LitreUnitHasRightFactor() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("l");
        double factor = unit.getFactor();

        assertEquals(1, factor, 0.001);
    }




    @Test
    public void createVolumeCategory_standardConstructor_ReturnsUSLiquidGallonUnit() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("uslg");

        assertNotEquals(null, unit);
    }

    @Test
    public void createVolumeCategory_standardConstructor_RefUSLiquidGallonUnitByShortcutAndRefByVolumeUnitListIsEqual() throws Exception {
        Volume volumes = new Volume();
        List<Unit> volumeList = volumes.getUnitList();

        Unit volume = volumes.GetUnitByShortcut("uslg");
        Unit volumeFromList = volumeList.get(1);

        assertEquals(volume, volumeFromList);
    }

    @Test
    public void createVolumeCategory_standardConstructor_USLiquidGallonUnitHasRightName() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("uslg");
        String name = unit.getName();

        assertEquals("US liquid gallon", name);
    }

    @Test
    public void createVolumeCategory_standardConstructor_USLiquidGallonUnitHasRightFactor() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("uslg");
        double factor = unit.getFactor();

        assertEquals(3.78541, factor, 0.00001);
    }




    @Test
    public void createVolumeCategory_standardConstructor_ReturnsUSLiquidQuartUnit() throws Exception {
        Volume volumes = new Volume();

        Unit unit = volumes.GetUnitByShortcut("uslq");

        assertNotEquals(null, unit);
    }

    @Test
    public void createVolumeCategory_standardConstructor_RefUSLiquidQuartUnitByShortcutAndRefByVolumeUnitListIsEqual() throws Exception {
        Volume volumes = new Volume();
        List<Unit> volumeList = volumes.getUnitList();

        Unit volume = volumes.GetUnitByShortcut("uslq");
        Unit volumeFromList = volumeList.get(2);

        assertEquals(volume, volumeFromList);
    }

    @Test
    public void createVolumeCategory_standardConstructor_USLiquidQuartUnitHasRightName() throws Exception {
        Volume volumes = new Volume();

        Unit unit = volumes.GetUnitByShortcut("uslq");
        String name = unit.getName();

        assertEquals("US liquid quart", name);
    }

    @Test
    public void createVolumeCategory_standardConstructor_USLiquidQuartUnitHasRightFactor() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("uslq");
        double factor = unit.getFactor();

        assertEquals(0.946353, factor, 0.00001);
    }



    @Test
    public void createVolumeCategory_standardConstructor_ReturnsUSLiquidPintUnit() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("uslp");

        assertNotEquals(null, unit);
    }

    @Test
    public void createVolumeCategory_standardConstructor_RefUSLiquidPintUnitByShortcutAndRefByVolumeUnitListIsEqual() throws Exception {
        Volume volumes = new Volume();
        List<Unit> volumeList = volumes.getUnitList();

        Unit volume = volumes.GetUnitByShortcut("uslp");
        Unit volumeFromList = volumeList.get(3);

        assertEquals(volume, volumeFromList);
    }

    @Test
    public void createVolumeCategory_standardConstructor_USLiquidPintUnitHasRightName() throws Exception {
        Volume volumes = new Volume();

        Unit unit = volumes.GetUnitByShortcut("uslp");
        String name = unit.getName();

        assertEquals("US liquid pint", name);
    }

    @Test
    public void createVolumeCategory_standardConstructor_USLiquidPintUnitHasRightFactor() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("uslp");
        double factor = unit.getFactor();

        assertEquals(0.473176, factor, 0.00001);
    }




    @Test
    public void createVolumeCategory_standardConstructor_ReturnsUSLiquidCupUnit() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("uslc");

        assertNotEquals(null, unit);
    }

    @Test
    public void createVolumeCategory_standardConstructor_RefUSLiquidCupUnitByShortcutAndRefByVolumeUnitListIsEqual() throws Exception {
        Volume volumes = new Volume();
        List<Unit> volumeList = volumes.getUnitList();

        Unit volume = volumes.GetUnitByShortcut("uslc");
        Unit volumeFromList = volumeList.get(4);

        assertEquals(volume, volumeFromList);
    }

    @Test
    public void createVolumeCategory_standardConstructor_USLiquidCupUnitHasRightName() throws Exception {
        Volume volumes = new Volume();

        Unit unit = volumes.GetUnitByShortcut("uslc");
        String name = unit.getName();

        assertEquals("US liquid cup", name);
    }

    @Test
    public void createVolumeCategory_standardConstructor_USLiquidCupUnitHasRightFactor() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("uslc");
        double factor = unit.getFactor();

        assertEquals(0.24, factor, 0.01);
    }




    @Test
    public void createVolumeCategory_standardConstructor_ReturnsUSFluidOunceUnit() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("usfo");

        assertNotEquals(null, unit);
    }

    @Test
    public void createVolumeCategory_standardConstructor_RefUSFluidOunceUnitByShortcutAndRefByVolumeUnitListIsEqual() throws Exception {
        Volume volumes = new Volume();
        List<Unit> volumeList = volumes.getUnitList();

        Unit volume = volumes.GetUnitByShortcut("usfo");
        Unit volumeFromList = volumeList.get(5);

        assertEquals(volume, volumeFromList);
    }


    @Test
    public void createVolumeCategory_standardConstructor_USFluidOunceUnitHasRightName() throws Exception {
        Volume volumes = new Volume();

        Unit unit = volumes.GetUnitByShortcut("usfo");
        String name = unit.getName();

        assertEquals("US fluid ounce", name);
    }

    @Test
    public void createVolumeCategory_standardConstructor_USFluidOunceUnitHasRightFactor() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("usfo");
        double factor = unit.getFactor();

        assertEquals(0.0295735, factor, 0.00001);
    }




    @Test
    public void createVolumeCategory_standardConstructor_ReturnsUSTablespoonUnit() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("ustap");

        assertNotEquals(null, unit);
    }

    @Test
    public void createVolumeCategory_standardConstructor_RefUSTablespoonUnitByShortcutAndRefByVolumeUnitListIsEqual() throws Exception {
        Volume volumes = new Volume();
        List<Unit> volumeList = volumes.getUnitList();

        Unit volume = volumes.GetUnitByShortcut("ustap");
        Unit volumeFromList = volumeList.get(6);

        assertEquals(volume, volumeFromList);
    }

    @Test
    public void createVolumeCategory_standardConstructor_USTablespoonUnitHasRightName() throws Exception {
        Volume volumes = new Volume();

        Unit unit = volumes.GetUnitByShortcut("ustap");
        String name = unit.getName();

        assertEquals("US tablespoon", name);
    }

    @Test
    public void createVolumeCategory_standardConstructor_USTablespoonUnitHasRightFactor() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("ustap");
        double factor = unit.getFactor();

        assertEquals(0.0147868, factor, 0.00001);
    }




    @Test
    public void createVolumeCategory_standardConstructor_ReturnsUSTeaspoonUnit() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("usts");

        assertNotEquals(null, unit);
    }

    @Test
    public void createVolumeCategory_standardConstructor_RefUSTeaspoonUnitByShortcutAndRefByVolumeUnitListIsEqual() throws Exception {
        Volume volumes = new Volume();
        List<Unit> volumeList = volumes.getUnitList();

        Unit volume = volumes.GetUnitByShortcut("usts");
        Unit volumeFromList = volumeList.get(7);

        assertEquals(volume, volumeFromList);
    }

    @Test
    public void createVolumeCategory_standardConstructor_USTeaspoonUnitHasRightName() throws Exception {
        Volume volumes = new Volume();

        Unit unit = volumes.GetUnitByShortcut("usts");
        String name = unit.getName();

        assertEquals("US teaspoon", name);
    }

    @Test
    public void createVolumeCategory_standardConstructor_USTeaspoonUnitHasRightFactor() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("usts");
        double factor = unit.getFactor();

        assertEquals(0.00492892, factor, 0.0000001);
    }




    @Test
    public void createVolumeCategory_standardConstructor_ReturnsImperialGallonUnit() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("ig");

        assertNotEquals(null, unit);
    }

    @Test
    public void createVolumeCategory_standardConstructor_RefImperialGallonUnitByShortcutAndRefByVolumeUnitListIsEqual() throws Exception {
        Volume volumes = new Volume();
        List<Unit> volumeList = volumes.getUnitList();

        Unit volume = volumes.GetUnitByShortcut("ig");
        Unit volumeFromList = volumeList.get(8);

        assertEquals(volume, volumeFromList);
    }

    @Test
    public void createVolumeCategory_standardConstructor_ImperialGallonUnitHasRightName() throws Exception {
        Volume volumes = new Volume();

        Unit unit = volumes.GetUnitByShortcut("ig");
        String name = unit.getName();

        assertEquals("Imperial gallon", name);
    }

    @Test
    public void createVolumeCategory_standardConstructor_ImperialGallonUnitHasRightFactor() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("ig");
        double factor = unit.getFactor();

        assertEquals(4.54609, factor, 0.00001);
    }





    @Test
    public void createVolumeCategory_standardConstructor_ReturnsImperialQuartUnit() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("iq");

        assertNotEquals(null, unit);
    }

    @Test
    public void createVolumeCategory_standardConstructor_RefImperialQuartUnitByShortcutAndRefByVolumeUnitListIsEqual() throws Exception {
        Volume volumes = new Volume();
        List<Unit> volumeList = volumes.getUnitList();

        Unit volume = volumes.GetUnitByShortcut("iq");
        Unit volumeFromList = volumeList.get(9);

        assertEquals(volume, volumeFromList);
    }

    @Test
    public void createVolumeCategory_standardConstructor_ImperialQuartUnitHasRightName() throws Exception {
        Volume volumes = new Volume();

        Unit unit = volumes.GetUnitByShortcut("iq");
        String name = unit.getName();

        assertEquals("Imperial quart", name);
    }

    @Test
    public void createVolumeCategory_standardConstructor_ImperialQuartUnitHasRightFactor() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("iq");
        double factor = unit.getFactor();

        assertEquals(1.13652, factor, 0.0001);
    }





    @Test
    public void createVolumeCategory_standardConstructor_ReturnsImperialPintUnit() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("ip");

        assertNotEquals(null, unit);
    }

    @Test
    public void createVolumeCategory_standardConstructor_RefImperialPintUnitByShortcutAndRefByVolumeUnitListIsEqual() throws Exception {
        Volume volumes = new Volume();
        List<Unit> volumeList = volumes.getUnitList();

        Unit volume = volumes.GetUnitByShortcut("ip");
        Unit volumeFromList = volumeList.get(10);

        assertEquals(volume, volumeFromList);
    }

    @Test
    public void createVolumeCategory_standardConstructor_ImperialPintUnitHasRightName() throws Exception {
        Volume volumes = new Volume();

        Unit unit = volumes.GetUnitByShortcut("ip");
        String name = unit.getName();

        assertEquals("Imperial pint", name);
    }

    @Test
    public void createVolumeCategory_standardConstructor_ImperialPintUnitHasRightFactor() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("ip");
        double factor = unit.getFactor();

        assertEquals(0.568261, factor, 0.0001);
    }




    @Test
    public void createVolumeCategory_standardConstructor_ReturnsImperialCupUnit() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("ic");

        assertNotEquals(null, unit);
    }

    @Test
    public void createVolumeCategory_standardConstructor_RefImperialCupUnitByShortcutAndRefByVolumeUnitListIsEqual() throws Exception {
        Volume volumes = new Volume();
        List<Unit> volumeList = volumes.getUnitList();

        Unit volume = volumes.GetUnitByShortcut("ic");
        Unit volumeFromList = volumeList.get(11);

        assertEquals(volume, volumeFromList);
    }

    @Test
    public void createVolumeCategory_standardConstructor_ImperialCupUnitHasRightName() throws Exception {
        Volume volumes = new Volume();

        Unit unit = volumes.GetUnitByShortcut("ic");
        String name = unit.getName();

        assertEquals("Imperial cup", name);
    }

    @Test
    public void createVolumeCategory_standardConstructor_ImperialCupUnitHasRightFactor() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("ic");
        double factor = unit.getFactor();

        assertEquals(0.284131, factor, 0.0001);
    }



    @Test
    public void createVolumeCategory_standardConstructor_ReturnsImperialFluidOunceUnit() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("ifo");

        assertNotEquals(null, unit);
    }

    @Test
    public void createVolumeCategory_standardConstructor_RefImperialFluidOunceUnitByShortcutAndRefByVolumeUnitListIsEqual() throws Exception {
        Volume volumes = new Volume();
        List<Unit> volumeList = volumes.getUnitList();

        Unit volume = volumes.GetUnitByShortcut("ifo");
        Unit volumeFromList = volumeList.get(12);

        assertEquals(volume, volumeFromList);
    }

    @Test
    public void createVolumeCategory_standardConstructor_ImperialFluidOunceUnitHasRightName() throws Exception {
        Volume volumes = new Volume();

        Unit unit = volumes.GetUnitByShortcut("ifo");
        String name = unit.getName();

        assertEquals("Imperial fluid ounce", name);
    }

    @Test
    public void createVolumeCategory_standardConstructor_ImperialFluidOunceUnitHasRightFactor() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("ifo");
        double factor = unit.getFactor();

        assertEquals(0.0284131, factor, 0.00001);
    }



    @Test
    public void createVolumeCategory_standardConstructor_ReturnsImperialTablespoonUnit() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("itap");

        assertNotEquals(null, unit);
    }

    @Test
    public void createVolumeCategory_standardConstructor_RefImperialTablespoonUnitByShortcutAndRefByVolumeUnitListIsEqual() throws Exception {
        Volume volumes = new Volume();
        List<Unit> volumeList = volumes.getUnitList();

        Unit volume = volumes.GetUnitByShortcut("itap");
        Unit volumeFromList = volumeList.get(13);

        assertEquals(volume, volumeFromList);
    }

    @Test
    public void createVolumeCategory_standardConstructor_ImperialTablespoonUnitHasRightName() throws Exception {
        Volume volumes = new Volume();

        Unit unit = volumes.GetUnitByShortcut("itap");
        String name = unit.getName();

        assertEquals("Imperial tablespoon", name);
    }

    @Test
    public void createVolumeCategory_standardConstructor_ImperialTablespoonUnitHasRightFactor() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("itap");
        double factor = unit.getFactor();

        assertEquals(0.0177582, factor, 0.00001);
    }




    @Test
    public void createVolumeCategory_standardConstructor_ReturnsImperialTeaspoonUnit() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("its");

        assertNotEquals(null, unit);
    }

    @Test
    public void createVolumeCategory_standardConstructor_RefImperialTeaspoonUnitByShortcutAndRefByVolumeUnitListIsEqual() throws Exception {
        Volume volumes = new Volume();
        List<Unit> volumeList = volumes.getUnitList();

        Unit volume = volumes.GetUnitByShortcut("its");
        Unit volumeFromList = volumeList.get(14);

        assertEquals(volume, volumeFromList);
    }

    @Test
    public void createVolumeCategory_standardConstructor_ImperialTeaspoonUnitHasRightName() throws Exception {
        Volume volumes = new Volume();

        Unit unit = volumes.GetUnitByShortcut("its");
        String name = unit.getName();

        assertEquals("Imperial teaspoon", name);
    }

    @Test
    public void createVolumeCategory_standardConstructor_ImperialTeaspoonUnitHasRightFactor() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("its");
        double factor = unit.getFactor();

        assertEquals(0.00591939, factor, 0.0000001);
    }




    @Test
    public void createVolumeCategory_standardConstructor_ReturnsCubicMetreUnit() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("m³");

        assertNotEquals(null, unit);
    }

    @Test
    public void createVolumeCategory_standardConstructor_RefCubicMetreUnitByShortcutAndRefByVolumeUnitListIsEqual() throws Exception {
        Volume volumes = new Volume();
        List<Unit> volumeList = volumes.getUnitList();

        Unit volume = volumes.GetUnitByShortcut("m³");
        Unit volumeFromList = volumeList.get(15);

        assertEquals(volume, volumeFromList);
    }

    @Test
    public void createVolumeCategory_standardConstructor_CubicMetreUnitHasRightName() throws Exception {
        Volume volumes = new Volume();

        Unit unit = volumes.GetUnitByShortcut("m³");
        String name = unit.getName();

        assertEquals("Cubic metre", name);
    }

    @Test
    public void createVolumeCategory_standardConstructor_CubicMetreUnitHasRightFactor() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("m³");
        double factor = unit.getFactor();

        assertEquals(1000, factor, 0.1);
    }




    @Test
    public void createVolumeCategory_standardConstructor_ReturnsCubicFootUnit() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("ft³");

        assertNotEquals(null, unit);
    }

    @Test
    public void createVolumeCategory_standardConstructor_RefCubicFootUnitByShortcutAndRefByVolumeUnitListIsEqual() throws Exception {
        Volume volumes = new Volume();
        List<Unit> volumeList = volumes.getUnitList();

        Unit volume = volumes.GetUnitByShortcut("ft³");
        Unit volumeFromList = volumeList.get(16);

        assertEquals(volume, volumeFromList);
    }

    @Test
    public void createVolumeCategory_standardConstructor_CubicFootUnitHasRightName() throws Exception {
        Volume volumes = new Volume();

        Unit unit = volumes.GetUnitByShortcut("ft³");
        String name = unit.getName();

        assertEquals("Cubic foot", name);
    }

    @Test
    public void createVolumeCategory_standardConstructor_CubicFootUnitHasRightFactor() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("ft³");
        double factor = unit.getFactor();

        assertEquals(28.3168, factor, 0.0001);
    }




    @Test
    public void createVolumeCategory_standardConstructor_ReturnsCubicInchUnit() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("in³");

        assertNotEquals(null, unit);
    }

    @Test
    public void createVolumeCategory_standardConstructor_RefCubicInchUnitByShortcutAndRefByVolumeUnitListIsEqual() throws Exception {
        Volume volumes = new Volume();
        List<Unit> volumeList = volumes.getUnitList();

        Unit volume = volumes.GetUnitByShortcut("in³");
        Unit volumeFromList = volumeList.get(17);

        assertEquals(volume, volumeFromList);
    }

    @Test
    public void createVolumeCategory_standardConstructor_CubicInchUnitHasRightName() throws Exception {
        Volume volumes = new Volume();

        Unit unit = volumes.GetUnitByShortcut("in³");
        String name = unit.getName();

        assertEquals("Cubic inch", name);
    }

    @Test
    public void createVolumeCategory_standardConstructor_CubicInchUnitHasRightFactor() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("in³");
        double factor = unit.getFactor();

        assertEquals(0.0163871, factor, 0.000001);
    }
}