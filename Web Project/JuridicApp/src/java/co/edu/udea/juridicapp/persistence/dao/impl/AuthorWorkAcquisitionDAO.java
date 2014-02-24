package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IAuthorWorkAcquisitionDAO;
import co.edu.udea.juridicapp.persistence.entity.AuthorWorkAcquisition;
import co.edu.udea.juridicapp.persistence.entity.AuthorWorkAcquisitionPK;
import java.util.ArrayList;
import java.util.List;

public class AuthorWorkAcquisitionDAO extends AbstractEntityDAO implements
        IAuthorWorkAcquisitionDAO {

    public AuthorWorkAcquisitionDAO() {
        super();
    }

    @Override()
    public AuthorWorkAcquisition deleteAuthorWorkAcquisition(
            AuthorWorkAcquisition authorWorkAcquisition) {

        return ((AuthorWorkAcquisition) super.delete(authorWorkAcquisition));
    }

    @Override()
    public List<AuthorWorkAcquisition> findAllAuthorWorkAcquisitions() {

        return ((List<AuthorWorkAcquisition>) super.findAll(
                AuthorWorkAcquisition.class));
    }

    @Override()
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
    public AuthorWorkAcquisitionPK saveAuthorWorkAcquisition(
            AuthorWorkAcquisition authorWorkAcquisition) {

        return ((AuthorWorkAcquisitionPK) super.save(authorWorkAcquisition));
    }

    @Override()
    public AuthorWorkAcquisition updateAuthorWorkAcquisition(
            AuthorWorkAcquisition authorWorkAcquisition) {
        return ((AuthorWorkAcquisition) super.update(authorWorkAcquisition));
    }

    @Override()
    public long countAuthorWorkAcquisitions() {
        return (super.count(AuthorWorkAcquisition.class));
    }

    @Override()
    public List<AuthorWorkAcquisition> executeNamedQueryForAuthorWorkAcquisitions(
            String namedQuery,
            String parameterName, Object parameterValue) {
        List<AuthorWorkAcquisition> authorWorkAcquisitionsFound =
                new ArrayList<>();

        for (Object o : super.executeNamedQuery(namedQuery, parameterName,
                parameterValue)) {
            authorWorkAcquisitionsFound.add((AuthorWorkAcquisition) o);
        }

        return (authorWorkAcquisitionsFound);
    }
}