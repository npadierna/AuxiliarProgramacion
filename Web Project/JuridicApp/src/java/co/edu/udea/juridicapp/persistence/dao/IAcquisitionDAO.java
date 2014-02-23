package co.edu.udea.juridicapp.persistence.dao;

import co.edu.udea.juridicapp.persistence.entity.Acquisition;
import java.util.List;

public interface IAcquisitionDAO {

    public Acquisition deleteAcquisition(Acquisition acquisition);

    public List<Acquisition> findAllAcquisitions();

    public List<Acquisition> findAcquisitionsByAttributes(Object... attributes);

    public Acquisition findAcquisition(String key);

    public String saveAcquisition(Acquisition acquisition);

    public Acquisition updateAcquisition(Acquisition acquisition);

    public long countAcquisitions();

    public List<Acquisition> executeNamedQueryForAcquisitions(String namedQuery,
            String parameterName, Object parameterValue);
}