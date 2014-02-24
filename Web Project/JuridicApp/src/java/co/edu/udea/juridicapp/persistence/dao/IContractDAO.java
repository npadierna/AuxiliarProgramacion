
package co.edu.udea.juridicapp.persistence.dao;

import co.edu.udea.juridicapp.persistence.entity.Contract;
import java.util.List;

public interface IContractDAO {
    
    public Contract deleteContract(Contract contract);

    public List<Contract> findAllContracts();

    public List<Contract> findContractsByAttributes(Object... attributes);

    public Contract findContract(String key);

    public String saveContract(Contract contract);

    public Contract updateContract(Contract contract);

    public long countContracts();

    public List<Contract> executeNamedQueryForContracts(String namedQuery,
            String parameterName, Object parameterValue);
}
