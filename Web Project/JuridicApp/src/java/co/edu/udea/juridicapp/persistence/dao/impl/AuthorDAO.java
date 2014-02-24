package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IAuthorDAO;
import co.edu.udea.juridicapp.persistence.entity.Author;
import co.edu.udea.juridicapp.persistence.entity.AuthorPK;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO extends AbstractEntityDAO implements IAuthorDAO {

    public AuthorDAO() {
        super();
    }

    @Override()
    public Author deleteAuthor(Author author) {

        return ((Author) super.delete(author));
    }

    @Override()
    public List<Author> findAllAuthors() {

        return ((List<Author>) super.findAll(Author.class));
    }

    @Override()
    public List<Author> findAuthorsByAttributes(Object... attributes) {

        return ((List<Author>) super.findByAttributes(Author.class,
                attributes));
    }

    @Override()
    public Author findAuthor(AuthorPK key) {

        return ((Author) super.find(Author.class, key));
    }

    @Override()
    public AuthorPK saveAuthor(Author author) {

        return ((AuthorPK) super.save(author));
    }

    @Override()
    public Author updateAuthor(Author author) {
        return ((Author) super.update(author));
    }

    @Override()
    public long countAuthors() {
        return (super.count(Author.class));
    }

    @Override()
    public List<Author> executeNamedQueryForAuthors(String namedQuery, 
            String parameterName, Object parameterValue) {
        
        List<Author> authorsFound = new ArrayList<>();

        for (Object o : super.executeNamedQuery(namedQuery, parameterName,
                parameterValue)) {
            authorsFound.add((Author) o);
        }

        return (authorsFound);
    }
}
