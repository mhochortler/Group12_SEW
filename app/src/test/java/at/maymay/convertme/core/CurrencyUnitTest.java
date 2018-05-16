package at.maymay.convertme.core;

import org.junit.Test;

import java.util.List;

import at.maymay.convertme.application.core.Currency;
import at.maymay.convertme.application.core.Unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CurrencyUnitTest {
    /**
     Naming-Convention: UnitOfWork_StateUnderTest_ExpectedBehavior
     Methode-Construction: AAA -> Arrange-Act-Assert
     */

    @Test
    public void createCurrencyCategory_standardConstructor_ReturnsNonEmptyListOfUnits() throws Exception {
        Currency currencies = new Currency();

        List<Unit> currencyList = currencies.getUnitList();
        boolean isEmpty = currencyList.isEmpty();

        assertEquals(false, isEmpty);
    }

    @Test
    public void createCurrencyCategory_standardConstructor_ReturnsListOfUnitsWithCorrectSize() throws Exception {
        Currency currencies = new Currency();

        List<Unit> currencyList = currencies.getUnitList();
        int size = currencyList.size();

        assertEquals(5, size);
    }

    @Test
    public void createCurrencyCategory_standardConstructor_ReturnsListOfUnitsWithCorrectShortcuts() throws Exception {
        Currency currencies = new Currency();
        String[] expectedShortcuts = new String[] {"USD", "EUR", "JPY", "GBP", "CHF"};

        List<Unit> currencyList = currencies.getUnitList();

        for(int i=0; i<expectedShortcuts.length; i++)
            assertEquals(expectedShortcuts[i], currencyList.get(i).getShortcut());
    }

    @Test
    public void createCurrencyCategory_standardConstructor_ReturnsStringifytUnitList() throws Exception {
        Currency currencies = new Currency();
        String[] expectedList = new String[] {"USD", "EUR", "JPY", "GBP", "CHF"};

        String[] stringifytList = currencies.getStringifytUnitList();

        for(int i=0; i<expectedList.length; i++)
            assertEquals(expectedList[i], stringifytList[i]);
    }





    @Test
    public void createCurrencyCategory_standardConstructor_ReturnsUSDollarUnit() throws Exception {
        Currency currencies = new Currency();

        Unit unit =  currencies.GetUnitByShortcut("USD");

        assertNotEquals(null, unit);
    }

    @Test
    public void createCurrencyCategory_standardConstructor_RefUSDollarUnitByShortcutAndRefByCurrencyUnitListIsEqual() throws Exception {
        Currency currencies = new Currency();
        List<Unit> currencyList = currencies.getUnitList();

        Unit currency = currencies.GetUnitByShortcut("USD");
        Unit currencyFromList = currencyList.get(0);

        assertEquals(currency, currencyFromList);
    }

    @Test
    public void createCurrencyCategory_standardConstructor_USDollarUnitHasRightName() throws Exception {
        Currency currencies = new Currency();

        Unit unit = currencies.GetUnitByShortcut("USD");
        String name = unit.getName();

        assertEquals("U.S. Dollar", name);
    }

    @Test
    public void createCurrencyTemperatureCategory_standardConstructor_USDollarUnitHasRightFactor() throws Exception {
        Currency currencies = new Currency();

        //TODO, Implement Interface for dummy
        Unit unit =  currencies.GetUnitByShortcut("USD");
        double factor = unit.getFactor();

        assertEquals(-1, factor, 0.1);
    }



    @Test
    public void createCurrencyCategory_standardConstructor_ReturnsEuroUnit() throws Exception {
        Currency currencies = new Currency();

        Unit unit =  currencies.GetUnitByShortcut("EUR");

        assertNotEquals(null, unit);
    }

    @Test
    public void createCurrencyCategory_standardConstructor_RefEuroUnitByShortcutAndRefByCurrencyUnitListIsEqual() throws Exception {
        Currency currencies = new Currency();
        List<Unit> currencyList = currencies.getUnitList();

        Unit currency = currencies.GetUnitByShortcut("EUR");
        Unit currencyFromList = currencyList.get(1);

        assertEquals(currency, currencyFromList);
    }

    @Test
    public void createCurrencyCategory_standardConstructor_EuroUnitHasRightName() throws Exception {
        Currency currencies = new Currency();

        Unit unit = currencies.GetUnitByShortcut("EUR");
        String name = unit.getName();

        assertEquals("Euro", name);
    }

    @Test
    public void createCurrencyTemperatureCategory_standardConstructor_EuroUnitHasRightFactor() throws Exception {
        Currency currencies = new Currency();

        //TODO, Implement Interface for dummy
        Unit unit =  currencies.GetUnitByShortcut("EUR");
        double factor = unit.getFactor();

        assertEquals(-1, factor, 0.1);
    }




    @Test
    public void createCurrencyCategory_standardConstructor_ReturnsYenUnit() throws Exception {
        Currency currencies = new Currency();

        Unit unit =  currencies.GetUnitByShortcut("JPY");

        assertNotEquals(null, unit);
    }

    public void createCurrencyCategory_standardConstructor_RefYenUnitByShortcutAndRefByCurrencyUnitListIsEqual() throws Exception {
        Currency currencies = new Currency();
        List<Unit> currencyList = currencies.getUnitList();

        Unit currency = currencies.GetUnitByShortcut("JPY");
        Unit currencyFromList = currencyList.get(2);

        assertEquals(currency, currencyFromList);
    }

    @Test
    public void createCurrencyCategory_standardConstructor_YenUnitHasRightName() throws Exception {
        Currency currencies = new Currency();

        Unit unit = currencies.GetUnitByShortcut("JPY");
        String name = unit.getName();

        assertEquals("Yen", name);
    }

    @Test
    public void createCurrencyTemperatureCategory_standardConstructor_YenUnitHasRightFactor() throws Exception {
        Currency currencies = new Currency();

        //TODO, Implement Interface for dummy
        Unit unit =  currencies.GetUnitByShortcut("JPY");
        double factor = unit.getFactor();

        assertEquals(-1, factor, 0.1);
    }




    @Test
    public void createCurrencyCategory_standardConstructor_ReturnsBritishPoundUnit() throws Exception {
        Currency currencies = new Currency();

        Unit unit =  currencies.GetUnitByShortcut("GBP");

        assertNotEquals(null, unit);
    }

    public void createCurrencyCategory_standardConstructor_RefBritishPoundUnitByShortcutAndRefByCurrencyUnitListIsEqual() throws Exception {
        Currency currencies = new Currency();
        List<Unit> currencyList = currencies.getUnitList();

        Unit currency = currencies.GetUnitByShortcut("GBP");
        Unit currencyFromList = currencyList.get(3);

        assertEquals(currency, currencyFromList);
    }

    @Test
    public void createCurrencyCategory_standardConstructor_BritishPoundUnitHasRightName() throws Exception {
        Currency currencies = new Currency();

        Unit unit = currencies.GetUnitByShortcut("GBP");
        String name = unit.getName();

        assertEquals("British Pound", name);
    }

    @Test
    public void createCurrencyTemperatureCategory_standardConstructor_BritishPoundUnitHasRightFactor() throws Exception {
        Currency currencies = new Currency();

        //TODO, Implement Interface for dummy
        Unit unit =  currencies.GetUnitByShortcut("GBP");
        double factor = unit.getFactor();

        assertEquals(-1, factor, 0.1);
    }




    @Test
    public void createCurrencyCategory_standardConstructor_ReturnsSwissFrancUnit() throws Exception {
        Currency currencies = new Currency();

        Unit unit =  currencies.GetUnitByShortcut("CHF");

        assertNotEquals(null, unit);
    }

    public void createCurrencyCategory_standardConstructor_RefSwissFrancUnitByShortcutAndRefByCurrencyUnitListIsEqual() throws Exception {
        Currency currencies = new Currency();
        List<Unit> currencyList = currencies.getUnitList();

        Unit currency = currencies.GetUnitByShortcut("CHF");
        Unit currencyFromList = currencyList.get(4);

        assertEquals(currency, currencyFromList);
    }

    @Test
    public void createCurrencyCategory_standardConstructor_SwissFrancUnitHasRightName() throws Exception {
        Currency currencies = new Currency();

        Unit unit = currencies.GetUnitByShortcut("CHF");
        String name = unit.getName();

        assertEquals("Swiss Franc", name);
    }

    @Test
    public void createCurrencyTemperatureCategory_standardConstructor_SwissFrancUnitHasRightFactor() throws Exception {
        Currency currencies = new Currency();

        //TODO, Implement Interface for dummy
        Unit unit =  currencies.GetUnitByShortcut("CHF");
        double factor = unit.getFactor();

        assertEquals(-1, factor, 0.1);
    }
}