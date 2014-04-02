package co.edu.udea.juridicapp.web.bean.tester;

import co.edu.udea.juridicapp.persistence.dao.IAuthorDAO;
import co.edu.udea.juridicapp.persistence.dao.IDependencyDAO;
import co.edu.udea.juridicapp.persistence.dao.IOeuvreDAO;
import co.edu.udea.juridicapp.persistence.entity.Author;
import co.edu.udea.juridicapp.persistence.entity.AuthorOeuvre;
import co.edu.udea.juridicapp.persistence.entity.PeoplePK;
import co.edu.udea.juridicapp.persistence.entity.Title;
import co.edu.udea.juridicapp.persistence.entity.Support;
import co.edu.udea.juridicapp.persistence.entity.Oeuvre;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@Component()
@SessionScoped()
public class AuthorFinderTesterBean implements Serializable {

    private static final Oeuvre OEUVRE_MOCK = new Oeuvre("Mock Oeuvre #1");
    private static final long serialVersionUID = 1L;
    @Autowired()
    private IAuthorDAO authorDAO;
    @Autowired()
    private IDependencyDAO dependencyDAO;
    @Autowired()
    private IOeuvreDAO oeuvreDAO;
    private List<AuthorOeuvre> authorsOeuvres;
    private List<Author> foundAuthors;
    private String documentType;
    private String idNumber;

    public AuthorFinderTesterBean() {
        super();
    }

    public List<AuthorOeuvre> getAuthorsOeuvres() {

        return (this.authorsOeuvres);
    }

    public void setAuthorsOeuvres(List<AuthorOeuvre> authorsOeuvres) {
        this.authorsOeuvres = authorsOeuvres;
    }

    public List<Author> getFoundAuthors() {

        return (this.foundAuthors);
    }

    public void setFoundAuthors(List<Author> foundAuthors) {
        this.foundAuthors = foundAuthors;
    }

    public String getDocumentType() {

        return (this.documentType);
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getIdNumber() {

        return (this.idNumber);
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void addAuthor(Author author) {
        AuthorOeuvre authorOeuvre = new AuthorOeuvre(-1L, null,
                author.getPeoplePK().getDocumentType(),
                author.getPeoplePK().getIdNumber(), null, null);
        authorOeuvre.setAuthor(author);
        authorOeuvre.setTitle(new Title());
        authorOeuvre.setSupportType(new Support());

        this.getAuthorsOeuvres().add(authorOeuvre);
        this.getFoundAuthors().remove(author);

        this.setIdNumber("");
    }

    public void findAuthor(ActionEvent actionEvent) {
        if ((this.getDocumentType() != null) && (this.getIdNumber() != null)) {
            this.getFoundAuthors().clear();

            Author a = this.authorDAO.findAuthor(
                    new PeoplePK(this.getDocumentType(), this.getIdNumber()));
            if (a != null) {
                this.getFoundAuthors().add(a);
            } else {
                // Mostrar mensaje de error.
            }
        }
    }

    public void removeAuthorOeuvre(AuthorOeuvre author) {
        this.getAuthorsOeuvres().remove(author);
    }

    public void saveAuthorsOeuvres(ActionEvent actionEvent) {
        OEUVRE_MOCK.setDependency(this.dependencyDAO.findDependency(
                "DRAI Facultad De Ingeniería"));
        Long idOeuvre = this.oeuvreDAO.saveOeuvre(OEUVRE_MOCK);

        for (AuthorOeuvre authorOeuvre : this.getAuthorsOeuvres()) {
            authorOeuvre.getAuthorOeuvrePK().setOeuvreTypeId(idOeuvre);
        }
    }

    @PostConstruct()
    private void createFields() {
        this.setAuthorsOeuvres(new ArrayList<AuthorOeuvre>());
        this.setFoundAuthors(new ArrayList<Author>());
    }
}