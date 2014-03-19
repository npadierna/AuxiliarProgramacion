package co.edu.udea.juridicapp.persistence.dao;

import co.edu.udea.juridicapp.persistence.entity.OeuvreType;
import co.edu.udea.juridicapp.persistence.entity.OeuvreTypePK;
import java.util.List;

public interface IOeuvreTypeDAO {

    public OeuvreType deleteOeuvreType(OeuvreType oeuvreType);

    public List<OeuvreType> findAllOeuvresTypes();

    public List<OeuvreType> findOeuvresTypesByAttributes(Object... attributes);

    public OeuvreType findOeuvreType(OeuvreTypePK key);

    public OeuvreTypePK saveOeuvreType(OeuvreType oeuvreType);

    public OeuvreType updateOeuvreType(OeuvreType oeuvreType);

    public long countOeuvresTypes();

    public List<OeuvreType> executeNamedQueryForOeuvresTypes(String namedQuery,
            String parameterName, Object parameterValue);
}