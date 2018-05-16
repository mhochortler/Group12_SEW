package at.maymay.convertme.core;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import at.maymay.convertme.application.core.Unit;
import at.maymay.convertme.application.core.Weight;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitUnitTest {
    /**
     Naming-Convention: UnitOfWork_StateUnderTest_ExpectedBehavior
     Methode-Construction: AAA -> Arrange-Act-Assert
     */

    @Test
    public void createUnit_WithShortcutAndName_ReturnsUnitWithFactorZero() throws Exception {
        Unit unit = new Unit("Unit", "u");

        double factor = unit.getFactor();

        assertEquals(0, factor, 0.1);
    }

    @Test
    public void createUnit_WithShortcutAndName_ReturnsUnitWithRightName() throws Exception {
        Unit unit = new Unit("Unit", "u");

        String name = unit.getName();

        assertEquals("Unit", name);
    }

    @Test
    public void createUnit_WithShortcutAndName_ReturnsUnitWithRightShortcut() throws Exception {
        Unit unit = new Unit("Unit", "u");

        String shortcut = unit.getShortcut();

        assertEquals("u", shortcut);
    }




    @Test
    public void createUnit_WithShortcutAndNameAndFactor_ReturnsUnitWithRightFactor() throws Exception {
        Unit unit = new Unit("Unit", "u", 12.3456);

        double factor = unit.getFactor();

        assertEquals(12.3456, factor, 0.0001);
    }

    @Test
    public void createUnit_WithShortcutAndNameAndFactor_ReturnsUnitWithRightName() throws Exception {
        Unit unit = new Unit("Unit", "u");

        String name = unit.getName();

        assertEquals("Unit", name);
    }

    @Test
    public void createUnit_WithShortcutAndNameAndFactor_ReturnsUnitWithRightShortcut() throws Exception {
        Unit unit = new Unit("Unit", "u");

        String shortcut = unit.getShortcut();

        assertEquals("u", shortcut);
    }




    @Test
    public void setUnitName_ChangeNameOfTheUnit_ReturnsUnitWithChangedName() throws Exception {
        Unit unit = new Unit("Unit", "u", 12.3456);

        unit.setName("newName");
        String name = unit.getName();

        assertEquals("newName", name);
    }

    @Test
    public void setUnitShortcut_ChangeShortcutOfTheUnit_ReturnsUnitWithChangedShortcut() throws Exception {
        Unit unit = new Unit("Unit", "u");

        unit.setShortcut("newU");
        String shortcut = unit.getShortcut();

        assertEquals("newU", shortcut);
    }
}