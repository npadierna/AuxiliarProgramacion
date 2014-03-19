package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IAuthorDAO;
import co.edu.udea.juridicapp.persistence.entity.Author;
import co.edu.udea.juridicapp.persistence.entity.PeoplePK;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository()
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class AuthorDAO extends AbstractEntityDAO implements IAuthorDAO {

    public AuthorDAO() {
        super();
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Author deleteAuthor(Author author) {

        return ((Author) super.delete(author));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Author> findAllAuthors() {

        return ((List<Author>) super.findAll(Author.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Author> findAuthorsByAttributes(Object... attributes) {

        return ((List<Author>) super.findByAttributes(Author.class,
                attributes));
    }

    @Override()
    public Author findAuthor(PeoplePK key) {

        return ((Author) super.find(Author.class, key));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public PeoplePK saveAuthor(Author author) {

        return ((PeoplePK) super.save(author));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Author updateAuthor(Author author) {
        return ((Author) super.update(author));
    }

    @Override()
    public long countAuthors() {
        return (super.count(Author.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Author> executeNamedQueryForAuthors(String namedQuery,
            String parameterName, Object parameterValue) {

        return ((List<Author>) super.executeNamedQuery(namedQuery, parameterName,
                parameterValue));
    }
}