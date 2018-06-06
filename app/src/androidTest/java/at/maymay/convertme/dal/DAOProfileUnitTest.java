package at.maymay.convertme.dal;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import at.maymay.convertme.Mocks.CategoryContainerMock;
import at.maymay.convertme.Mocks.EmptyCategoryContainerMock;
import at.maymay.convertme.application.core.ICategoryContainer;
import at.maymay.convertme.application.core.Profile;
import at.maymay.convertme.application.dal.dao.DAOProfile;

import static org.junit.Assert.assertEquals;

public class DAOProfileUnitTest {
    /**
     Naming-Convention: UnitOfWork_StateUnderTest_ExpectedBehavior
     Method-Construction: AAA -> Arrange-Act-Assert
     */

    DAOProfile dao_;
    ICategoryContainer categoryContainer_;
    ICategoryContainer emptyCategoryContainer_;



    @Before
    public void init()
    {
        dao_ = new DAOProfile();
        categoryContainer_ = new CategoryContainerMock();
        emptyCategoryContainer_ = new EmptyCategoryContainerMock();
    }




    @Test(expected = NullPointerException.class)
    public void loadAllProfiles_givenCategoryContainerIsNull_throwsNullPointerException() throws Exception
    {
        dao_.loadAll(null);
    }

    @Test(expected = NullPointerException.class)
    public void loadAllProfiles_givenCategoryContainerIsEmpty_throwsNullPointerException() throws Exception
    {
        dao_.loadAll(emptyCategoryContainer_);
    }



    @Test
    public void loadAllProfiles_daoProfileLoadMethod_ReturnsNonEmptyListOfUnits() throws Exception {
        List<Profile> profiles = dao_.loadAll(categoryContainer_);

        boolean isEmpty = profiles.isEmpty();

        assertEquals(false, isEmpty);
    }

    @Test
    public void loadAllProfiles_daoProfileLoadMethod_ReturnsListOfUnitsWithCorrectSize() throws Exception {
        List<Profile> profiles = dao_.loadAll(categoryContainer_);

        int size = profiles.size();

        assertEquals(3, size);
    }

    @Test
    public void loadAllProfiles_daoProfileLoadMethod_ReturnsListOfUnits() throws Exception {
        List<Profile> profiles = dao_.loadAll(categoryContainer_);

        assertEquals("Austria", profiles.get(0).getName());
        assertEquals("United States", profiles.get(1).getName());
        assertEquals("England", profiles.get(2).getName());

        assertEquals("AUT", profiles.get(0).getShortcut());
        assertEquals("USA", profiles.get(1).getShortcut());
        assertEquals("EN", profiles.get(2).getShortcut());
    }
}
