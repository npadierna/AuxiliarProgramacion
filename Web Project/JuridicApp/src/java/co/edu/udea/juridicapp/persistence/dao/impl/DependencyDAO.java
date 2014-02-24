

package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IDependencyDAO;
import co.edu.udea.juridicapp.persistence.entity.Dependency;
import java.util.ArrayList;
import java.util.List;


public class DependencyDAO extends AbstractEntityDAO implements IDependencyDAO{
    
    public DependencyDAO() {
        super();
    }

    @Override()
    public Dependency deleteDependency(Dependency dependency) {

        return ((Dependency) super.delete(dependency));
    }

    @Override()
    public List<Dependency> findAllDependencys() {

        return ((List<Dependency>) super.findAll(Dependency.class));
    }

    @Override()
    public List<Dependency> findDependencysByAttributes(Object... attributes) {

        return ((List<Dependency>) super.findByAttributes(Dependency.class,
                attributes));
    }

    @Override()
    public Dependency findDependency(String key) {

        return ((Dependency) super.find(Dependency.class, key));
    }

    @Override()
    public String saveDependency(Dependency dependency) {

        return ((String) super.save(dependency));
    }

    @Override()
    public Dependency updateDependency(Dependency dependency) {
        return ((Dependency) super.update(dependency));
    }

    @Override()
    public long countDependencys() {
        return (super.count(Dependency.class));
    }

    @Override()
    public List<Dependency> executeNamedQueryForDependencys(String namedQuery, 
            String parameterName, Object parameterValue) {
        
        List<Dependency> dependencysFound = new ArrayList<>();

        for (Object o : super.executeNamedQuery(namedQuery, parameterName,
                parameterValue)) {
            dependencysFound.add((Dependency) o);
        }

        return (dependencysFound);
    }
}
