package co.edu.udea.juridicapp.persistence.dao;

import co.edu.udea.juridicapp.persistence.entity.Author;
import co.edu.udea.juridicapp.persistence.entity.AuthorWork;
import co.edu.udea.juridicapp.persistence.entity.AuthorWorkPK;
import java.util.List;

public interface IAuthorWorkDAO {

    public AuthorWork deleteAuthorWork(AuthorWork author);

    public List<AuthorWork> findAllAuthorWorks();

    public List<AuthorWork> findAuthorWorksByAttributes(Object... attributes);

    public AuthorWork findAuthorWork(AuthorWorkPK key);

    public List<AuthorWork> findAuthorWorkByAuthor(Author author);

    public AuthorWorkPK saveAuthorWork(AuthorWork author);

    public AuthorWork updateAuthorWork(AuthorWork author);

    public long countAuthorWorks();

    public List<AuthorWork> executeNamedQueryForAuthorWorks(String namedQuery,
            String parameterName, Object parameterValue);
}