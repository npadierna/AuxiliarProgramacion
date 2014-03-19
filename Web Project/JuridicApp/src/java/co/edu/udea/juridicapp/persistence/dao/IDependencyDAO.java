package co.edu.udea.juridicapp.persistence.dao;

import co.edu.udea.juridicapp.persistence.entity.Dependency;
import java.util.List;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
public interface IDependencyDAO {

    public Dependency deleteDependency(Dependency dependency);

    public List<Dependency> findAllDependencies();

    public List<Dependency> findDependenciesByAttributes(Object... attributes);

    public Dependency findDependency(String key);

    public String saveDependency(Dependency dependency);

    public Dependency updateDependency(Dependency dependency);

    public long countDependencies();

    public List<Dependency> executeNamedQueryForDependencies(String namedQuery,
            String parameterName, Object parameterValue);
}