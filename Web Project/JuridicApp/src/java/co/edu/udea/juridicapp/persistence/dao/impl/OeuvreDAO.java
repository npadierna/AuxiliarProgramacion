package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IOeuvreDAO;
import co.edu.udea.juridicapp.persistence.entity.Oeuvre;
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
public class OeuvreDAO extends AbstractEntityDAO implements IOeuvreDAO {

    public OeuvreDAO() {
        super();
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Oeuvre deleteOeuvre(Oeuvre oeuvre) {

        return ((Oeuvre) super.delete(oeuvre));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Oeuvre> findAllOeuvres() {

        return ((List<Oeuvre>) super.findAll(Oeuvre.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Oeuvre> findOeuvresByAttributes(Object... attributes) {

        return ((List<Oeuvre>) super.findByAttributes(Oeuvre.class,
                attributes));
    }

    @Override()
    public Oeuvre findOeuvre(Long key) {

        return ((Oeuvre) super.find(Oeuvre.class, key));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Long saveOeuvre(Oeuvre oeuvre) {

        return ((Long) super.save(oeuvre));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Oeuvre updateOeuvre(Oeuvre oeuvre) {
        return ((Oeuvre) super.update(oeuvre));
    }

    @Override()
    public long countOeuvres() {
        return (super.count(Oeuvre.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Oeuvre> executeNamedQueryForOeuvres(String namedQuery,
            String parameterName, Object parameterValue) {

        return ((List<Oeuvre>) super.executeNamedQuery(namedQuery, parameterName,
                parameterValue));
    }
}