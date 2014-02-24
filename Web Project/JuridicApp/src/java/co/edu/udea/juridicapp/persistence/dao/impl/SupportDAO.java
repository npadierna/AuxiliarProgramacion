package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.ISupportDAO;
import co.edu.udea.juridicapp.persistence.entity.Support;
import java.util.ArrayList;
import java.util.List;

public class SupportDAO extends AbstractEntityDAO implements ISupportDAO {

    public SupportDAO() {
        super();
    }

    @Override()
    public Support deleteSupport(Support support) {

        return ((Support) super.delete(support));
    }

    @Override()
    public List<Support> findAllSupports() {

        return ((List<Support>) super.findAll(Support.class));
    }

    @Override()
    public List<Support> findSupportsByAttributes(Object... attributes) {

        return ((List<Support>) super.findByAttributes(Support.class,
                attributes));
    }

    @Override()
    public Support findSupport(String key) {

        return ((Support) super.find(Support.class, key));
    }

    @Override()
    public String saveSupport(Support support) {

        return ((String) super.save(support));
    }

    @Override()
    public Support updateSupport(Support support) {
        return ((Support) super.update(support));
    }

    @Override()
    public long countSupports() {
        return (super.count(Support.class));
    }

    @Override()
    public List<Support> executeNamedQueryForSupports(String namedQuery,
            String parameterName, Object parameterValue) {
        List<Support> supportsFound = new ArrayList<>();

        for (Object o : super.executeNamedQuery(namedQuery, parameterName,
                parameterValue)) {
            supportsFound.add((Support) o);
        }

        return (supportsFound);
    }
}