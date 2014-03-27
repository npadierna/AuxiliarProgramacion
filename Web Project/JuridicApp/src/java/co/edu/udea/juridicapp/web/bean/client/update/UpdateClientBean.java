package co.edu.udea.juridicapp.web.bean.client.update;

import co.edu.udea.juridicapp.persistence.dao.IPeopleDAO;
import co.edu.udea.juridicapp.persistence.dao.IClientDAO;
import co.edu.udea.juridicapp.persistence.entity.Client;
import java.io.Serializable;
import java.util.List;
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
public final class UpdateClientBean implements Serializable {

    private static final long serialVersionUID = 9213270134444907520L;
    private static final String DELETE_CLIENT_KEY = "deleted";
    private static final String LOGGED_CLIENT_KEY = "loggedMember";
    private static final String PASSWORD_CHANGED_KEY = "changed";
    @Autowired()
    private IPeopleDAO peopleDAO;
    @Autowired()
    private IClientDAO clientDAO;
    private String lastPassword;
    private String newPassword;
    private String userName;
    private Client loggedClient;
    private boolean changed;

    public UpdateClientBean() {
        super();
    }

    public String getUserName() {

        return (this.userName);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Client getLoggedClient() {

        return (this.loggedClient);
    }

    public void setLoggedClient(Client loggedClient) {
        this.loggedClient = loggedClient;
    }

    public String getLastPassword() {

        return (this.lastPassword);
    }

    public void setLastPassword(String lastPassword) {
        this.lastPassword = lastPassword;
    }

    public String getNewPassword() {

        return (this.newPassword);
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public void changePassword(ActionEvent actionEvent) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Contraseña Inválida", "La contraseña ingresada no es correcta.");
        boolean b = false;

        if (this.loggedClient.getPassword().equals(this.lastPassword)) {
            this.loggedClient.setPassword(this.newPassword);
            this.loggedClient = this.updatePassword(
                    this.loggedClient);

            message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Contraseña Cambiada", "La contraseña ha sido actualizada.");
            b = true;
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam(PASSWORD_CHANGED_KEY, b);
    }

    public void unsubscribe(ActionEvent actionEvent) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Contraseña Inválida", "La contraseña ingresada no es correcta.");
        RequestContext context = RequestContext.getCurrentInstance();
        boolean deleted = false;

        if (this.loggedClient.getPassword().equals(this.newPassword)) {
            this.loggedClient = this.unsubscribeClient(this.loggedClient);

            message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Cuenta Cerrada", "Su cuenta ha sido cerrada exitosamente.");

            HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                    .getExternalContext().getSession(false);
            session.invalidate();
            deleted = true;
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam(DELETE_CLIENT_KEY, deleted);
    }

    public void updateData(ActionEvent actionEvent) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message;
        changed = false;

        Client m = this.updateClient(this.loggedClient, this.userName);
        if (m != null) {
            this.loggedClient = m;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Actualización Exitosa",
                    "Sus datos de la cuenta han sido actualizados.");
            changed = true;
        } else {
            this.userName = this.loggedClient.getUserName();
            message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Correo Electrónico",
                    "El E-mail está asociado a otro usuario existente.");
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam(UpdateClientBean.PASSWORD_CHANGED_KEY, changed);
    }

    public void receiveLoggedClient(Client loggedClient) {
        if (loggedClient != null) {
            this.loggedClient = loggedClient;
            this.userName = this.loggedClient.getUserName();
        }
    }

    private Client updateClient(Client loggedClient, String userName) {
        if (!userName.equals(loggedClient.getUserName())) {
            List<Client> foundClientsByClient = this.clientDAO
                    .executeNamedQueryForClients("Client.findByUserName",
                    "userName", userName);

            if (foundClientsByClient.isEmpty()) {
                loggedClient.setUserName(userName);
            } else {

                return (null);
            }
        }
        this.clientDAO.updateClient(loggedClient);
        this.peopleDAO.updatePeople(loggedClient.getPeople());
        return (loggedClient);
    }

    private Client unsubscribeClient(Client loggedClient) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private Client updatePassword(Client loggedClient) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}