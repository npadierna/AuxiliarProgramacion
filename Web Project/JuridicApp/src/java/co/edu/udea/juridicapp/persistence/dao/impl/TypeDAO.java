package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.ITypeDAO;
import co.edu.udea.juridicapp.persistence.entity.Type;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@Repository()
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class TypeDAO extends AbstractEntityDAO implements ITypeDAO {

    public TypeDAO() {
        super();
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Type deleteType(Type type) {

        return ((Type) super.delete(type));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Type> findAllTypes() {

        return ((List<Type>) super.findAll(Type.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Type> findTypesByAttributes(Object... attributes) {

        return ((List<Type>) super.findByAttributes(Type.class,
                attributes));
    }

    @Override()
    public Type findType(String key) {

        return ((Type) super.find(Type.class, key));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public String saveType(Type type) {

        return ((String) super.save(type));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Type updateType(Type type) {
        return ((Type) super.update(type));
    }

    @Override()
    public long countTypes() {
        return (super.count(Type.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Type> executeNamedQueryForTypes(String namedQuery,
            String parameterName, Object parameterValue) {

        return ((List<Type>) super.executeNamedQuery(namedQuery, parameterName,
                parameterValue));
    }
}