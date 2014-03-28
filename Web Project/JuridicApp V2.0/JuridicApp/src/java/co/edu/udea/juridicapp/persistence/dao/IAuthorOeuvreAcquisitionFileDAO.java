package co.edu.udea.juridicapp.persistence.dao;

import co.edu.udea.juridicapp.persistence.entity.AuthorOeuvreAcquisitionFile;
import co.edu.udea.juridicapp.persistence.entity.AuthorOeuvreAcquisitionFilePK;
import java.util.List;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
public interface IAuthorOeuvreAcquisitionFileDAO {

    public AuthorOeuvreAcquisitionFile deleteAuthorOeuvreAcquisition(
            AuthorOeuvreAcquisitionFile authorOeuvreAcquisition);

    public List<AuthorOeuvreAcquisitionFile> findAllAuthorsOeuvresAcquisitions();

    public List<AuthorOeuvreAcquisitionFile> findAuthorsOeuvresAcquisitionsByAttributes(
            Object... attributes);

    public AuthorOeuvreAcquisitionFile findAuthorOeuvreAcquisition(
            AuthorOeuvreAcquisitionFilePK key);

    public AuthorOeuvreAcquisitionFilePK saveAuthorOeuvreAcquisition(
            AuthorOeuvreAcquisitionFile authorOeuvreAcquisition);

    public AuthorOeuvreAcquisitionFile updateAuthorOeuvreAcquisition(
            AuthorOeuvreAcquisitionFile authorOeuvreAcquisition);

    public long countAuthorsOeuvresAcquisitions();

    public List<AuthorOeuvreAcquisitionFile> executeNamedQueryForAuthorOeuvresAcquisitions(
            String namedQuery,
            String parameterName, Object parameterValue);
}