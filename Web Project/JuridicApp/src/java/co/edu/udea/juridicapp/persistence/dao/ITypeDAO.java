package co.edu.udea.juridicapp.persistence.dao;

import co.edu.udea.juridicapp.persistence.entity.Type;
import java.util.List;

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
