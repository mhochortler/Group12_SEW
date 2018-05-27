package at.maymay.convertme.dal;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import at.maymay.convertme.application.core.model.Currency;
import at.maymay.convertme.application.core.model.Unit;
import at.maymay.convertme.application.dal.dao.DAOCurrency;

import static org.junit.Assert.assertEquals;

public class DAOCurrencyUnitTest {
    /**
     Naming-Convention: UnitOfWork_StateUnderTest_ExpectedBehavior
     Method-Construction: AAA -> Arrange-Act-Assert
     */

    DAOCurrency dao;

    @Before
    public void init()
    {
        dao = new DAOCurrency();
    }

    @Test
    public void createCurrencyCategory_daoCurrencyLoadMethod_ReturnsNonEmptyListOfUnits() throws Exception {
        Currency currencies = dao.load();

        List<Unit> currencyList = currencies.getUnitList();
        boolean isEmpty = currencyList.isEmpty();

        assertEquals(false, isEmpty);
    }

    @Test
    public void createCurrencyCategory_daoCurrencyLoadMethod_ReturnsListOfUnitsWithCorrectSize() throws Exception {
        Currency currencies = dao.load();

        List<Unit> currencyList = currencies.getUnitList();
        int size = currencyList.size();

        assertEquals(5, size);
    }

    @Test
    public void createCurrencyCategory_daoCurrencyLoadMethod_ReturnsListOfUnitsWithCorrectShortcuts() throws Exception {
        Currency currencies = dao.load();
        String[] expectedShortcuts = new String[] {"USD", "EUR", "JPY", "GBP", "CHF"};

        List<Unit> currencyList = currencies.getUnitList();

        for(int i=0; i<expectedShortcuts.length; i++)
            assertEquals(expectedShortcuts[i], currencyList.get(i).getShortcut());
    }

    @Test
    public void createCurrencyCategory_daoCurrencyLoadMethod_ReturnsListOfUnitsWithCorrectNames() throws Exception {
        Currency currencies = dao.load();
        String[] expectedNames = new String[] {"U.S. Dollar", "Euro", "Yen", "British Pound", "Swiss Franc"};

        List<Unit> currencyList = currencies.getUnitList();

        for(int i=0; i<expectedNames.length; i++)
            assertEquals(expectedNames[i], currencyList.get(i).getName());
    }
}
