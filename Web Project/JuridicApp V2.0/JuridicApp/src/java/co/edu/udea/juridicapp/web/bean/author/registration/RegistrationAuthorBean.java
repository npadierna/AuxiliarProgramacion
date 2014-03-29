package co.edu.udea.juridicapp.web.bean.author.registration;

import co.edu.udea.juridicapp.persistence.dao.IPeopleDAO;
import co.edu.udea.juridicapp.persistence.entity.Author;
import co.edu.udea.juridicapp.persistence.entity.People;
import co.edu.udea.juridicapp.persistence.entity.enums.DocumentTypeClientEnum;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@Component()
@Scope(value = "session")
@SessionScoped()
public class RegistrationAuthorBean implements Serializable{
    
    private static final long serialVersionUID = 3457147504987197440L;
    @Autowired()
    private IPeopleDAO peopleDAO;
    private List<String> documentsType;
    private People people;
    private String documentType;
    private String idNumber;
    private Author author;

    public RegistrationAuthorBean() {
        super();
    }

    public List<String> getDocumentsType() {
        return documentsType;
    }

    public void setDocumentsType(List<String> documentsType) {
        this.documentsType = documentsType;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    
    public void saveAuthor(ActionEvent actionEvent){
        System.out.println("GUARDANDO!!!");
    }
    
     @PostConstruct()
    private void createFields() {
        FacesContext.getCurrentInstance().getExternalContext().getSession(true);

        this.setPeople(new People());
        this.setAuthor(new Author());

        this.documentsType = DocumentTypeClientEnum.obtainDocumentsTypeList();
    }
}
