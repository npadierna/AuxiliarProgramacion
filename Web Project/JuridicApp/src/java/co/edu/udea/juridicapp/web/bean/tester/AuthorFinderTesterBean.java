package co.edu.udea.juridicapp.web.bean.tester;

import co.edu.udea.juridicapp.persistence.dao.IAuthorDAO;
import co.edu.udea.juridicapp.persistence.dao.IDependencyDAO;
import co.edu.udea.juridicapp.persistence.dao.IWorkDAO;
import co.edu.udea.juridicapp.persistence.entity.Author;
import co.edu.udea.juridicapp.persistence.entity.AuthorWork;
import co.edu.udea.juridicapp.persistence.entity.PersonPK;
import co.edu.udea.juridicapp.persistence.entity.Role;
import co.edu.udea.juridicapp.persistence.entity.Support;
import co.edu.udea.juridicapp.persistence.entity.Work;
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

    private static final Work WORK_MOCK = new Work("Mock Work #1");
    private static final long serialVersionUID = 1L;
    @Autowired()
    private IAuthorDAO authorDAO;
    @Autowired()
    private IDependencyDAO dependencyDAO;
    @Autowired()
    private IWorkDAO workDAO;
    private List<AuthorWork> authorsWorks;
    private List<Author> foundAuthors;
    private String documentType;
    private String idNumber;

    public AuthorFinderTesterBean() {
        super();
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
        authorWork.setRole(new Role());
        authorWork.setSupportType(new Support());

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

    public void removeAuthorWork(AuthorWork author) {
        this.getAuthorsWorks().remove(author);
    }

    public void saveAuthorsWorks(ActionEvent actionEvent) {
        WORK_MOCK.setDependency(this.dependencyDAO.findDependency("DRAI Facultad De Ingeniería"));
        Long idWork = this.workDAO.saveWork(WORK_MOCK);

        for (AuthorWork authorWork : this.getAuthorsWorks()) {
            authorWork.getAuthorWorkPK().setWorkTypeId(idWork);
        }
    }

    @PostConstruct()
    private void createFields() {
        this.setAuthorsWorks(new ArrayList<AuthorWork>());
        this.setFoundAuthors(new ArrayList<Author>());
    }
}