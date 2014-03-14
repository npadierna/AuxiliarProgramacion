package co.edu.udea.juridicapp.persistence.dao;

import co.edu.udea.juridicapp.persistence.entity.Author;
import co.edu.udea.juridicapp.persistence.entity.AuthorWork;
import co.edu.udea.juridicapp.persistence.entity.AuthorWorkPK;
import java.util.List;

public interface IAuthorWorkDAO {

    public AuthorWork deleteAuthorWork(AuthorWork author);

    public List<AuthorWork> findAllAuthorsWorks();

    public List<AuthorWork> findAuthorWorksByAttributes(Object... attributes);

    public AuthorWork findAuthorWork(AuthorWorkPK key);

    public List<AuthorWork> findAuthorsWorksByAuthor(Author author);

    public List<AuthorWork> findAuthorsWorksByWorkId(Long workId);

    public AuthorWorkPK saveAuthorWorkUsingNativeQuery(AuthorWork authorWork);

    public AuthorWorkPK saveAuthorWork(AuthorWork authorWork);

    public AuthorWork updateAuthorWork(AuthorWork authorWork);

    public long countAuthorsWorks();

    public List<AuthorWork> executeNamedQueryForAuthorsWorks(String namedQuery,
            String parameterName, Object parameterValue);
}