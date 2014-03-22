package co.edu.udea.juridicapp.web.bean.dependency;

import co.edu.udea.juridicapp.persistence.dao.IDependencyDAO;
import co.edu.udea.juridicapp.persistence.entity.Dependency;
import co.edu.udea.juridicapp.persistence.entity.Dnda;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@Component()
@SessionScoped()
public final class DependencyBean implements Serializable {

    private static final long serialVersionUID = 1082073306114548736L;
    @Autowired()
    private IDependencyDAO dependencyDAO;
    private Dependency dependency;
    private List<String> dependenciesNames;

    public DependencyBean() {
        super();

        this.setDependency(new Dependency());
        this.getDependency().setDnda(new Dnda());
    }

    public Dependency getDependency() {

        return (this.dependency);
    }

    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }

    public List<String> getDependenciesNames() {
        if (this.dependencyDAO.countDependencies()
                != this.dependenciesNames.size()) {
            this.createFields();
        }

        return (this.dependenciesNames);
    }

    public void setDependenciesNames(List<String> dependenciesNames) {
        this.dependenciesNames = dependenciesNames;
    }

    public void save(ActionEvent actionEvent) {
        FacesMessage msg;
        if (this.getDependency().getName() != null) {
            this.getDependency().setName(this.getDependency().getName().trim());

            // Chequear sobre la existencia del DNDA.

            Dependency d = this.dependencyDAO.findDependency(
                    this.getDependency().getName());
            if (d == null) {
                this.dependencyDAO.saveDependency(this.getDependency());
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado!!",
                        "Se ha guardado exitosamente: "
                        + this.getDependency().getName() + ".");
            } else {
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Datos Inválidos", "Ya Existe una Dependencia: "
                        + this.getDependency().getName() + ".");
            }

            this.getDependency().setName("");
            this.getDependency().setDescription("");
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Datos Inválidos",
                    "Hay Campos obligatorios que están vacíos.");
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    @PostConstruct()
    private void createFields() {
        this.setDependenciesNames(new ArrayList<String>());

        List<Dependency> dependenciesFound =
                this.dependencyDAO.findAllDependencies();
        for (Dependency d : dependenciesFound) {
            this.dependenciesNames.add(d.getName());
        }
    }
}