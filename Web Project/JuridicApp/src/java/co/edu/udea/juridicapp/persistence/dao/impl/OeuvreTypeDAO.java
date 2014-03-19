package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IOeuvreTypeDAO;
import co.edu.udea.juridicapp.persistence.entity.OeuvreType;
import co.edu.udea.juridicapp.persistence.entity.OeuvreTypePK;
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
public class OeuvreTypeDAO extends AbstractEntityDAO implements IOeuvreTypeDAO {

    public OeuvreTypeDAO() {
        super();
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public OeuvreType deleteOeuvreType(OeuvreType oeuvreType) {

        return ((OeuvreType) super.delete(oeuvreType));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<OeuvreType> findAllOeuvresTypes() {

        return ((List<OeuvreType>) super.findAll(OeuvreType.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<OeuvreType> findOeuvresTypesByAttributes(Object... attributes) {

        return ((List<OeuvreType>) super.findByAttributes(OeuvreType.class,
                attributes));
    }

    @Override()
    public OeuvreType findOeuvreType(OeuvreTypePK key) {

        return ((OeuvreType) super.find(OeuvreType.class, key));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public OeuvreTypePK saveOeuvreType(OeuvreType oeuvreType) {

        return ((OeuvreTypePK) super.save(oeuvreType));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public OeuvreType updateOeuvreType(OeuvreType oeuvreType) {
        return ((OeuvreType) super.update(oeuvreType));
    }

    @Override()
    public long countOeuvresTypes() {
        return (super.count(OeuvreType.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<OeuvreType> executeNamedQueryForOeuvresTypes(String namedQuery,
            String parameterName, Object parameterValue) {

        return ((List<OeuvreType>) super.executeNamedQuery(namedQuery,
                parameterName, parameterValue));
    }
}