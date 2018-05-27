package at.maymay.convertme.core;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import at.maymay.convertme.application.core.CategoryContainer;
import at.maymay.convertme.application.core.dao.IDAOCurrency;
import at.maymay.convertme.application.core.model.Currency;
import at.maymay.convertme.application.core.model.Length;
import at.maymay.convertme.application.core.model.Speed;
import at.maymay.convertme.application.core.model.Temperature;
import at.maymay.convertme.application.core.model.Unit;
import at.maymay.convertme.application.core.model.Volume;
import at.maymay.convertme.application.core.model.Weight;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CategoryContainerUnitTest {
    /**
     Naming-Convention: UnitOfWork_StateUnderTest_ExpectedBehavior
     Method-Construction: AAA -> Arrange-Act-Assert
     */

    CategoryContainer container_;

    Currency currency_;
    Length length_;
    Speed speed_;
    Temperature temperature_;
    Volume volume_;
    Weight weight_;


    @Before
    public void init()
    {
        currency_ = new Currency();
        length_ = new Length();
        speed_ = new Speed();
        temperature_ = new Temperature();
        volume_ = new Volume();
        weight_ = new Weight();

        container_ = new CategoryContainer(currency_, length_, speed_, temperature_, volume_, weight_);
    }

    @Test
    public void categoryContainerGetterTest_testCurrencyGetter_returnsCurrencyObject() throws Exception {
        assertEquals(currency_, container_.currency());
    }

    @Test
    public void categoryContainerGetterTest_testLengthGetter_returnsLengthObject() throws Exception {
        assertEquals(length_, container_.length());
    }

    @Test
    public void categoryContainerGetterTest_testSpeedGetter_returnsSpeedObject() throws Exception {
        assertEquals(speed_, container_.speed());
    }

    @Test
    public void categoryContainerGetterTest_testTemperatureGetter_returnsTemperatureObject() throws Exception {
        assertEquals(temperature_, container_.temperature());
    }

    @Test
    public void categoryContainerGetterTest_testVolumeGetter_returnsVolumeObject() throws Exception {
        assertEquals(volume_, container_.volume());
    }

    @Test
    public void categoryContainerGetterTest_testWeightGetter_returnsWeightObject() throws Exception {
        assertEquals(weight_, container_.weight());
    }
}