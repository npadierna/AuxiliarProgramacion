package co.edu.udea.obras.persistence.dao;

import co.edu.udea.obras.persistence.entity.Type;
import java.util.List;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
public interface ITypeDAO {

    public Type deleteType(Type type);

    public List<Type> findAllTypes();

    public List<Type> findTypesByAttributes(Object... attributes);

    public Type findType(String key);

    public String saveType(Type type);

    public Type updateType(Type type);

    public long countTypes();

    public List<Type> executeNamedQueryForTypes(String namedQuery,
            String parameterName, Object parameterValue);
}