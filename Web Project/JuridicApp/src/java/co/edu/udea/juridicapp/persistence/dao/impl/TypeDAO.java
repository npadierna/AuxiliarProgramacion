package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.ITypeDAO;
import co.edu.udea.juridicapp.persistence.entity.Type;
import java.util.ArrayList;
import java.util.List;

public class TypeDAO extends AbstractEntityDAO implements ITypeDAO {

    public TypeDAO() {
        super();
    }

    @Override()
    public Type deleteType(Type type) {

        return ((Type) super.delete(type));
    }

    @Override()
    public List<Type> findAllTypes() {

        return ((List<Type>) super.findAll(Type.class));
    }

    @Override()
    public List<Type> findTypesByAttributes(Object... attributes) {

        return ((List<Type>) super.findByAttributes(Type.class,
                attributes));
    }

    @Override()
    public Type findType(String key) {

        return ((Type) super.find(Type.class, key));
    }

    @Override()
    public String saveType(Type type) {

        return ((String) super.save(type));
    }

    @Override()
    public Type updateType(Type type) {
        return ((Type) super.update(type));
    }

    @Override()
    public long countTypes() {
        return (super.count(Type.class));
    }

    @Override()
    public List<Type> executeNamedQueryForTypes(String namedQuery,
            String parameterName, Object parameterValue) {
        List<Type> typesFound = new ArrayList<>();

        for (Object o : super.executeNamedQuery(namedQuery, parameterName,
                parameterValue)) {
            typesFound.add((Type) o);
        }

        return (typesFound);
    }
}