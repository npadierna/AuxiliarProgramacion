package co.edu.udea.juridicapp.web.bean.tester;

import co.edu.udea.juridicapp.persistence.dao.IAuthorDAO;
import co.edu.udea.juridicapp.persistence.entity.Author;
import co.edu.udea.juridicapp.persistence.entity.AuthorWork;
import co.edu.udea.juridicapp.persistence.entity.PersonPK;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
@SessionScoped()
public class AuthorFinderTesterBean implements Serializable {

    private static final String WORK_NAME_MOCK = "Obra #1 - Mock";
    private static final long serialVersionUID = 1L;
    @Autowired()
    private IAuthorDAO authorDAO;
    private AuthorWork authorWorkForDeleting;
    private List<AuthorWork> authorsWorks;
    private List<Author> foundAuthors;
    private String documentType;
    private String idNumber;

    public AuthorFinderTesterBean() {
        super();
    }

    public AuthorWork getAuthorWorkForDeleting() {

        return (this.authorWorkForDeleting);
    }

    public void setAuthorWorkForDeleting(AuthorWork authorWorkForDeleting) {
        this.authorWorkForDeleting = authorWorkForDeleting;
    }

    public List<AuthorWork> getAuthorsWorks() {

        return (this.authorsWorks);
    }

    public void setAuthorsWorks(List<AuthorWork> authorsWorks) {
        this.authorsWorks = authorsWorks;
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
        AuthorWork authorWork = new AuthorWork(-1L, null,
                author.getPersonPK().getDocumentType(),
                author.getPersonPK().getIdNumber(), null);
        authorWork.setAuthor(author);

        this.getAuthorsWorks().add(authorWork);
        this.getFoundAuthors().remove(author);

        this.setIdNumber("");
    }

    public void findAuthor(ActionEvent actionEvent) {
        if ((this.getDocumentType() != null) && (this.getIdNumber() != null)) {
            this.getFoundAuthors().clear();

            Author a = this.authorDAO.findAuthor(
                    new PersonPK(this.getDocumentType(), this.getIdNumber()));
            if (a != null) {
                this.getFoundAuthors().add(a);
            } else {
                // Mostrar mensaje de error.
            }
        }
    }

    public void removeAuthorWork() {
        if (this.getAuthorWorkForDeleting() != null) {
            this.getAuthorsWorks().remove(this.getAuthorWorkForDeleting());
        }
    }

    public void removeAuthorWork(AuthorWork author) {
        this.getAuthorsWorks().remove(author);
    }

    @PostConstruct()
    private void createFields() {
        this.setAuthorsWorks(new ArrayList<AuthorWork>());
        this.setFoundAuthors(new ArrayList<Author>());
    }
}