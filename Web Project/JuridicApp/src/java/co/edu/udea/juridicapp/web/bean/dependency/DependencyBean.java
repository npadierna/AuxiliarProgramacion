package co.edu.udea.juridicapp.web.bean.dependency;

import co.edu.udea.juridicapp.persistence.dao.IDependencyDAO;
import co.edu.udea.juridicapp.persistence.entity.Dependency;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@Component()
@Scope(value = "singleton")
@ApplicationScoped()
public final class DependencyBean implements Serializable {

    private static final long serialVersionUID = 1082073306114548736L;
    @Autowired()
    private IDependencyDAO dependencyDAO;
    private List<String> dependenciesNames;

    public DependencyBean() {
        super();
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