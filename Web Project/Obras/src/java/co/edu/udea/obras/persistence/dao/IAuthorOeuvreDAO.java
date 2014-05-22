package co.edu.udea.obras.persistence.dao;

import co.edu.udea.obras.persistence.entity.Author;
import co.edu.udea.obras.persistence.entity.AuthorOeuvre;
import java.util.List;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
public interface IAuthorOeuvreDAO {

    public AuthorOeuvre deleteAuthorOeuvre(AuthorOeuvre author);

    public List<AuthorOeuvre> findAllAuthorsOeuvres();

    public List<AuthorOeuvre> findAuthorsOeuvresByAttributes(Object... attributes);

    public AuthorOeuvre findAuthorOeuvre(Long key);

    public List<AuthorOeuvre> findAuthorsOeuvresByAuthor(Author author);

    public List<AuthorOeuvre> findAuthorsOeuvresByOeuvreId(Long oeuvreId);

    public Long saveAuthorOeuvre(AuthorOeuvre authorOeuvre);

    public AuthorOeuvre updateAuthorOeuvre(AuthorOeuvre authorOeuvre);

    public long countAuthorsOeuvres();

    public List<AuthorOeuvre> executeNamedQueryForAuthorsOeuvres(String namedQuery,
            String parameterName, Object parameterValue);
}