package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IAuthorOeuvreAcquisitionFileDAO;
import co.edu.udea.juridicapp.persistence.entity.AuthorOeuvreAcquisitionFile;
import co.edu.udea.juridicapp.persistence.entity.AuthorOeuvreAcquisitionFilePK;
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
public class AuthorOeuvreAcquisitionFileDAO extends AbstractEntityDAO implements
        IAuthorOeuvreAcquisitionFileDAO {

    public AuthorOeuvreAcquisitionFileDAO() {
        super();
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public AuthorOeuvreAcquisitionFile deleteAuthorOeuvreAcquisition(
            AuthorOeuvreAcquisitionFile authorOeuvreAcquisition) {

        return ((AuthorOeuvreAcquisitionFile) super.delete(
                authorOeuvreAcquisition));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<AuthorOeuvreAcquisitionFile> findAllAuthorsOeuvresAcquisitions() {

        return ((List<AuthorOeuvreAcquisitionFile>) super.findAll(
                AuthorOeuvreAcquisitionFile.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<AuthorOeuvreAcquisitionFile> findAuthorsOeuvresAcquisitionsByAttributes(
            Object... attributes) {

        return ((List<AuthorOeuvreAcquisitionFile>) super.findByAttributes(
                AuthorOeuvreAcquisitionFile.class,
                attributes));
    }

    @Override()
    public AuthorOeuvreAcquisitionFile findAuthorOeuvreAcquisition(
            AuthorOeuvreAcquisitionFilePK key) {

        return ((AuthorOeuvreAcquisitionFile) super.find(
                AuthorOeuvreAcquisitionFile.class, key));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public AuthorOeuvreAcquisitionFilePK saveAuthorOeuvreAcquisition(
            AuthorOeuvreAcquisitionFile authorOeuvreAcquisition) {

        return ((AuthorOeuvreAcquisitionFilePK) super.save(
                authorOeuvreAcquisition));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public AuthorOeuvreAcquisitionFile updateAuthorOeuvreAcquisition(
            AuthorOeuvreAcquisitionFile authorOeuvreAcquisition) {

        return ((AuthorOeuvreAcquisitionFile) super.update(
                authorOeuvreAcquisition));
    }

    @Override()
    public long countAuthorsOeuvresAcquisitions() {

        return (super.count(AuthorOeuvreAcquisitionFile.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<AuthorOeuvreAcquisitionFile> executeNamedQueryForAuthorOeuvresAcquisitions(
            String namedQuery, String parameterName, Object parameterValue) {

        return ((List<AuthorOeuvreAcquisitionFile>) super.executeNamedQuery(
                namedQuery, parameterName, parameterValue));
    }
}