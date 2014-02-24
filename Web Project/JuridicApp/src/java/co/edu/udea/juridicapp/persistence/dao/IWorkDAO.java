package co.edu.udea.juridicapp.persistence.dao;

import co.edu.udea.juridicapp.persistence.entity.Work;
import java.util.List;

public interface IWorkDAO {

    public Work deleteWork(Work work);

    public List<Work> findAllWorks();

    public List<Work> findWorksByAttributes(Object... attributes);

    public Work findWork(long key);

    public long saveWork(Work work);

    public Work updateWork(Work work);

    public long countWorks();

    public List<Work> executeNamedQueryForWorks(String namedQuery,
            String parameterName, Object parameterValue);
}
