package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IWorkTypeDAO;
import co.edu.udea.juridicapp.persistence.entity.WorkType;
import co.edu.udea.juridicapp.persistence.entity.WorkTypePK;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository()
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class WorkTypeDAO extends AbstractEntityDAO implements IWorkTypeDAO {

    public WorkTypeDAO() {
        super();
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public WorkType deleteWorkType(WorkType workType) {

        return ((WorkType) super.delete(workType));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<WorkType> findAllWorkTypes() {

        return ((List<WorkType>) super.findAll(WorkType.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<WorkType> findWorkTypesByAttributes(Object... attributes) {

        return ((List<WorkType>) super.findByAttributes(WorkType.class,
                attributes));
    }

    @Override()
    public WorkType findWorkType(WorkTypePK key) {

        return ((WorkType) super.find(WorkType.class, key));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public WorkTypePK saveWorkType(WorkType workType) {

        return ((WorkTypePK) super.save(workType));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public WorkType updateWorkType(WorkType workType) {
        return ((WorkType) super.update(workType));
    }

    @Override()
    public long countWorkTypes() {
        return (super.count(WorkType.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<WorkType> executeNamedQueryForWorkTypes(String namedQuery,
            String parameterName, Object parameterValue) {

        return ((List<WorkType>) super.executeNamedQuery(namedQuery,
                parameterName, parameterValue));
    }
}