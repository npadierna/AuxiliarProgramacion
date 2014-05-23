package co.edu.udea.obras.web.bean.client.registration;

import co.edu.udea.obras.persistence.dao.IDependencyDAO;
import co.edu.udea.obras.persistence.dao.IPeopleDAO;
import co.edu.udea.obras.persistence.dao.IProfileDAO;
import co.edu.udea.obras.persistence.entity.People;
import co.edu.udea.obras.persistence.entity.PeoplePK;
import co.edu.udea.obras.persistence.entity.Client;
import co.edu.udea.obras.persistence.entity.enums.DocumentTypeClientEnum;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
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
public final class RegistrationClientBean implements Serializable {

    private static final long serialVersionUID = 3757147504987197440L;
    @Autowired()
    private IDependencyDAO dependencyDAO;
    @Autowired()
    private IPeopleDAO peopleDAO;
    @Autowired()
    private IProfileDAO profileDAO;
    private List<String> documentsType;
    private People people;
    private String dependencyName;
    private String documentType;
    private String idNumber;
    private String profileName;
    private Client client;

    public RegistrationClientBean() {
        super();
    }

    public People getPeople() {

        return (this.people);
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public String getDependencyName() {

        return (this.dependencyName);
    }

    public void setDependencyName(String dependencyName) {
        this.dependencyName = dependencyName;
    }

    public List<String> getDocumentsType() {

        return (this.documentsType);
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

    public String getProfileName() {

        return (this.profileName);
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public Client getClient() {

        return (this.client);
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void doRegistration(ActionEvent actionEvent) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado!!",
                this.people.getFirstNames());

        if ((this.getDocumentType() != null) && (this.getIdNumber() != null)
                && (this.client.getUserName() != null)
                && (this.client.getPassword() != null)
                && (this.getDependencyName() != null)
                && (this.getProfileName() != null)
                && (this.getPeople().getEmail() != null)) {
            this.client.setPeoplePK(new PeoplePK(this.documentType,
                    this.idNumber.trim()));
            this.client.setDependency(this.dependencyDAO.findDependency(
                    this.getDependencyName()));
            this.client.setTitle(this.profileDAO.findProfile(
                    this.getProfileName()));

            this.people.setPeoplePK(new PeoplePK(this.documentType,
                    this.idNumber.trim()));
            this.people.setClient(this.client);

            People p = this.peopleDAO.findPeople(new PeoplePK(this.documentType, this.idNumber));

            if (p == null) {
                this.peopleDAO.savePeople(this.people);
            } else if (p.getClient() != null) {
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Datos Inválidos",
                        "Este usuario ya existe");
            } else {
                p.setClient(this.client);
                this.peopleDAO.updatePeople(people);
            }
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Datos Inválidos",
                    "Hay Campos obligatorios que están vacios");
        }

        this.setClient(new Client());
        this.setPeople(new People());
        this.setDocumentType("");
        this.setIdNumber("");

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    @PostConstruct()
    private void createFields() {
        this.setPeople(new People());
        this.setClient(new Client());

        this.documentsType = DocumentTypeClientEnum.obtainDocumentsTypeList();
    }
}