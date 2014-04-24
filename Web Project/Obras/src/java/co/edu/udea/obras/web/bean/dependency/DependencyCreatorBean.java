package co.edu.udea.obras.web.bean.dependency;

import co.edu.udea.obras.persistence.dao.IDependencyDAO;
import co.edu.udea.obras.persistence.entity.Dependency;
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
public final class DependencyCreatorBean implements Serializable {

    private static final long serialVersionUID = 2693090919841893376L;
    @Autowired()
    private IDependencyDAO dependencyDAO;
    private Dependency newDependency;

    public DependencyCreatorBean() {
        super();
    }

    public Dependency getNewDependency() {

        return (this.newDependency);
    }

    public void setNewDependency(Dependency newDependency) {
        this.newDependency = newDependency;
    }

    public void saveDependency(ActionEvent actionEvent) {
        FacesMessage msg;
        if (this.getNewDependency().getName() != null) {
            this.getNewDependency().setName(this.getNewDependency().getName()
                    .trim());

            Dependency d = this.dependencyDAO.findDependency(
                    this.getNewDependency().getName());
            if (d == null) {
                this.dependencyDAO.saveDependency(this.getNewDependency());
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado!!",
                        "Se ha guardado exitosamente la Dependencia: "
                        + this.getNewDependency().getName() + ".");
            } else {
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Datos Inválidos", "Ya Existe una Dependencia: "
                        + this.getNewDependency().getName() + ".");
            }

            this.getNewDependency().setName("");
            this.getNewDependency().setDescription("");
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Datos Inválidos",
                    "Hay Campos obligatorios y requeridos que están vacíos.");
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    @PostConstruct()
    private void createFields() {
        this.setNewDependency(new Dependency());
    }
}