package co.edu.udea.juridicapp.web.bean.user.login;

import co.edu.udea.juridicapp.persistence.dao.IUserDAO;
import co.edu.udea.juridicapp.persistence.entity.User;
import java.io.Serializable;
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
public final class LoginUserBean implements Serializable {

    private static final long serialVersionUID = 3591280342111745024L;
    private static final String LOGGED_IN_KEY = "loggedIn";
    @Autowired()
    private IUserDAO userDAO;
    private boolean loggedIn;
    private String userName;
    private String password;
    private User loggedUser;

    public LoginUserBean() {
        super();

        this.setLoggedUser(null);
        this.loggedIn = false;
    }

    public User getLoggedUser() {

        return (this.loggedUser);
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public String getPassword() {

        return (this.password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {

        return (this.userName);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void logIn(ActionEvent actionEvent) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;

        this.loggedIn = false;
        if ((this.password != null) && (this.userName != null)) {
            this.loggedUser = this.userDAO.findUserByLogin(
                    this.userName, this.password);
            if (this.loggedUser == null) {
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Datos Inválidos",
                        "Por favor verifique sus datos para Iniciar Sesión.");
            } else {
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido",
                        this.getLoggedUser().getPerson().getFirstNames()
                        .concat(" ").concat(this.getLoggedUser().getPerson()
                        .getLastNames()));
                this.loggedIn = true;
            }
        }
        this.setUserName("");
        this.setPassword("");

        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam(LoginUserBean.LOGGED_IN_KEY, loggedIn);
    }

    public void logOut(ActionEvent actionEvent) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        session.invalidate();
        this.loggedIn = false;
    }
}