package co.edu.udea.juridicapp.web.bean.member.data.registration;

import co.edu.udea.juridicapp.persistence.dao.IUserDAO;
import co.edu.udea.juridicapp.persistence.entity.Dependency;
import co.edu.udea.juridicapp.persistence.entity.Profile;
import co.edu.udea.juridicapp.persistence.entity.User;
import co.edu.udea.juridicapp.persistence.entity.UserPK;
import co.edu.udea.juridicapp.persistence.entity.enums.DocumentTypeUserEnum;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SessionScoped()
public class RegistrationUserBean implements Serializable {

    // private static final long serialVersionUID = 5809020992897982464L;
    private static final String DATA_OK = "ok";
    @Autowired()
    private IUserDAO userDAO;
    private User newUser;
    private String documentType;
    private String idNumber;
    private List<String> documentsType;

    public RegistrationUserBean() {
        this.newUser = new User();
        this.documentsType = DocumentTypeUserEnum.obtainDocumentsTypeList();
    }

    public List<String> getDocumentsType() {

        return (this.documentsType);
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

    public User getNewUser() {

        return (this.newUser);
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }

    public void doSubscribtion(ActionEvent actionEvent) {

        if ((this.documentType != null) && (this.idNumber != null)
                && (this.newUser.getUserName() != null)
                && (this.newUser.getPassword() != null)) {
            this.newUser.setDependency(new Dependency("Drai Facultad de ingeniería"));
            this.newUser.setRole(new Profile("Secretaria"));
            User m = this.newUser;

            try {
                UserPK userPK = new UserPK(this.documentType,
                        this.idNumber.trim());
                m.setUserPK(userPK);
            } catch (NumberFormatException e) {
            }
            this.newUser = m;
            this.userDAO.saveUser(this.newUser);
            this.newUser = new User();
            this.documentType = null;
            this.idNumber = null;
        }
    }

    /*
     @PostConstruct()
     private void createController() {
     List<MemberControllerEnum> mce = new ArrayList<>();
     mce.add(MemberControllerEnum.REGISTER_MEMBER_CONTROLLER);

     this.memberController = new MemberController(this.userDAO, mce);
     }*/
}
