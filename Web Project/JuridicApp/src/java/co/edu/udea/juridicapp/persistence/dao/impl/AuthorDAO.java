package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IAuthorDAO;
import co.edu.udea.juridicapp.persistence.entity.Author;
import co.edu.udea.juridicapp.persistence.entity.AuthorPK;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override()
    public Author findAuthor(AuthorPK key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override()
    public AuthorPK saveAuthor(Author author) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override()
    public Author updateAuthor(Author author) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override()
    public long countAuthors() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override()
    public List<Author> executeNamedQueryForAuthors(String namedQuery, String parameterName, Object parameterValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}