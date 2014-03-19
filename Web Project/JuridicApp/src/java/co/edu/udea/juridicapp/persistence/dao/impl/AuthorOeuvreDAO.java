package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IAuthorOeuvreDAO;
import co.edu.udea.juridicapp.persistence.entity.Author;
import co.edu.udea.juridicapp.persistence.entity.AuthorOeuvre;
import co.edu.udea.juridicapp.persistence.entity.AuthorOeuvrePK;
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
public class AuthorOeuvreDAO extends AbstractEntityDAO
        implements IAuthorOeuvreDAO {

    public AuthorOeuvreDAO() {
        super();
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public AuthorOeuvre deleteAuthorOeuvre(AuthorOeuvre authorOeuvre) {

        return ((AuthorOeuvre) super.delete(authorOeuvre));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<AuthorOeuvre> findAllAuthorsOeuvres() {

        return ((List<AuthorOeuvre>) super.findAll(AuthorOeuvre.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<AuthorOeuvre> findAuthorsOeuvresByAttributes(Object... attributes) {

        return ((List<AuthorOeuvre>) super.findByAttributes(AuthorOeuvre.class,
                attributes));
    }

    @Override()
    public AuthorOeuvre findAuthorOeuvre(AuthorOeuvrePK key) {

        return ((AuthorOeuvre) super.find(AuthorOeuvre.class, key));
    }

    @Override()
    public List<AuthorOeuvre> findAuthorsOeuvresByAuthor(Author author) {
        List<AuthorOeuvre> authorOeuvresFound = null;

        if ((author != null) && (author.getKey() != null)) {
            authorOeuvresFound = this.findAuthorsOeuvresByAttributes(
                    "authorOeuvrePK.idNumber", author.getPeoplePK().getIdNumber(),
                    "authorOeuvrePK.documentType",
                    author.getPeoplePK().getDocumentType());
        }

        return (authorOeuvresFound);
    }

    @Override()
    public List<AuthorOeuvre> findAuthorsOeuvresByOeuvreId(Long oeuvreId) {

        return (this.executeNamedQueryForAuthorsOeuvres(
                "AuthorOeuvre.findByOeuvreTypeId", "oeuvreTypeId", oeuvreId));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public AuthorOeuvrePK saveAuthorOeuvre(AuthorOeuvre authorOeuvre) {

        return ((AuthorOeuvrePK) super.save(authorOeuvre));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public AuthorOeuvre updateAuthorOeuvre(AuthorOeuvre authorOeuvre) {
        return ((AuthorOeuvre) super.update(authorOeuvre));
    }

    @Override()
    public long countAuthorsOeuvres() {
        return (super.count(AuthorOeuvre.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<AuthorOeuvre> executeNamedQueryForAuthorsOeuvres(String namedQuery,
            String parameterName, Object parameterValue) {

        return ((List<AuthorOeuvre>) super.executeNamedQuery(namedQuery,
                parameterName, parameterValue));
    }
}