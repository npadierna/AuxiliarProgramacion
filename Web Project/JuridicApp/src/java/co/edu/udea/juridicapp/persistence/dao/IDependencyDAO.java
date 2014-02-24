

package co.edu.udea.juridicapp.persistence.dao;

import co.edu.udea.juridicapp.persistence.entity.Dependency;
import java.util.List;

public interface IDependencyDAO {
    
    public Dependency deleteDependency(Dependency dependency);

    public List<Dependency> findAllDependencys();

    public List<Dependency> findDependencysByAttributes(Object... attributes);

    public Dependency findDependency(String key);

    public String saveDependency(Dependency dependency);

    public Dependency updateDependency(Dependency dependency);

    public long countDependencys();

    public List<Dependency> executeNamedQueryForDependencys(String namedQuery,
            String parameterName, Object parameterValue);
}
