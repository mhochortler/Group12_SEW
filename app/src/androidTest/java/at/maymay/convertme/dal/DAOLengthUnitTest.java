package at.maymay.convertme.dal;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import at.maymay.convertme.application.core.model.Length;
import at.maymay.convertme.application.core.model.Unit;
import at.maymay.convertme.application.dal.dao.DAOLength;

import static org.junit.Assert.assertEquals;

public class DAOLengthUnitTest {
    /**
     * Naming-Convention: UnitOfWork_StateUnderTest_ExpectedBehavior
     * Method-Construction: AAA -> Arrange-Act-Assert
     */

    DAOLength dao;

    @Before
    public void init() {
        dao = new DAOLength();
    }

    @Test
    public void createLengthCategory_daoLengthLoadMethod_ReturnsNonEmptyListOfUnits() throws Exception {
        Length lengths = dao.load();

        List<Unit> lengthList = lengths.getUnitList();
        boolean isEmpty = lengthList.isEmpty();

        assertEquals(false, isEmpty);
    }

    @Test
    public void createLengthCategory_daoLengthLoadMethod_ReturnsListOfUnitsWithCorrectSize() throws Exception {
        Length lengths = dao.load();

        List<Unit> lengthList = lengths.getUnitList();
        int size = lengthList.size();

        assertEquals(9, size);
    }

    @Test
    public void createLengthCategory_daoLengthLoadMethod_ReturnsListOfUnitsWithCorrectShortcuts() throws Exception {
        Length lengths = dao.load();
        String[] expectedShortcuts = new String[]{"mm", "cm", "m", "km", "in", "ft", "yd", "mile", "nmi"};

        List<Unit> lengthList = lengths.getUnitList();

        for (int i = 0; i < expectedShortcuts.length; i++)
            assertEquals(expectedShortcuts[i], lengthList.get(i).getShortcut());
    }

    @Test
    public void createLengthCategory_daoLengthLoadMethod_ReturnsListOfUnitsWithCorrectNames() throws Exception {
        Length lengths = dao.load();
        String[] expectedNames = new String[]{"Millimeter", "Centimeter", "Meter", "Kilometer", "Inch", "Foot", "Yard", "Mile", "Nautical Mile"};

        List<Unit> lengthList = lengths.getUnitList();

        for (int i = 0; i < expectedNames.length; i++)
            assertEquals(expectedNames[i], lengthList.get(i).getName());
    }

    @Test
    public void createLengthCategory_daoLengthLoadMethod_ReturnsListOfUnitsWithCorrectFactors() throws Exception {
        Length lengths = dao.load();
        double[] expectedFactors = new double[]{0.001, 0.01, 1.0, 1000.0, 0.0254, 0.3048, 0.9144, 1609.34, 1852.0};

        List<Unit> lengthList = lengths.getUnitList();

        for (int i = 0; i < expectedFactors.length; i++)
            assertEquals(expectedFactors[i], lengthList.get(i).getFactor(), 0.0001);
    }
}
