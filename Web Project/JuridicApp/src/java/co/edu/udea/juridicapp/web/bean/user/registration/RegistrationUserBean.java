package co.edu.udea.juridicapp.web.bean.user.registration;

import co.edu.udea.juridicapp.persistence.dao.IDependencyDAO;
import co.edu.udea.juridicapp.persistence.dao.IPersonDAO;
import co.edu.udea.juridicapp.persistence.dao.IProfileDAO;
import co.edu.udea.juridicapp.persistence.entity.Person;
import co.edu.udea.juridicapp.persistence.entity.PersonPK;
import co.edu.udea.juridicapp.persistence.entity.User;
import co.edu.udea.juridicapp.persistence.entity.enums.DocumentTypeUserEnum;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
@SessionScoped()
public final class RegistrationUserBean implements Serializable {

    private static final long serialVersionUID = 3757147504987197440L;
    @Autowired()
    private IDependencyDAO dependencyDAO;
    @Autowired()
    private IPersonDAO personDAO;
    @Autowired()
    private IProfileDAO profileDAO;
    private List<String> documentsType;
    private Person person;
    private String dependencyName;
    private String documentType;
    private String idNumber;
    private String profileName;
    private User user;

    public RegistrationUserBean() {
        super();
    }

    public Person getPerson() {

        return (this.person);
    }

    public void setPerson(Person person) {
        this.person = person;
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

    public User getUser() {

        return (this.user);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void doRegistration(ActionEvent actionEvent) {
        if ((this.getDocumentType() != null) && (this.getIdNumber() != null)
                && (this.user.getUserName() != null)
                && (this.user.getPassword() != null)
                && (this.getDependencyName() != null)
                && (this.getProfileName() != null)) {
            this.user.setPersonPK(new PersonPK(this.documentType,
                    this.idNumber.trim()));
            this.user.setDependency(this.dependencyDAO.findDependency(this.getDependencyName()));
            this.user.setRole(this.profileDAO.findProfile(this.getProfileName()));

            this.person.setPersonPK(new PersonPK(this.documentType,
                    this.idNumber.trim()));
            this.person.setUser(this.user);

            this.personDAO.savePerson(this.person);
        }
    }

    @PostConstruct()
    private void createFields() {
        FacesContext.getCurrentInstance().getExternalContext().getSession(true);

        this.setPerson(new Person());
        this.setUser(new User());

        this.documentsType = DocumentTypeUserEnum.obtainDocumentsTypeList();
    }
}