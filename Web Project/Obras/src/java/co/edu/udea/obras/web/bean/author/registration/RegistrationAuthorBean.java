package co.edu.udea.obras.web.bean.author.registration;

import co.edu.udea.obras.persistence.dao.IPeopleDAO;
import co.edu.udea.obras.persistence.entity.Author;
import co.edu.udea.obras.persistence.entity.People;
import co.edu.udea.obras.persistence.entity.PeoplePK;
import co.edu.udea.obras.persistence.entity.enums.DocumentTypeClientEnum;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
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
@Scope(value = "request")
@RequestScoped()
public class RegistrationAuthorBean implements Serializable {

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

    public void saveAuthor(ActionEvent actionEvent) {
         FacesMessage m = null;
        if ((this.getDocumentType() != null) && (this.getIdNumber() != null)) {
            this.author.setPeoplePK(new PeoplePK(this.documentType,
                    this.idNumber.trim()));
            this.people.setPeoplePK(new PeoplePK(this.documentType,
                    this.idNumber.trim()));
            this.people.setAuthor(this.author);

            People p = this.peopleDAO.findPeople(new PeoplePK(this.documentType, this.idNumber));

            if (p == null) {
                m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardando...!!",
                        this.people.getFirstNames());
                this.peopleDAO.savePeople(this.people);
                
            } else {
                m = new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Datos Inválidos",
                        "Este Autor ya existe");
            }
        } else {
            m = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Datos Inválidos",
                    "Hay Campos obligatorios que están vacios");
        }
        FacesContext.getCurrentInstance().addMessage(null, m);
        this.setAuthor(new Author());
        this.setPeople(new People());
        this.setDocumentType("");
        this.setIdNumber("");
    }

    @PostConstruct()
    private void createFields() {
        FacesContext.getCurrentInstance().getExternalContext().getSession(true);

        this.setPeople(new People());
        this.setAuthor(new Author());

        this.documentsType = DocumentTypeClientEnum.obtainDocumentsTypeList();
    }
}
