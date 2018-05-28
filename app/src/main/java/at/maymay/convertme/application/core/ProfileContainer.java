package at.maymay.convertme.application.core;

import java.util.ArrayList;
import java.util.List;

public class ProfileContainer {

    private List<Profile> profiles;

    public ProfileContainer(List<Profile> profiles)
    {
        this.profiles = new ArrayList<>();
        this.profiles = profiles;
    }

    public List<Profile> profiles()
    {
        return profiles;
    }
}
