

package co.edu.udea.juridicapp.persistence.dao;

import co.edu.udea.juridicapp.persistence.entity.Dnda;
import java.util.List;

public interface IDndaDAO {
    
    public Dnda deleteDnda(Dnda dnda);

    public List<Dnda> findAllDndas();

    public List<Dnda> findDndasByAttributes(Object... attributes);

    public Dnda findDnda(String key);

    public String saveDnda(Dnda dnda);

    public Dnda updateDnda(Dnda dnda);

    public long countDndas();

    public List<Dnda> executeNamedQueryForDndas(String namedQuery,
            String parameterName, Object parameterValue);
}
