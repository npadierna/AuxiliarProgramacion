package co.edu.udea.juridicapp.web.bean.support;

import co.edu.udea.juridicapp.persistence.dao.ISupportDAO;
import co.edu.udea.juridicapp.persistence.entity.Support;
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
public final class SupportCreatorBean implements Serializable {

    private static final long serialVersionUID = 7559855479227413504L;
    @Autowired()
    private ISupportDAO supportDAO;
    private Support newSupport;

    public SupportCreatorBean() {
        super();
    }

    public Support getNewSupport() {

        return (this.newSupport);
    }

    public void setNewSupport(Support newSupport) {
        this.newSupport = newSupport;
    }

    public void saveSupport(ActionEvent actionEvent) {
        FacesMessage msg;

        if (this.getNewSupport().getType() != null) {
            this.getNewSupport().setType(this.getNewSupport().getType().trim());

            Support s = this.supportDAO.findSupport(this.getNewSupport()
                    .getType());
            if (s == null) {
                this.supportDAO.saveSupport(this.getNewSupport());
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado!!",
                        "Se ha guardado exitosamente el Soporte para Obras: "
                        + this.getNewSupport().getType() + ".");
            } else {
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Datos Inválidos", "Ya existe un Soporte para Obras: "
                        + this.getNewSupport().getType() + ".");
            }

            this.getNewSupport().setDescription("");
            this.getNewSupport().setType("");
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Datos Inválidos",
                    "Hay campos obligatorios y requeridos que están vacíos.");
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    @PostConstruct()
    private void createFields() {
        this.setNewSupport(new Support());
    }
}