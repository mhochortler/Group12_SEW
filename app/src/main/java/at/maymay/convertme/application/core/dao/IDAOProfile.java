package at.maymay.convertme.application.core.dao;

import java.util.List;

import at.maymay.convertme.application.core.ICategoryContainer;
import at.maymay.convertme.application.core.Profile;

public interface IDAOProfile {
    List<Profile> loadAll(ICategoryContainer container);
}
