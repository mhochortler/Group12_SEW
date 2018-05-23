package at.maymay.convertme;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import at.maymay.convertme.application.core.Category;
import at.maymay.convertme.application.core.Converter;
import at.maymay.convertme.application.core.CurrencyExchangeAPI;
import at.maymay.convertme.application.core.Length;
import at.maymay.convertme.application.core.Unit;
import at.maymay.convertme.application.core.Weight;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ConverterUnitTest {
    /**
     Naming-Convention: UnitOfWork_StateUnderTest_ExpectedBehavior
     Methode-Construction: AAA -> Arrange-Act-Assert
     */

    @Test
    public void convertWeightUnits_twoUnitsOfSameType_ReturnsImputValue() throws Exception {
        Weight weights = new Weight();
        Unit unit1 = new Unit("Kilogram", "kg");
        Unit unit2 = new Unit("Kilogram", "kg");
        double value = 1.5;

        double retValue = weights.convert(unit1, unit2, value);
        assertEquals(retValue, value, 0.0001);
    }
}