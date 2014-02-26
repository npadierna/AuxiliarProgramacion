package co.edu.udea.juridicapp.persistence.dao;

import co.edu.udea.juridicapp.persistence.entity.IEntityContext;
import java.util.List;

public interface IEntityDAO {

    public IEntityContext delete(IEntityContext entity);

    @SuppressWarnings("rawtypes")
    public Object findAll(Class clazz);

    @SuppressWarnings("rawtypes")
    public Object findByAttributes(Class clazz, Object... attributes);

    @SuppressWarnings("rawtypes")
    public IEntityContext find(Class clazz, Object key);

    public Object save(IEntityContext entity);

    public IEntityContext update(IEntityContext entity);

    @SuppressWarnings("rawtypes")
    public long count(Class clazz);

    public Object executeNamedQuery(String namedQuery,
            String paramName, Object paramValue);
}