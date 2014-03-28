package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IProfileDAO;
import co.edu.udea.juridicapp.persistence.entity.Profile;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@Repository()
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class ProfileDAO extends AbstractEntityDAO implements IProfileDAO {

    public ProfileDAO() {
        super();
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Profile deleteProfile(Profile profile) {

        return ((Profile) super.delete(profile));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Profile> findAllProfiles() {

        return ((List<Profile>) super.findAll(Profile.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Profile> findProfilesByAttributes(Object... attributes) {

        return ((List<Profile>) super.findByAttributes(Profile.class,
                attributes));
    }

    @Override()
    public Profile findProfile(String key) {

        return ((Profile) super.find(Profile.class, key));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public String saveProfile(Profile profile) {

        return ((String) super.save(profile));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Profile updateProfile(Profile profile) {
        return ((Profile) super.update(profile));
    }

    @Override()
    public long countProfiles() {
        return (super.count(Profile.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Profile> executeNamedQueryForProfiles(String namedQuery,
            String parameterName, Object parameterValue) {

        return ((List<Profile>) super.executeNamedQuery(namedQuery,
                parameterName, parameterValue));
    }
}