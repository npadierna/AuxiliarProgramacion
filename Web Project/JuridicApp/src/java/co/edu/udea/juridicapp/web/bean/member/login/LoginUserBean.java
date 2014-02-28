package co.edu.udea.juridicapp.web.bean.member.login;

import co.edu.udea.juridicapp.persistence.dao.IPersonDAO;
import co.edu.udea.juridicapp.persistence.dao.IUserDAO;
import co.edu.udea.juridicapp.persistence.dao.impl.UserDAO;
import co.edu.udea.juridicapp.persistence.entity.User;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@Component()
@SessionScoped()
public class LoginUserBean implements Serializable {

    //private static final long serialVersionUID;c
    @Autowired()
    private IPersonDAO personDAO;
    @Autowired()
    private IUserDAO userDAO;
    private String userName;
    private String password;
    private User loggedUser;
    private boolean loggedIn;

    public LoginUserBean() {
        super();
        
        this.userDAO = new UserDAO();
        this.loggedUser = null;
        this.loggedIn = false;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void logIn(ActionEvent actionEvent) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;

        if ((this.password != null)) {
            this.loggedUser = this.findUserByLogin(this.userName, this.password);
            if (this.loggedUser == null) {
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Datos Inválidos",
                        "Por favor verifique sus datos para iniciar sesión.");
            } else {
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido",
                        userName);
                this.loggedIn = true;
            }
        }
        this.setUserName("");
        this.setPassword("");

        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", loggedIn);
    }

    public void logOut(ActionEvent actionEvent) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        session.invalidate();
        this.loggedIn = false;
    }

    public User findUserByLogin(String userName, String password) {
        User userFound = this.userDAO.findUserByLogin(userName, password);

        if ((userFound != null)) {

            return (userFound);
        }

        return (null);
    }
}
