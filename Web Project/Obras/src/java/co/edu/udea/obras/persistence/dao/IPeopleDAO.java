package co.edu.udea.obras.persistence.dao;

import co.edu.udea.obras.persistence.entity.People;
import co.edu.udea.obras.persistence.entity.PeoplePK;
import java.util.List;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
public interface IPeopleDAO {

    public People deletePeople(People people);

    public List<People> findAllPeoples();

    public List<People> findPeoplesByAttributes(Object... attributes);

    public People findPeople(PeoplePK key);

    public PeoplePK savePeople(People people);

    public People updatePeople(People people);

    public long countPeoples();

    public List<People> executeNamedQueryForPeoples(String namedQuery,
            String parameterName, Object parameterValue);
}