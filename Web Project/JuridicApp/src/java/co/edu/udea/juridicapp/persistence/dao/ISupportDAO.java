package co.edu.udea.juridicapp.persistence.dao;

import co.edu.udea.juridicapp.persistence.entity.Support;
import java.util.List;

public interface ISupportDAO {

    public Support deleteSupport(Support support);

    public List<Support> findAllSupports();

    public List<Support> findSupportsByAttributes(Object... attributes);

    public Support findSupport(String key);

    public String saveSupport(Support support);

    public Support updateSupport(Support support);

    public long countSupports();

    public List<Support> executeNamedQueryForSupports(String namedQuery,
            String parameterName, Object parameterValue);
}
