package co.edu.udea.obras.persistence.dao;

import co.edu.udea.obras.persistence.entity.IEntityContext;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
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