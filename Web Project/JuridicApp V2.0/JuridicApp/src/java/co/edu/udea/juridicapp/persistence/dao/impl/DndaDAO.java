package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IDndaDAO;
import co.edu.udea.juridicapp.persistence.entity.Dnda;
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
public class DndaDAO extends AbstractEntityDAO implements IDndaDAO {

    public DndaDAO() {
        super();
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Dnda deleteDnda(Dnda dnda) {

        return ((Dnda) super.delete(dnda));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Dnda> findAllDndas() {

        return ((List<Dnda>) super.findAll(Dnda.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Dnda> findDndasByAttributes(Object... attributes) {

        return ((List<Dnda>) super.findByAttributes(Dnda.class,
                attributes));
    }

    @Override()
    public Dnda findDnda(String key) {

        return ((Dnda) super.find(Dnda.class, key));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public String saveDnda(Dnda dnda) {

        return ((String) super.save(dnda));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Dnda updateDnda(Dnda dnda) {
        return ((Dnda) super.update(dnda));
    }

    @Override()
    public long countDndas() {
        return (super.count(Dnda.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Dnda> executeNamedQueryForDndas(String namedQuery,
            String parameterName, Object parameterValue) {

        return ((List<Dnda>) super.executeNamedQuery(namedQuery, parameterName,
                parameterValue));
    }
}