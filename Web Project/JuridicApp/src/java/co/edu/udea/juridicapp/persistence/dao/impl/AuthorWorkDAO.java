package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IAuthorWorkDAO;
import co.edu.udea.juridicapp.persistence.entity.AuthorWork;
import co.edu.udea.juridicapp.persistence.entity.AuthorWorkPK;
import java.util.ArrayList;
import java.util.List;

public class AuthorWorkDAO extends AbstractEntityDAO implements IAuthorWorkDAO {

    public AuthorWorkDAO() {
        super();
    }

    @Override()
    public AuthorWork deleteAuthorWork(AuthorWork authorWork) {

        return ((AuthorWork) super.delete(authorWork));
    }

    @Override()
    public List<AuthorWork> findAllAuthorWorks() {

        return ((List<AuthorWork>) super.findAll(AuthorWork.class));
    }

    @Override()
    public List<AuthorWork> findAuthorWorksByAttributes(Object... attributes) {

        return ((List<AuthorWork>) super.findByAttributes(AuthorWork.class,
                attributes));
    }

    @Override()
    public AuthorWork findAuthorWork(AuthorWorkPK key) {

        return ((AuthorWork) super.find(AuthorWork.class, key));
    }

    @Override()
    public AuthorWorkPK saveAuthorWork(AuthorWork authorWork) {

        return ((AuthorWorkPK) super.save(authorWork));
    }

    @Override()
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