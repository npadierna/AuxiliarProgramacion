package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.ISupportDAO;
import co.edu.udea.juridicapp.persistence.entity.Support;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository()
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class SupportDAO extends AbstractEntityDAO implements ISupportDAO {

    public SupportDAO() {
        super();
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Support deleteSupport(Support support) {

        return ((Support) super.delete(support));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Support> findAllSupports() {

        return ((List<Support>) super.findAll(Support.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Support> findSupportsByAttributes(Object... attributes) {

        return ((List<Support>) super.findByAttributes(Support.class,
                attributes));
    }

    @Override()
    public Support findSupport(String key) {

        return ((Support) super.find(Support.class, key));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public String saveSupport(Support support) {

        return ((String) super.save(support));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Support updateSupport(Support support) {
        return ((Support) super.update(support));
    }

    @Override()
    public long countSupports() {
        return (super.count(Support.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Support> executeNamedQueryForSupports(String namedQuery,
            String parameterName, Object parameterValue) {

        return ((List<Support>) super.executeNamedQuery(namedQuery,
                parameterName, parameterValue));
    }
}