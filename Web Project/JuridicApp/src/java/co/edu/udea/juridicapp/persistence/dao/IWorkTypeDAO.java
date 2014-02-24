package co.edu.udea.juridicapp.persistence.dao;

import co.edu.udea.juridicapp.persistence.entity.WorkType;
import co.edu.udea.juridicapp.persistence.entity.WorkTypePK;
import java.util.List;

public interface IWorkTypeDAO {

    public WorkType deleteWorkType(WorkType workType);

    public List<WorkType> findAllWorkTypes();

    public List<WorkType> findWorkTypesByAttributes(Object... attributes);

    public WorkType findWorkType(WorkTypePK key);

    public WorkTypePK saveWorkType(WorkType workType);

    public WorkType updateWorkType(WorkType workType);

    public long countWorkTypes();

    public List<WorkType> executeNamedQueryForWorkTypes(String namedQuery,
            String parameterName, Object parameterValue);
}
