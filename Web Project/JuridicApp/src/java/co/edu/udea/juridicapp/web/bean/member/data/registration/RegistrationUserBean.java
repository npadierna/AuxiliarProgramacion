package co.edu.udea.juridicapp.web.bean.member.data.registration;

import co.edu.udea.juridicapp.persistence.dao.IPersonDAO;
import co.edu.udea.juridicapp.persistence.dao.IUserDAO;
import co.edu.udea.juridicapp.persistence.entity.Dependency;
import co.edu.udea.juridicapp.persistence.entity.Person;
import co.edu.udea.juridicapp.persistence.entity.PersonPK;
import co.edu.udea.juridicapp.persistence.entity.Profile;
import co.edu.udea.juridicapp.persistence.entity.User;
import co.edu.udea.juridicapp.persistence.entity.UserPK;
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
public class RegistrationUserBean implements Serializable {

    private static final long serialVersionUID = 123456789L;
    @Autowired()
    private IPersonDAO personDAO;
    @Autowired()
    private IUserDAO userDAO;
    private Person person;
    private User user;
    private String documentType;
    private String idNumber;
    private List<String> documentsType;

    public RegistrationUserBean() {
        super();
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

    public User getUser() {

        return (this.user);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Person getPerson() {

        return (this.person);
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void doSubscribtion(ActionEvent actionEvent) {
        if ((this.documentType != null) && (this.idNumber != null)
                && (this.user.getUserName() != null)
                && (this.user.getPassword() != null)) {
            this.user.setUserPK(new UserPK(this.documentType,
                    this.idNumber.trim()));
            this.user.setDependency(new Dependency("DRAI Facultad De Ingeniería"));
            this.user.setRole(new Profile("Secretaria"));

            this.person.setPersonPK(new PersonPK(this.documentType,
                    this.idNumber.trim()));
            this.person.setUser(this.user);

            this.personDAO.savePerson(this.person);
        }
    }

    @PostConstruct()
    private void createFields() {
        FacesContext.getCurrentInstance().getExternalContext().getSession(true);

        this.person = new Person();
        this.user = new User();
        this.documentsType = DocumentTypeUserEnum.obtainDocumentsTypeList();
    }
}