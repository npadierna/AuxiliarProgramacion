package co.edu.udea.juridicapp.web.bean.dependency;

import co.edu.udea.juridicapp.persistence.dao.IDependencyDAO;
import co.edu.udea.juridicapp.persistence.entity.Dependency;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
@SessionScoped()
public class DependencyBean implements Serializable {

    private static final long serialVersionUID = 1082073306114548736L;
    @Autowired()
    private IDependencyDAO dependencyDAO;
    private Dependency dependency;
    private List<String> dependenciesNames;

    public DependencyBean() {
        super();
    }

    public Dependency getDependency() {

        return (this.dependency);
    }

    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }

    public List<String> getDependenciesNames() {

        return (this.dependenciesNames);
    }

    public void setDependenciesNames(List<String> dependenciesNames) {
        this.dependenciesNames = dependenciesNames;
    }

    public void save(ActionEvent actionEvent) {
        if (this.getDependency().getName() != null) {
            this.getDependency().setName(this.getDependency().getName().trim());

            // Chequear sobre la existencia del DNDA.

            Dependency d = this.dependencyDAO.findDependency(
                    this.getDependency().getName());
            if (d == null) {
                this.dependencyDAO.saveDependency(this.getDependency());
            } else {
                // Error, ya existe una dependencia asociada.
            }
        } else {
            // Error, el nombre de la Dependencia es la PK.
        }
    }

    @PostConstruct()
    private void createFields() {
        this.setDependency(new Dependency());
        this.setDependenciesNames(new ArrayList<String>());

        List<Dependency> dependenciesFound =
                this.dependencyDAO.findAllDependencies();
        for (Dependency d : dependenciesFound) {
            this.getDependenciesNames().add(d.getName());
        }
    }
}