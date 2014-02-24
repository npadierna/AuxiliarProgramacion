package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IAuthorWorkDAO;
import co.edu.udea.juridicapp.persistence.entity.AuthorWork;
import co.edu.udea.juridicapp.persistence.entity.AuthorWorkPK;
import java.util.ArrayList;
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
    public List<AuthorWork> findAllAuthorWorks() {

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
    public long countAuthorWorks() {
        return (super.count(AuthorWork.class));
    }

    @Override()
    public List<AuthorWork> executeNamedQueryForAuthorWorks(String namedQuery,
            String parameterName, Object parameterValue) {
        List<AuthorWork> authorWorksFound = new ArrayList<>();

        for (Object o : super.executeNamedQuery(namedQuery, parameterName,
                parameterValue)) {
            authorWorksFound.add((AuthorWork) o);
        }

        return (authorWorksFound);
    }
}