package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IAcquisitionDAO;
import co.edu.udea.juridicapp.persistence.entity.Acquisition;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository()
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class AcquisitionDAO extends AbstractEntityDAO
        implements IAcquisitionDAO {

    public AcquisitionDAO() {
        super();
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Acquisition deleteAcquisition(Acquisition acquisition) {

        return ((Acquisition) super.delete(acquisition));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Acquisition> findAllAcquisitions() {

        return ((List<Acquisition>) super.findAll(Acquisition.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Acquisition> findAcquisitionsByAttributes(
            Object... attributes) {

        return ((List<Acquisition>) super.findByAttributes(Acquisition.class,
                attributes));
    }

    @Override()
    public Acquisition findAcquisition(String key) {

        return ((Acquisition) super.find(Acquisition.class, key));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public String saveAcquisition(Acquisition acquisition) {

        return ((String) super.save(acquisition));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Acquisition updateAcquisition(Acquisition acquisition) {

        return ((Acquisition) super.update(acquisition));
    }

    @Override()
    public long countAcquisitions() {

        return (super.count(Acquisition.class));
    }

    @Override()
    public List<Acquisition> executeNamedQueryForAcquisitions(String namedQuery,
            String parameterName, Object parameterValue) {
        List<Acquisition> acquisitionsFound = new ArrayList<>();

        for (Object o : super.executeNamedQuery(namedQuery, parameterName,
                parameterValue)) {
            acquisitionsFound.add((Acquisition) o);
        }

        return (acquisitionsFound);
    }
}