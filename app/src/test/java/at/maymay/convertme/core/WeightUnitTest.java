package at.maymay.convertme.core;

import org.junit.Test;

import java.util.List;

import at.maymay.convertme.application.core.model.Unit;
import at.maymay.convertme.application.core.model.Weight;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class WeightUnitTest {
    /**
     Naming-Convention: UnitOfWork_StateUnderTest_ExpectedBehavior
     Methode-Construction: AAA -> Arrange-Act-Assert
     */

    @Test
    public void createWeightCategory_standardConstructor_ReturnsNonEmptyListOfUnits() throws Exception {
        Weight weights = new Weight();

        List<Unit> weightList = weights.getUnitList();
        boolean isEmpty = weightList.isEmpty();

        assertEquals(false, isEmpty);
    }

    @Test
    public void createWeightCategory_standardConstructor_ReturnsListOfUnitsWithCorrectSize() throws Exception {
        Weight weights = new Weight();

        List<Unit> weightList = weights.getUnitList();
        int size = weightList.size();

        assertEquals(7, size);
    }

    @Test
    public void createWeightCategory_standardConstructor_ReturnsListOfUnitsWithCorrectShortcuts() throws Exception {
        Weight weights = new Weight();
        String[] expectedShortcuts = new String[] {"kg", "dag", "oz", "lb", "st", "ust", "it" };

        List<Unit> weightList = weights.getUnitList();

        for(int i=0; i<expectedShortcuts.length; i++)
            assertEquals(expectedShortcuts[i], weightList.get(i).getShortcut());
    }

    @Test
    public void createWeightCategory_standardConstructor_ReturnsStringifytUnitList() throws Exception {
        Weight weights = new Weight();
        String[] expectedList = new String[] {"kg", "dag", "oz", "lb", "st", "ust", "it" };

        String[] stringifytList = weights.getStringifytUnitList();

        for(int i=0; i<expectedList.length; i++)
            assertEquals(expectedList[i], stringifytList[i]);
    }




    @Test
    public void createWeightCategory_standardConstructor_ReturnsKilogramUnit() throws Exception {
        Weight weights = new Weight();

        Unit kg = weights.GetUnitByShortcut("kg");

        assertNotEquals(null, kg);
    }

    @Test
    public void createWeightCategory_standardConstructor_RefKilogramUnitByShortcutAndRefByWeightUnitListIsEqual() throws Exception {
        Weight weights = new Weight();
        List<Unit> weightList = weights.getUnitList();

        Unit kg = weights.GetUnitByShortcut("kg");
        Unit kgFromList = weightList.get(0);

        assertEquals(kgFromList, kg);
    }

    @Test
    public void createWeightCategory_standardConstructor_KilogramUnitHasRightName() throws Exception {
        Weight weights = new Weight();

        Unit kg = weights.GetUnitByShortcut("kg");
        String name = kg.getName();

        assertEquals("Kilogram", name);
    }

    @Test
    public void createWeightCategory_standardConstructor_KilogramUnitHasRightFactor() throws Exception {
        Weight weights = new Weight();

        Unit kg = weights.GetUnitByShortcut("kg");
        double factor = kg.getFactor();

        assertEquals(1000.0, factor, 0.001);
    }




    @Test
    public void createWeightCategory_standardConstructor_ReturnsDecagramUnit() throws Exception {
        Weight weights = new Weight();

        Unit dag = weights.GetUnitByShortcut("dag");

        assertNotEquals(null, dag);
    }

    @Test
    public void createWeightCategory_standardConstructor_RefDecagramUnitByShortcutAndRefByWeightUnitListIsEqual() throws Exception {
        Weight weights = new Weight();
        List<Unit> weightList = weights.getUnitList();

        Unit weight = weights.GetUnitByShortcut("dag");
        Unit weightFromList = weightList.get(1);

        assertEquals(weight, weightFromList);
    }

    @Test
    public void createWeightCategory_standardConstructor_DecagramUnitHasRightName() throws Exception {
        Weight weights = new Weight();

        Unit dag =weights.GetUnitByShortcut("dag");
        String name = dag.getName();

        assertEquals("Decagram", name);
    }

    @Test
    public void createWeightCategory_standardConstructor_DecagramUnitHasRightFactor() throws Exception {
        Weight weights = new Weight();

        Unit dag = weights.GetUnitByShortcut("dag");
        double factor = dag.getFactor();

        assertEquals(10.0, factor, 0.001);
    }




    @Test
    public void createWeightCategory_standardConstructor_ReturnsOunceUnit() throws Exception {
        Weight weights = new Weight();

        Unit oz = weights.GetUnitByShortcut("oz");

        assertNotEquals(null, oz);
    }

    @Test
    public void createWeightCategory_standardConstructor_RefOunceUnitByShortcutAndRefByWeightUnitListIsEqual() throws Exception {
        Weight weights = new Weight();
        List<Unit> weightList = weights.getUnitList();

        Unit weight = weights.GetUnitByShortcut("oz");
        Unit weightFromList = weightList.get(2);

        assertEquals(weight, weightFromList);
    }

    @Test
    public void createWeightCategory_standardConstructor_OunceUnitHasRightName() throws Exception {
        Weight weights = new Weight();

        Unit oz = weights.GetUnitByShortcut("oz");
        String name = oz.getName();

        assertEquals("Ounce", name);
    }

    @Test
    public void createWeightCategory_standardConstructor_OunceUnitHasRightFactor() throws Exception {
        Weight weights = new Weight();

        Unit oz = weights.GetUnitByShortcut("oz");
        double factor = oz.getFactor();

        assertEquals(28.349, factor, 0.001);
    }




    @Test
    public void createWeightCategory_standardConstructor_ReturnsPoundUnit() throws Exception {
        Weight weights = new Weight();

        Unit lb =weights.GetUnitByShortcut("lb");

        assertNotEquals(null, lb);
    }

    @Test
    public void createWeightCategory_standardConstructor_RefPoundUnitByShortcutAndRefByWeightUnitListIsEqual() throws Exception {
        Weight weights = new Weight();
        List<Unit> weightList = weights.getUnitList();

        Unit weight = weights.GetUnitByShortcut("lb");
        Unit weightFromList = weightList.get(3);

        assertEquals(weight, weightFromList);
    }

    @Test
    public void createWeightCategory_standardConstructor_PoundUnitHasRightName() throws Exception {
        Weight weights = new Weight();

        Unit lb = weights.GetUnitByShortcut("lb");
        String name = lb.getName();

        assertEquals("Pound", name);
    }

    @Test
    public void createWeightCategory_standardConstructor_PoundUnitHasRightFactor() throws Exception {
        Weight weights = new Weight();

        Unit lb = weights.GetUnitByShortcut("lb");
        double factor = lb.getFactor();

        assertEquals(453.592, factor, 0.001);
    }





    @Test
    public void createWeightCategory_standardConstructor_ReturnsStoneUnit() throws Exception {
        Weight weights = new Weight();

        Unit st = weights.GetUnitByShortcut("st");

        assertNotEquals(null, st);
    }

    @Test
    public void createWeightCategory_standardConstructor_RefStoneUnitByShortcutAndRefByWeightUnitListIsEqual() throws Exception {
        Weight weights = new Weight();
        List<Unit> weightList = weights.getUnitList();

        Unit weight = weights.GetUnitByShortcut("st");
        Unit weightFromList = weightList.get(4);

        assertEquals(weight, weightFromList);
    }

    @Test
    public void createWeightCategory_standardConstructor_StoneUnitHasRightName() throws Exception {
        Weight weights = new Weight();

        Unit st = weights.GetUnitByShortcut("st");
        String name = st.getName();

        assertEquals("Stone", name);
    }

    @Test
    public void createWeightCategory_standardConstructor_StoneUnitHasRightFactor() throws Exception {
        Weight weights = new Weight();

        Unit st = weights.GetUnitByShortcut("st");
        double factor = st.getFactor();

        assertEquals(6350.29, factor, 0.001);
    }





    @Test
    public void createWeightCategory_standardConstructor_ReturnsUSTonUnit() throws Exception {
        Weight weights = new Weight();

        Unit ust = weights.GetUnitByShortcut("ust");

        assertNotEquals(null, ust);
    }

    @Test
    public void createWeightCategory_standardConstructor_RefUSTonUnitByShortcutAndRefByWeightUnitListIsEqual() throws Exception {
        Weight weights = new Weight();
        List<Unit> weightList = weights.getUnitList();

        Unit weight = weights.GetUnitByShortcut("ust");
        Unit weightFromList = weightList.get(5);

        assertEquals(weight, weightFromList);
    }

    @Test
    public void createWeightCategory_standardConstructor_USTonUnitHasRightName() throws Exception {
        Weight weights = new Weight();

        Unit ust = weights.GetUnitByShortcut("ust");
        String name = ust.getName();

        assertEquals("US Ton", name);
    }

    @Test
    public void createWeightCategory_standardConstructor_USTonUnitHasRightFactor() throws Exception {
        Weight weights = new Weight();

        Unit ust = weights.GetUnitByShortcut("ust");
        double factor = ust.getFactor();

        assertEquals(907184.28568, factor, 0.0001);
    }



    @Test
    public void createWeightCategory_standardConstructor_ReturnsImperialTonUnit() throws Exception {
        Weight weights = new Weight();

        Unit it = weights.GetUnitByShortcut("it");

        assertNotEquals(null, it);
    }

    @Test
    public void createWeightCategory_standardConstructor_RefImperialTonUnitByShortcutAndRefByWeightUnitListIsEqual() throws Exception {
        Weight weights = new Weight();
        List<Unit> weightList = weights.getUnitList();

        Unit weight = weights.GetUnitByShortcut("it");
        Unit weightFromList = weightList.get(6);

        assertEquals(weight, weightFromList);
    }

    @Test
    public void createWeightCategory_standardConstructor_ImperialTonUnitHasRightName() throws Exception {
        Weight weights = new Weight();

        Unit it = weights.GetUnitByShortcut("it");
        String name = it.getName();

        assertEquals("Imperial Ton", name);
    }

    @Test
    public void createWeightCategory_standardConstructor_ImperialTonUnitHasRightFactor() throws Exception {
        Weight weights = new Weight();

        Unit it = weights.GetUnitByShortcut("it");
        double factor = it.getFactor();

        assertEquals(1016050, factor, 0.0001);
    }
}