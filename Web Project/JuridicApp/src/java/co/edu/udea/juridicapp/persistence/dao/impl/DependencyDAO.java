package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IDependencyDAO;
import co.edu.udea.juridicapp.persistence.entity.Dependency;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository()
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class DependencyDAO extends AbstractEntityDAO implements IDependencyDAO {

    public DependencyDAO() {
        super();
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Dependency deleteDependency(Dependency dependency) {

        return ((Dependency) super.delete(dependency));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Dependency> findAllDependencies() {

        return ((List<Dependency>) super.findAll(Dependency.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Dependency> findDependenciesByAttributes(Object... attributes) {

        return ((List<Dependency>) super.findByAttributes(Dependency.class,
                attributes));
    }

    @Override()
    public Dependency findDependency(String key) {

        return ((Dependency) super.find(Dependency.class, key));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public String saveDependency(Dependency dependency) {

        return ((String) super.save(dependency));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Dependency updateDependency(Dependency dependency) {
        return ((Dependency) super.update(dependency));
    }

    @Override()
    public long countDependencies() {
        return (super.count(Dependency.class));
    }

    @Override()
    public List<Dependency> executeNamedQueryForDependencies(String namedQuery,
            String parameterName, Object parameterValue) {
        List<Dependency> dependencysFound = new ArrayList<>();

        for (Object o : super.executeNamedQuery(namedQuery, parameterName,
                parameterValue)) {
            dependencysFound.add((Dependency) o);
        }

        return (dependencysFound);
    }
}