package at.maymay.convertme.core;

import org.junit.Test;

import at.maymay.convertme.application.core.model.Unit;

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
    public void createUnit_WithShortcutAndNameAndFactor_ReturnsUnitWithRightFactor() throws Exception {
        Unit unit = new Unit("Unit", "u", 12.3456);

        double factor = unit.getFactor();

        assertEquals(12.3456, factor, 0.0001);
    }


    @Test
    public void setUnitFactor_ChangeFactorOfTheUnit_ReturnsUnitWithChangedFactor() throws Exception {
        Unit unit = new Unit("Unit", "u", 1.01);

        unit.setFactor(1.2);
        double factor = unit.getFactor();

        assertEquals(1.2, factor, 0.1);
    }
}