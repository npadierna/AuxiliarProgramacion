package co.edu.udea.juridicapp.persistence.dao;

import co.edu.udea.juridicapp.persistence.entity.Author;
import co.edu.udea.juridicapp.persistence.entity.AuthorOeuvre;
import co.edu.udea.juridicapp.persistence.entity.AuthorOeuvrePK;
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

    public AuthorOeuvre findAuthorOeuvre(AuthorOeuvrePK key);

    public List<AuthorOeuvre> findAuthorsOeuvresByAuthor(Author author);

    public List<AuthorOeuvre> findAuthorsOeuvresByOeuvreId(Long oeuvreId);

    public AuthorOeuvrePK saveAuthorOeuvre(AuthorOeuvre authorOeuvre);

    public AuthorOeuvre updateAuthorOeuvre(AuthorOeuvre authorOeuvre);

    public long countAuthorsOeuvres();

    public List<AuthorOeuvre> executeNamedQueryForAuthorsOeuvres(String namedQuery,
            String parameterName, Object parameterValue);
}