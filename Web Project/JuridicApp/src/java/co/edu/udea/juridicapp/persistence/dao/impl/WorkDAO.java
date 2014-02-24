package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IWorkDAO;
import co.edu.udea.juridicapp.persistence.entity.Work;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository()
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class WorkDAO extends AbstractEntityDAO implements IWorkDAO {

    public WorkDAO() {
        super();
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Work deleteWork(Work work) {

        return ((Work) super.delete(work));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Work> findAllWorks() {

        return ((List<Work>) super.findAll(Work.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Work> findWorksByAttributes(Object... attributes) {

        return ((List<Work>) super.findByAttributes(Work.class,
                attributes));
    }

    @Override()
    public Work findWork(Long key) {

        return ((Work) super.find(Work.class, key));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Long saveWork(Work work) {

        return ((Long) super.save(work));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Work updateWork(Work work) {
        return ((Work) super.update(work));
    }

    @Override()
    public long countWorks() {
        return (super.count(Work.class));
    }

    @Override()
    public List<Work> executeNamedQueryForWorks(String namedQuery,
            String parameterName, Object parameterValue) {
        List<Work> worksFound = new ArrayList<>();

        for (Object o : super.executeNamedQuery(namedQuery, parameterName,
                parameterValue)) {
            worksFound.add((Work) o);
        }

        return (worksFound);
    }
}