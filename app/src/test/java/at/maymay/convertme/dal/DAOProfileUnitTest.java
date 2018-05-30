package at.maymay.convertme.dal;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import at.maymay.convertme.Mocks.CategoryContainerMock;
import at.maymay.convertme.application.core.ICategoryContainer;
import at.maymay.convertme.application.dal.dao.DAOProfile;

import static org.junit.Assert.assertEquals;

public class DAOProfileUnitTest {
    /**
     Naming-Convention: UnitOfWork_StateUnderTest_ExpectedBehavior
     Method-Construction: AAA -> Arrange-Act-Assert
     */

    DAOProfile dao_;
    ICategoryContainer categoryContainerContainer_;



    @Before
    public void init()
    {
        dao_ = new DAOProfile();
        categoryContainerContainer_ = new CategoryContainerMock();
    }




    @Test(expected = NullPointerException.class)
    public void loadAllProfiles_givenCategoryContainerIsNull_throwsNullPointerException() throws Exception {
        dao_.loadAll(null);
    }
}
