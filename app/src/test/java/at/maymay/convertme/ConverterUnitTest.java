package at.maymay.convertme;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import at.maymay.convertme.application.core.Converter;
import at.maymay.convertme.application.dal.CurrencyExchangeAPI;
import at.maymay.convertme.application.core.model.Length;
import at.maymay.convertme.application.core.model.Unit;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ConverterUnitTest {

    private List<Unit> unit_List;

    @Before
    public void setup() throws Exception
    {
        unit_List = new Length().getUnitList();
    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test_conversion_isCorrect() throws Exception{
        double result = Converter.convert(unit_List.get(0), unit_List.get(1), 10.0);
        assertEquals(32.8083, result, 0.001);
    }

    @Test
    public void test_conversion_temperature_isCorrect() throws Exception{
        Unit k = new Unit("Kelvin", "K", 273.15);
        Unit f = new Unit("Fahrenheit", "F°", 1.8);

        double result = Converter.convert(k, f, 10.0);
        assertEquals(-441.67, result, 0.001);
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