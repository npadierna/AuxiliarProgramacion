package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IWorkTypeDAO;
import co.edu.udea.juridicapp.persistence.entity.WorkType;
import co.edu.udea.juridicapp.persistence.entity.WorkTypePK;
import java.util.ArrayList;
import java.util.List;

public class WorkTypeDAO extends AbstractEntityDAO implements IWorkTypeDAO {

    public WorkTypeDAO() {
        super();
    }

    @Override()
    public WorkType deleteWorkType(WorkType workType) {

        return ((WorkType) super.delete(workType));
    }

    @Override()
    public List<WorkType> findAllWorkTypes() {

        return ((List<WorkType>) super.findAll(WorkType.class));
    }

    @Override()
    public List<WorkType> findWorkTypesByAttributes(Object... attributes) {

        return ((List<WorkType>) super.findByAttributes(WorkType.class,
                attributes));
    }

    @Override()
    public WorkType findWorkType(WorkTypePK key) {

        return ((WorkType) super.find(WorkType.class, key));
    }

    @Override()
    public WorkTypePK saveWorkType(WorkType workType) {

        return ((WorkTypePK) super.save(workType));
    }

    @Override()
    public WorkType updateWorkType(WorkType workType) {
        return ((WorkType) super.update(workType));
    }

    @Override()
    public long countWorkTypes() {
        return (super.count(WorkType.class));
    }

    @Override()
    public List<WorkType> executeNamedQueryForWorkTypes(String namedQuery,
            String parameterName, Object parameterValue) {
        List<WorkType> workTypesFound = new ArrayList<>();

        for (Object o : super.executeNamedQuery(namedQuery, parameterName,
                parameterValue)) {
            workTypesFound.add((WorkType) o);
        }

        return (workTypesFound);
    }
}