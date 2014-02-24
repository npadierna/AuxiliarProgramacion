package co.edu.udea.juridicapp.persistence.dao;

import co.edu.udea.juridicapp.persistence.entity.AuthorWorkAcquisition;
import co.edu.udea.juridicapp.persistence.entity.AuthorWorkAcquisitionPK;
import java.util.List;

public interface IAuthorWorkAcquisitionDAO {

    public AuthorWorkAcquisition deleteAuthorWorkAcquisition(
            AuthorWorkAcquisition authorWorkAcquisition);

    public List<AuthorWorkAcquisition> findAllAuthorWorkAcquisitions();

    public List<AuthorWorkAcquisition> findAuthorWorkAcquisitionsByAttributes(
            Object... attributes);

    public AuthorWorkAcquisition findAuthorWorkAcquisition(
            AuthorWorkAcquisitionPK key);

    public AuthorWorkAcquisitionPK saveAuthorWorkAcquisition(
            AuthorWorkAcquisition authorWorkAcquisition);

    public AuthorWorkAcquisition updateAuthorWorkAcquisition(
            AuthorWorkAcquisition authorWorkAcquisition);

    public long countAuthorWorkAcquisitions();

    public List<AuthorWorkAcquisition> executeNamedQueryForAuthorWorkAcquisitions(
            String namedQuery,
            String parameterName, Object parameterValue);
}