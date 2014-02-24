package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IProfileDAO;
import co.edu.udea.juridicapp.persistence.entity.Profile;
import java.util.ArrayList;
import java.util.List;

public class ProfileDAO extends AbstractEntityDAO implements IProfileDAO {

    public ProfileDAO() {
        super();
    }

    @Override()
    public Profile deleteProfile(Profile profile) {

        return ((Profile) super.delete(profile));
    }

    @Override()
    public List<Profile> findAllProfiles() {

        return ((List<Profile>) super.findAll(Profile.class));
    }

    @Override()
    public List<Profile> findProfilesByAttributes(Object... attributes) {

        return ((List<Profile>) super.findByAttributes(Profile.class,
                attributes));
    }

    @Override()
    public Profile findProfile(String key) {

        return ((Profile) super.find(Profile.class, key));
    }

    @Override()
    public String saveProfile(Profile profile) {

        return ((String) super.save(profile));
    }

    @Override()
    public Profile updateProfile(Profile profile) {
        return ((Profile) super.update(profile));
    }

    @Override()
    public long countProfiles() {
        return (super.count(Profile.class));
    }

    @Override()
    public List<Profile> executeNamedQueryForProfiles(String namedQuery,
            String parameterName, Object parameterValue) {

        List<Profile> profilesFound = new ArrayList<>();

        for (Object o : super.executeNamedQuery(namedQuery, parameterName,
                parameterValue)) {
            profilesFound.add((Profile) o);
        }

        return (profilesFound);
    }
}
