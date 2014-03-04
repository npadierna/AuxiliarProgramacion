package co.edu.udea.juridicapp.web.bean.member.data.update;

import co.edu.udea.juridicapp.persistence.dao.IPersonDAO;
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

@Component()
@SessionScoped()
public final class UpdateUserBean implements Serializable {

    public static final String DELETE_MEMBER_KEY = "deleted";
    public static final String LOGGED_MEMBER_KEY = "loggedMember";
    public static final String PASSWORD_CHANGED_KEY = "changed";
    @Autowired()
    private IPersonDAO personDAO;
    @Autowired()
    private IUserDAO userDAO;
    private User loggedUser;
    private String lastPassword;
    private String newPassword;
    private String userName;

    public UpdateUserBean() {
        super();
    }

    public String getUserName() {

        return (this.userName);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User getLoggedUser() {

        return (this.loggedUser);
    }

    public void setLoggedMember(User loggedUser) {
        this.loggedUser = loggedUser;
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
        boolean changed = false;

        if (this.loggedUser.getPassword().equals(this.lastPassword)) {
            this.loggedUser.setPassword(this.newPassword);
            this.loggedUser = this.updatePassword(
                    this.loggedUser);

            message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Contraseña Cambiada", "La contraseña ha sido actualizada.");
            changed = true;
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam(PASSWORD_CHANGED_KEY, changed);
    }

    public void unsubscribe(ActionEvent actionEvent) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Contraseña Inválida", "La contraseña ingresada no es correcta.");
        RequestContext context = RequestContext.getCurrentInstance();
        boolean deleted = false;

        if (this.loggedUser.getPassword().equals(this.newPassword)) {
            this.loggedUser = this.unsubscribeUser(this.loggedUser);

            message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Cuenta Cerrada", "Su cuenta ha sido cerrada exitosamente.");

            HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                    .getExternalContext().getSession(false);
            session.invalidate();
            deleted = true;
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam(DELETE_MEMBER_KEY, deleted);
    }

    public void updateData(ActionEvent actionEvent) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message;

        User m = this.updateUser(this.loggedUser, this.userName);
        if (m != null) {
            this.loggedUser = m;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Actualización Exitosa",
                    "Sus datos de la cuenta han sido actualizados.");
        } else {
            this.userName = this.loggedUser.getUserName();
            message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Correo Electrónico",
                    "El E-mail está asociado a otro usuario existente.");
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam(PASSWORD_CHANGED_KEY, true);
    }

    public void receiveLoggedUser(User loggedUser) {
        if (loggedUser != null) {
            this.loggedUser = loggedUser;
            this.userName = this.loggedUser.getUserName();
        }
    }

    private User updateUser(User loggedUser, String userName) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private User unsubscribeUser(User loggedUser) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private User updatePassword(User loggedUser) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
