package co.edu.udea.juridicapp.web.bean.dependency;

import co.edu.udea.juridicapp.persistence.dao.IDependencyDAO;
import co.edu.udea.juridicapp.persistence.entity.Dependency;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
@SessionScoped()
public class DependencyBean implements Serializable {

//    private static final long serialVersionUID = 1L;
    @Autowired()
    private IDependencyDAO dependencyDAO;
    private List<String> dependenciesNames;

    public DependencyBean() {
        super();
    }

    public List<String> getDependenciesNames() {

        return (this.dependenciesNames);
    }

    public void setDependenciesNames(List<String> dependenciesNames) {
        this.dependenciesNames = dependenciesNames;
    }

    @PostConstruct()
    private void createFields() {
        this.setDependenciesNames(new ArrayList<String>());

        List<Dependency> dependenciesFound = this.dependencyDAO.findAllDependencies();
        for (Dependency dependency : dependenciesFound) {
            this.getDependenciesNames().add(dependency.getName());
        }
    }
}