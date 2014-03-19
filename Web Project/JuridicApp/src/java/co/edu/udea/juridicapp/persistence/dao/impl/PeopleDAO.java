package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IPeopleDAO;
import co.edu.udea.juridicapp.persistence.entity.People;
import co.edu.udea.juridicapp.persistence.entity.PeoplePK;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository()
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class PeopleDAO extends AbstractEntityDAO implements IPeopleDAO {

    public PeopleDAO() {
        super();
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public People deletePeople(People people) {

        return ((People) super.delete(people));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<People> findAllPeoples() {

        return ((List<People>) super.findAll(People.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<People> findPeoplesByAttributes(Object... attributes) {

        return ((List<People>) super.findByAttributes(People.class, attributes));
    }

    @Override()
    public People findPeople(PeoplePK key) {

        return ((People) super.find(People.class, key));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public PeoplePK savePeople(People people) {

        return ((PeoplePK) super.save(people));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public People updatePeople(People people) {

        return ((People) super.update(people));
    }

    @Override()
    public long countPeoples() {

        return (super.count(People.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<People> executeNamedQueryForPeoples(String namedQuery,
            String parameterName, Object parameterValue) {

        return ((List<People>) super.executeNamedQuery(namedQuery,
                parameterName, parameterValue));
    }
}