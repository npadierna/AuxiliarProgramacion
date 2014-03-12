package co.edu.udea.juridicapp.web.bean.work.create;

import co.edu.udea.juridicapp.persistence.dao.IAuthorDAO;
import co.edu.udea.juridicapp.persistence.dao.IDependencyDAO;
import co.edu.udea.juridicapp.persistence.entity.Dependency;
import co.edu.udea.juridicapp.persistence.entity.Work;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
@SessionScoped()
public final class CreatorWorkBean implements Serializable {

    private static final long serialVersionUID = 2901939557872617472L;
    @Autowired()
    private IAuthorDAO authorDAO;
    @Autowired()
    private IDependencyDAO dependencyDAO;
    private List<String> dependenciesNames;
    private String dependecyName;
    private Work work;

    public CreatorWorkBean() {
        super();
    }

    public List<String> getDependenciesNames() {

        return (this.dependenciesNames);
    }

    public void setDependenciesNames(List<String> dependenciesNames) {
        this.dependenciesNames = dependenciesNames;
    }

    public Work getWork() {

        return (this.work);
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public String getDependecyName() {

        return (this.dependecyName);
    }

    public void setDependecyName(String dependecyName) {
        this.dependecyName = dependecyName;
    }

    @PostConstruct()
    private void createFields() {
        this.setDependenciesNames(new ArrayList<String>());
        this.setWork(new Work());

        List<Dependency> dependenciesFound = this.dependencyDAO.findAllDependencies();

        if ((dependenciesFound != null) && !(dependenciesFound.isEmpty())) {
            for (Dependency dependency : dependenciesFound) {
                this.getDependenciesNames().add(dependency.getName());
            }
        }
    }
}