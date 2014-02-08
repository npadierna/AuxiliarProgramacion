package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IAuthorDAO;
import co.edu.udea.juridicapp.persistence.dao.IJuridicalDAO;
import co.edu.udea.juridicapp.persistence.entity.Author;
import co.edu.udea.juridicapp.persistence.entity.Work;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
public class JuridicalDAO implements IJuridicalDAO {

    private static IAuthorDAO authorDAO = new AuthorDAO();
    private static final List<Work> JURIDICAL_FOO;

    static {
        JURIDICAL_FOO = new ArrayList<>();
        for (int counter = 0; counter < 100; counter++) {
            String s = Integer.toString(counter);
            Work j = new Work(new Date(), "ISBN_".concat(s),
                    "Issue_".concat(s), "Kind_".concat(s));

            assignAuthors(j);
            JURIDICAL_FOO.add(j);
        }
    }

    public JuridicalDAO() {
        super();
    }

    @Override()
    public List<Work> findAllJuridical() {

        return (JURIDICAL_FOO);
    }

    private static void assignAuthors(Work juridical) {
        List<Author> authors = authorDAO.findAllAuthors();
        List<Author> temp = new ArrayList<>();

        for (int counter = 0; counter < 2; counter++) {
            temp.add(authors.get((int) Math.random() % authors.size()));
        }

        juridical.setAuthors(temp);
    }
}