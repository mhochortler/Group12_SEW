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

    private List<Unit> unit_List;
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Before
    public void initCategory() {
        Length cat_length = new Length();
        unit_List = cat_length.getUnitList();
    }

    @Test
    public void test_conversion_isCorrect() throws Exception{
        double result = Converter.convert(unit_List.get(0), unit_List.get(1), 10.0);
        assertEquals(32.8083, result, 0.001);
    }

    @Test
    public void test_get_exchange_rate_throwsException() {
        double result = CurrencyExchangeAPI.getExchangeRate("USX", "EUPO");
        assertEquals(0.0, result, 0.0);
    }

    @Test
    public void test_get_exchange_rate_isCorrect() {
        double result = CurrencyExchangeAPI.getExchangeRate("USD", "EUR");
        assertNotEquals(0.0, result, 0.0);
    }


}