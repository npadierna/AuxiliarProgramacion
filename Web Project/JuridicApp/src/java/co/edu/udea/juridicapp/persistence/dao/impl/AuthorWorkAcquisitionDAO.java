package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IAuthorWorkAcquisitionDAO;
import co.edu.udea.juridicapp.persistence.entity.AuthorWorkAcquisition;
import co.edu.udea.juridicapp.persistence.entity.AuthorWorkAcquisitionPK;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository()
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class AuthorWorkAcquisitionDAO extends AbstractEntityDAO implements
        IAuthorWorkAcquisitionDAO {

    public AuthorWorkAcquisitionDAO() {
        super();
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public AuthorWorkAcquisition deleteAuthorWorkAcquisition(
            AuthorWorkAcquisition authorWorkAcquisition) {

        return ((AuthorWorkAcquisition) super.delete(authorWorkAcquisition));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<AuthorWorkAcquisition> findAllAuthorWorkAcquisitions() {

        return ((List<AuthorWorkAcquisition>) super.findAll(
                AuthorWorkAcquisition.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<AuthorWorkAcquisition> findAuthorWorkAcquisitionsByAttributes(
            Object... attributes) {

        return ((List<AuthorWorkAcquisition>) super.findByAttributes(
                AuthorWorkAcquisition.class,
                attributes));
    }

    @Override()
    public AuthorWorkAcquisition findAuthorWorkAcquisition(
            AuthorWorkAcquisitionPK key) {

        return ((AuthorWorkAcquisition) super.find(AuthorWorkAcquisition.class,
                key));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public AuthorWorkAcquisitionPK saveAuthorWorkAcquisition(
            AuthorWorkAcquisition authorWorkAcquisition) {

        return ((AuthorWorkAcquisitionPK) super.save(authorWorkAcquisition));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public AuthorWorkAcquisition updateAuthorWorkAcquisition(
            AuthorWorkAcquisition authorWorkAcquisition) {
        return ((AuthorWorkAcquisition) super.update(authorWorkAcquisition));
    }

    @Override()
    public long countAuthorWorkAcquisitions() {
        return (super.count(AuthorWorkAcquisition.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<AuthorWorkAcquisition> executeNamedQueryForAuthorWorkAcquisitions(
            String namedQuery,
            String parameterName, Object parameterValue) {

        return ((List<AuthorWorkAcquisition>) super.executeNamedQuery(
                namedQuery, parameterName, parameterValue));
    }
}