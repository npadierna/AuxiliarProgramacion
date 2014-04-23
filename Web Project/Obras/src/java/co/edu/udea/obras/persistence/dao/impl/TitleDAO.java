package co.edu.udea.obras.persistence.dao.impl;

import co.edu.udea.obras.persistence.dao.ITitleDAO;
import co.edu.udea.obras.persistence.entity.Title;
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
public class TitleDAO extends AbstractEntityDAO implements ITitleDAO {

    public TitleDAO() {
        super();
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Title deleteTitle(Title title) {

        return ((Title) super.delete(title));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Title> findAllTitles() {

        return ((List<Title>) super.findAll(Title.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Title> findTitlesByAttributes(Object... attributes) {

        return ((List<Title>) super.findByAttributes(Title.class,
                attributes));
    }

    @Override()
    public Title findTitle(String key) {

        return ((Title) super.find(Title.class, key));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public String saveTitle(Title title) {

        return ((String) super.save(title));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Title updateTitle(Title title) {
        return ((Title) super.update(title));
    }

    @Override()
    public long countTitles() {
        return (super.count(Title.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Title> executeNamedQueryForTitles(String namedQuery,
            String parameterName, Object parameterValue) {

        return ((List<Title>) super.executeNamedQuery(namedQuery, parameterName,
                parameterValue));
    }
}