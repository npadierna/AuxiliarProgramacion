package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IAuthorWorkDAO;
import co.edu.udea.juridicapp.persistence.entity.Author;
import co.edu.udea.juridicapp.persistence.entity.AuthorWork;
import co.edu.udea.juridicapp.persistence.entity.AuthorWorkPK;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository()
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class AuthorWorkDAO extends AbstractEntityDAO implements IAuthorWorkDAO {

    public AuthorWorkDAO() {
        super();
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public AuthorWork deleteAuthorWork(AuthorWork authorWork) {

        return ((AuthorWork) super.delete(authorWork));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<AuthorWork> findAllAuthorsWorks() {

        return ((List<AuthorWork>) super.findAll(AuthorWork.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<AuthorWork> findAuthorWorksByAttributes(Object... attributes) {

        return ((List<AuthorWork>) super.findByAttributes(AuthorWork.class,
                attributes));
    }

    @Override()
    public AuthorWork findAuthorWork(AuthorWorkPK key) {

        return ((AuthorWork) super.find(AuthorWork.class, key));
    }

    @Override()
    public List<AuthorWork> findAuthorsWorksByAuthor(Author author) {
        List<AuthorWork> authorWorksFound = null;

        if ((author != null) && (author.getKey() != null)) {
            authorWorksFound = this.findAuthorWorksByAttributes(
                    "authorWorkPK.idNumber", author.getPersonPK().getIdNumber(),
                    "authorWorkPK.documentType",
                    author.getPersonPK().getDocumentType());
        }

        return (authorWorksFound);
    }

    @Override()
    public List<AuthorWork> findAuthorsWorksByWorkId(Long workId) {

        return (this.executeNamedQueryForAuthorsWorks(
                "AuthorWork.findByWorkTypeId", "workTypeId", workId));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public AuthorWorkPK saveAuthorWork(AuthorWork authorWork) {

        return ((AuthorWorkPK) super.save(authorWork));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public AuthorWork updateAuthorWork(AuthorWork authorWork) {
        return ((AuthorWork) super.update(authorWork));
    }

    @Override()
    public long countAuthorsWorks() {
        return (super.count(AuthorWork.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<AuthorWork> executeNamedQueryForAuthorsWorks(String namedQuery,
            String parameterName, Object parameterValue) {

        return ((List<AuthorWork>) super.executeNamedQuery(namedQuery,
                parameterName, parameterValue));
    }
}