package at.maymay.convertme.core;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import at.maymay.convertme.application.core.Volume;
import at.maymay.convertme.application.core.Unit;

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
    private List<Unit> volumeList_;

    @Before
    public void setup() throws Exception
    {
        Volume volumes = new Volume();
        volumeList_ = volumes.getUnitList();
    }



    @Test
    public void createVolumeCategory_standardConstructor_ReturnsNonEmptyListOfUnits() throws Exception {
        Volume volumes = new Volume();

        volumeList_ = volumes.getUnitList();
        boolean isEmpty = volumeList_.isEmpty();

        assertEquals(false, isEmpty);
    }

    @Test
    public void createVolumeCategory_standardConstructor_ReturnsListOfUnitsWithCorrectSize() throws Exception {
        Volume volumes = new Volume();

        volumeList_ = volumes.getUnitList();
        int size = volumeList_.size();

        assertEquals(18, size);
    }




    @Test
    public void createVolumeCategory_standardConstructor_ReturnsLitreUnit() throws Exception {
        Volume volumes = new Volume();

        Unit unit = volumes.GetUnitByShortcut("l");

        assertNotEquals(null, unit);
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

        Unit unit =  volumes.GetUnitByShortcut("USlg");

        assertNotEquals(null, unit);
    }

    @Test
    public void createVolumeCategory_standardConstructor_USLiquidGallonUnitHasRightName() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("USlg");
        String name = unit.getName();

        assertEquals("US liquid gallon", name);
    }

    @Test
    public void createVolumeCategory_standardConstructor_USLiquidGallonUnitHasRightFactor() throws Exception {
        Volume volumes = new Volume();

        Unit unit =  volumes.GetUnitByShortcut("USlg");
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
}