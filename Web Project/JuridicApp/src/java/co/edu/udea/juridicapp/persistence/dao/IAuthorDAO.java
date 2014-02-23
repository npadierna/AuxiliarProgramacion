package co.edu.udea.juridicapp.persistence.dao;

import co.edu.udea.juridicapp.persistence.entity.Author;
import co.edu.udea.juridicapp.persistence.entity.AuthorPK;
import java.util.List;

public interface IAuthorDAO {

    public Author deleteAuthor(Author author);

    public List<Author> findAllAuthors();

    public List<Author> findAuthorsByAttributes(Object... attributes);

    public Author findAuthor(AuthorPK key);

    public AuthorPK saveAuthor(Author author);

    public Author updateAuthor(Author author);

    public long countAuthors();

    public List<Author> executeNamedQueryForAuthors(String namedQuery,
            String parameterName, Object parameterValue);
}