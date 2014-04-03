package co.edu.udea.juridicapp.web.bean.title;

import co.edu.udea.juridicapp.persistence.dao.ITitleDAO;
import co.edu.udea.juridicapp.persistence.entity.Title;
import java.io.Serializable;
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
public final class TitleCreatorBean implements Serializable {

    private static final long serialVersionUID = 8155722109211457536L;
    @Autowired()
    private ITitleDAO titleDAO;
    private Title newTitle;

    public TitleCreatorBean() {
        super();
    }

    public Title getNewTitle() {

        return (this.newTitle);
    }

    public void setNewTitle(Title newTitle) {
        this.newTitle = newTitle;
    }

    public void saveTitle(ActionEvent actionEvent) {
        FacesMessage msg;

        if (this.getNewTitle().getProfile() != null) {
            this.getNewTitle().setProfile(this.getNewTitle().getProfile().trim());

            Title r = this.titleDAO.findTitle(this.getNewTitle().getProfile());
            if (r == null) {
                this.titleDAO.saveTitle(this.getNewTitle());
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado!!",
                        "Se ha guardado exitosamente el Vínculo Universitario:"
                        + this.getNewTitle().getProfile() + ".");
            } else {
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Datos Inválidos", "Ya existe un Vínculo Universitario: "
                        + this.getNewTitle().getProfile() + ".");
            }

            this.getNewTitle().setDescription("");
            this.getNewTitle().setProfile("");
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Datos Inválidos",
                    "Hay campos obligatorios y requeridos que están vacíos.");
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    @PostConstruct()
    private void createFields() {
        this.setNewTitle(new Title());
    }
}