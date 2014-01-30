package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IAuthorDAO;
import co.edu.udea.juridicapp.persistence.entity.Author;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
public class AuthorDAO implements IAuthorDAO {

    private static final List<Author> AUTHORS_FOO;

    static {
        AUTHORS_FOO = new ArrayList<>();
        for (int counter = 0; counter < 10; counter++) {
            String s = Integer.toString(counter);
            AUTHORS_FOO.add(new Author("Kind_".concat(s),
                    "Author_".concat(s), "Author_".concat(s)));
        }
    }

    public AuthorDAO() {
        super();
    }

    @Override()
    public List<Author> findAllAuthors() {

        return (AUTHORS_FOO);
    }
}