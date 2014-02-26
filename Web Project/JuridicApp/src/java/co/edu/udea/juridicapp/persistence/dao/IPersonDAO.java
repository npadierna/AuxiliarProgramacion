package co.edu.udea.juridicapp.persistence.dao;

import co.edu.udea.juridicapp.persistence.entity.Person;
import co.edu.udea.juridicapp.persistence.entity.PersonPK;
import java.util.List;

public interface IPersonDAO {

    public Person deletePerson(Person person);

    public List<Person> findAllPersons();

    public List<Person> findPersonsByAttributes(Object... attributes);

    public Person findPerson(PersonPK key);

    public PersonPK savePerson(Person person);

    public Person updatePerson(Person person);

    public long countPersons();

    public List<Person> executeNamedQueryForPersons(String namedQuery,
            String parameterName, Object parameterValue);
}