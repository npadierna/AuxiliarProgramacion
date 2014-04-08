package co.edu.udea.juridicapp.web.bean.client.login;

import co.edu.udea.juridicapp.persistence.dao.IClientDAO;
import co.edu.udea.juridicapp.persistence.entity.Client;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
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
public final class LoginClientBean implements Serializable {

    private static final long serialVersionUID = 3591280342111745024L;
    private static final String LOGGED_IN_KEY = "loggedIn";
    @Autowired()
    private IClientDAO clientDAO;
    private boolean loggedIn;
    private Client loggedClient;
    private String userName;
    private String password;

    public LoginClientBean() {
        super();

        this.setLoggedClient(null);
        this.loggedIn = false;
    }

    public Client getLoggedClient() {

        return (this.loggedClient);
    }

    public void setLoggedClient(Client loggedClient) {
        this.loggedClient = loggedClient;
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

    public boolean isLogged() {

        return (this.loggedIn);
    }

    public boolean isAdmin(Client client) {
        if ((client == null) || (client.getTitle() == null)
                || (client.getTitle().getTitle() == null)) {

            return (false);
        }

        return (client.getTitle().getTitle().equals("Administrador"));
    }

    public void logIn(ActionEvent actionEvent) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;

        this.loggedIn = false;
        if ((this.password != null) && (this.userName != null)) {
            this.loggedClient = this.clientDAO.findClientByLogin(
                    this.userName, this.password);
            if (this.loggedClient == null) {
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Datos Inválidos",
                        "Por favor verifique sus datos para Iniciar Sesión.");
            } else {
                FacesContext.getCurrentInstance().getExternalContext()
                        .getSessionMap().put("usuario", this.userName);

                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@",
                        this.getLoggedClient().getPeople().getFirstNames()
                        .concat(" ").concat(this.getLoggedClient().getPeople()
                                .getLastNames()));

                this.loggedIn = true;
            }
        }

        this.setUserName("");
        this.setPassword("");

        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam(LoginClientBean.LOGGED_IN_KEY, this.loggedIn);
    }

    public void logOut(ActionEvent actionEvent) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        session.invalidate();

        this.loggedIn = false;
    }
}
