package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IAcquisitionDAO;
import co.edu.udea.juridicapp.persistence.entity.Acquisition;
import java.util.ArrayList;
import java.util.List;

public class AcquisitionDAO extends AbstractEntityDAO
        implements IAcquisitionDAO {

    public AcquisitionDAO() {
        super();
    }

    @Override()
    public Acquisition deleteAcquisition(Acquisition acquisition) {

        return ((Acquisition) super.delete(acquisition));
    }

    @Override()
    public List<Acquisition> findAllAcquisitions() {

        return ((List<Acquisition>) super.findAll(Acquisition.class));
    }

    @Override()
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
    public String saveAcquisition(Acquisition acquisition) {

        return ((String) super.save(acquisition));
    }

    @Override()
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