package at.maymay.convertme.core;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import at.maymay.convertme.application.core.Length;
import at.maymay.convertme.application.core.Unit;
import at.maymay.convertme.application.core.Volume;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LengthUnitTest {
    /**
     Naming-Convention: UnitOfWork_StateUnderTest_ExpectedBehavior
     Methode-Construction: AAA -> Arrange-Act-Assert
     */

    @Test
    public void createLengthCategory_standardConstructor_ReturnsNonEmptyListOfUnits() throws Exception {
        Length lengths = new Length();

        List<Unit> lengthList = lengths.getUnitList();
        boolean isEmpty = lengthList.isEmpty();

        assertEquals(false, isEmpty);
    }

    @Test
    public void createLengthCategory_standardConstructor_ReturnsListOfUnitsWithCorrectSize() throws Exception {
        Length lengths = new Length();

        List<Unit> lengthList = lengths.getUnitList();
        int size = lengthList.size();

        assertEquals(6, size);
    }

    @Test
    public void createLengthCategory_standardConstructor_ReturnsListOfUnitsWithCorrectShortcuts() throws Exception {
        Length lengths = new Length();
        String[] expectedShortcuts = new String[] {"m", "ft", "in", "yd", "mile", "nmi"};

        List<Unit> lengthList = lengths.getUnitList();

        for(int i=0; i<expectedShortcuts.length; i++)
            assertEquals(expectedShortcuts[i], lengthList.get(i).getShortcut());
    }

    @Test
    public void createLengthCategory_standardConstructor_ReturnsStringifytUnitList() throws Exception {
        Length lengths = new Length();
        String[] expectedList = new String[] {"m", "ft", "in", "yd", "mile", "nmi"};

        String[] stringifytList = lengths.getStringifytUnitList();

        for(int i=0; i<expectedList.length; i++)
            assertEquals(expectedList[i], stringifytList[i]);
    }





    @Test
    public void createLengthCategory_standardConstructor_ReturnsMeterUnit() throws Exception {
        Length lengths = new Length();

        Unit unit =  lengths.GetUnitByShortcut("m");

        assertNotEquals(null, unit);
    }

    @Test
    public void createLengthCategory_standardConstructor_RefMeterUnitByShortcutAndRefByLengthUnitListIsEqual() throws Exception {
        Length lengths = new Length();
        List<Unit> lengthList = lengths.getUnitList();

        Unit length = lengths.GetUnitByShortcut("m");
        Unit lengthFromList = lengthList.get(0);

        assertEquals(length, lengthFromList);
    }

    @Test
    public void createLengthCategory_standardConstructor_MeterUnitHasRightName() throws Exception {
        Length lengths = new Length();

        Unit unit =  lengths.GetUnitByShortcut("m");
        String name = unit.getName();

        assertEquals("Meter", name);
    }

    @Test
    public void createLengthTemperatureCategory_standardConstructor_MeterUnitHasRightFactor() throws Exception {
        Length lengths = new Length();

        Unit unit =  lengths.GetUnitByShortcut("m");
        double factor = unit.getFactor();

        assertEquals(1, factor, 0.1);
    }




    @Test
    public void createLengthCategory_standardConstructor_ReturnsFootUnit() throws Exception {
        Length lengths = new Length();

        Unit unit =  lengths.GetUnitByShortcut("ft");

        assertNotEquals(null, unit);
    }

    @Test
    public void createLengthCategory_standardConstructor_RefFootUnitByShortcutAndRefByLengthUnitListIsEqual() throws Exception {
        Length lengths = new Length();
        List<Unit> lengthList = lengths.getUnitList();

        Unit length = lengths.GetUnitByShortcut("ft");
        Unit lengthFromList = lengthList.get(1);

        assertEquals(length, lengthFromList);
    }

    @Test
    public void createLengthCategory_standardConstructor_FootUnitHasRightName() throws Exception {
        Length lengths = new Length();

        Unit unit =  lengths.GetUnitByShortcut("ft");
        String name = unit.getName();

        assertEquals("Foot", name);
    }

    @Test
    public void createLengthTemperatureCategory_standardConstructor_FootUnitHasRightFactor() throws Exception {
        Length lengths = new Length();

        Unit unit =  lengths.GetUnitByShortcut("ft");
        double factor = unit.getFactor();

        assertEquals(0.3048, factor, 0.0001);
    }




    @Test
    public void createLengthCategory_standardConstructor_ReturnsInchUnit() throws Exception {
        Length lengths = new Length();

        Unit unit =  lengths.GetUnitByShortcut("in");

        assertNotEquals(null, unit);
    }

    @Test
    public void createLengthCategory_standardConstructor_RefInchUnitByShortcutAndRefByLengthUnitListIsEqual() throws Exception {
        Length lengths = new Length();
        List<Unit> lengthList = lengths.getUnitList();

        Unit length = lengths.GetUnitByShortcut("in");
        Unit lengthFromList = lengthList.get(2);

        assertEquals(length, lengthFromList);
    }

    @Test
    public void createLengthCategory_standardConstructor_InchUnitHasRightName() throws Exception {
        Length lengths = new Length();

        Unit unit =  lengths.GetUnitByShortcut("in");
        String name = unit.getName();

        assertEquals("Inch", name);
    }

    @Test
    public void createLengthTemperatureCategory_standardConstructor_InchUnitHasRightFactor() throws Exception {
        Length lengths = new Length();

        Unit unit =  lengths.GetUnitByShortcut("in");
        double factor = unit.getFactor();

        assertEquals(0.0254, factor, 0.0001);
    }





    @Test
    public void createLengthCategory_standardConstructor_ReturnsYardUnit() throws Exception {
        Length lengths = new Length();

        Unit unit =  lengths.GetUnitByShortcut("yd");

        assertNotEquals(null, unit);
    }

    @Test
    public void createLengthCategory_standardConstructor_RefYardUnitByShortcutAndRefByLengthUnitListIsEqual() throws Exception {
        Length lengths = new Length();
        List<Unit> lengthList = lengths.getUnitList();

        Unit length = lengths.GetUnitByShortcut("yd");
        Unit lengthFromList = lengthList.get(3);

        assertEquals(length, lengthFromList);
    }

    @Test
    public void createLengthCategory_standardConstructor_YardUnitHasRightName() throws Exception {
        Length lengths = new Length();

        Unit unit =  lengths.GetUnitByShortcut("yd");
        String name = unit.getName();

        assertEquals("Yard", name);
    }

    @Test
    public void createLengthTemperatureCategory_standardConstructor_YardUnitHasRightFactor() throws Exception {
        Length lengths = new Length();

        Unit unit =  lengths.GetUnitByShortcut("yd");
        double factor = unit.getFactor();

        assertEquals(0.9144, factor, 0.0001);
    }




    @Test
    public void createLengthCategory_standardConstructor_ReturnsMileUnit() throws Exception {
        Length lengths = new Length();

        Unit unit =  lengths.GetUnitByShortcut("mile");

        assertNotEquals(null, unit);
    }

    @Test
    public void createLengthCategory_standardConstructor_RefMileUnitByShortcutAndRefByLengthUnitListIsEqual() throws Exception {
        Length lengths = new Length();
        List<Unit> lengthList = lengths.getUnitList();

        Unit length = lengths.GetUnitByShortcut("mile");
        Unit lengthFromList = lengthList.get(4);

        assertEquals(length, lengthFromList);
    }

    @Test
    public void createLengthCategory_standardConstructor_MileUnitHasRightName() throws Exception {
        Length lengths = new Length();

        Unit unit =  lengths.GetUnitByShortcut("mile");
        String name = unit.getName();

        assertEquals("Mile", name);
    }

    @Test
    public void createLengthTemperatureCategory_standardConstructor_MileUnitHasRightFactor() throws Exception {
        Length lengths = new Length();

        Unit unit =  lengths.GetUnitByShortcut("mile");
        double factor = unit.getFactor();

        assertEquals(1609.34, factor, 0.01);
    }




    @Test
    public void createLengthCategory_standardConstructor_ReturnsNauticalMileUnit() throws Exception {
        Length lengths = new Length();

        Unit unit =  lengths.GetUnitByShortcut("nmi");

        assertNotEquals(null, unit);
    }

    @Test
    public void createLengthCategory_standardConstructor_RefNauticalMileUnitByShortcutAndRefByLengthUnitListIsEqual() throws Exception {
        Length lengths = new Length();
        List<Unit> lengthList = lengths.getUnitList();

        Unit length = lengths.GetUnitByShortcut("nmi");
        Unit lengthFromList = lengthList.get(5);

        assertEquals(length, lengthFromList);
    }

    @Test
    public void createLengthCategory_standardConstructor_NauticalMileUnitHasRightName() throws Exception {
        Length lengths = new Length();

        Unit unit =  lengths.GetUnitByShortcut("nmi");
        String name = unit.getName();

        assertEquals("Nautical Mile", name);
    }

    @Test
    public void createLengthTemperatureCategory_standardConstructor_NauticalMileUnitHasRightFactor() throws Exception {
        Length lengths = new Length();

        Unit unit =  lengths.GetUnitByShortcut("nmi");
        double factor = unit.getFactor();

        assertEquals(1852, factor, 0.1);
    }




    @Test(expected = IllegalArgumentException.class)
    public void convertLengthUnits_unitFirstArgumentIsCorrupt_ThrowsIllegalArgumentException() throws Exception {
        Length lengths = new Length();
        Unit corruptUnit = new Unit("ErrorName", "ErrorShortcut");
        Unit unit = new Unit("Meter", "m");
        int value = 1;

        lengths.convert(corruptUnit, unit, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertLengthUnits_unitSecondArgumentIsCorrupt_ThrowsIllegalArgumentException() throws Exception {
        Length lengths = new Length();
        Unit corruptUnit = new Unit("ErrorName", "ErrorShortcut");
        Unit unit = new Unit("Meter", "m");
        int value = 1;

        lengths.convert(unit, corruptUnit, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertLengthUnits_unitBothArgumentsAreCorrupt_ThrowsIllegalArgumentException() throws Exception {
        Length lengths = new Length();
        Unit corruptUnit = new Unit("ErrorName", "ErrorShortcut");
        int value = 1;

        lengths.convert(corruptUnit, corruptUnit, value);
    }

    @Test(expected = NullPointerException.class)
    public void convertLengthUnits_unitFirstArgumentIsNull_ThrowsNullPointerException() throws Exception {
        Length lengths = new Length();
        Unit unit = new Unit("Meter", "m");
        int value = 1;

        lengths.convert(null, unit, value);
    }

    @Test(expected = NullPointerException.class)
    public void convertLengthUnits_unitSecondArgumentIsNull_ThrowsNullPointerException() throws Exception {
        Length lengths = new Length();
        Unit unit = new Unit("Meter", "m");
        int value = 1;

        lengths.convert(unit, null, value);
    }

    @Test(expected = NullPointerException.class)
    public void convertLengthUnits_unitBothArgumentsAreNull_ThrowsNullPointerException() throws Exception {
        Length lengths = new Length();
        int value = 1;

        lengths.convert(null, null, value);
    }




    @Test
    public void convertLengthUnits_twoUnitsOfSameType_ReturnsImputValue() throws Exception {
        Length lengths = new Length();
        Unit unit1 = new Unit("Meter", "m");
        Unit unit2 = new Unit("Meter", "m");
        double value = 1.5;

        double retValue = lengths.convert(unit1, unit2, value);
        assertEquals(retValue, value, 0.0001);
    }

    @Test
    public void convertLengthUnits_twoUnitsOfSameTypeWithZeroValue_ReturnsImputValue() throws Exception {
        Length lengths = new Length();
        Unit unit1 = new Unit("Meter", "m");
        Unit unit2 = new Unit("Meter", "m");
        double value = 0;

        double retValue = lengths.convert(unit1, unit2, value);
        assertEquals(retValue, value, 0.0001);
    }

    @Test
    public void convertLengthUnits_baseUnitToNonBaseUnit_ReturnsConvertedValue() throws Exception {
        Length lengths = new Length();
        Unit unit1 = new Unit("Meter", "m");
        Unit unit2 = new Unit("Foot", "ft");
        double value = 1;

        double retValue = lengths.convert(unit1, unit2, value);
        assertEquals(3.2808, retValue, 0.0001);
    }

    @Test
    public void convertLengthUnits_noneBaseUnitToBaseUnit_ReturnsConvertedValue() throws Exception {
        Length lengths = new Length();
        Unit unit1 = new Unit("Foot", "ft");
        Unit unit2 = new Unit("Meter", "m");
        double value = 1;

        double retValue = lengths.convert(unit1, unit2, value);
        assertEquals(0.3048, retValue, 0.0001);
    }

    @Test
    public void convertLengthUnits_noneBaseUnitToNoneBaseUnit_ReturnsConvertedValue() throws Exception {
        Length lengths = new Length();
        Unit unit1 = new Unit("Foot", "ft");
        Unit unit2 = new Unit("Yard", "yd");
        double value = 1;

        double retValue = lengths.convert(unit1, unit2, value);
        assertEquals(0.333333, retValue, 0.0001);
    }
}