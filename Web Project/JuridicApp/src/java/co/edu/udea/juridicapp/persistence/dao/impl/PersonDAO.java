package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IPersonDAO;
import co.edu.udea.juridicapp.persistence.entity.Person;
import co.edu.udea.juridicapp.persistence.entity.PersonPK;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository()
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class PersonDAO extends AbstractEntityDAO implements IPersonDAO {

    public PersonDAO() {
        super();
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Person deletePerson(Person person) {

        return ((Person) super.delete(person));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Person> findAllPersons() {

        return ((List<Person>) super.findAll(Person.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Person> findPersonsByAttributes(Object... attributes) {

        return ((List<Person>) super.findByAttributes(Person.class, attributes));
    }

    @Override()
    public Person findPerson(PersonPK key) {

        return ((Person) super.find(Person.class, key));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public PersonPK savePerson(Person person) {

        return ((PersonPK) super.save(person));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Person updatePerson(Person person) {

        return ((Person) super.update(person));
    }

    @Override()
    public long countPersons() {

        return (super.count(Person.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Person> executeNamedQueryForPersons(String namedQuery,
            String parameterName, Object parameterValue) {

        return ((List<Person>) super.executeNamedQuery(namedQuery,
                parameterName, parameterValue));
    }
}