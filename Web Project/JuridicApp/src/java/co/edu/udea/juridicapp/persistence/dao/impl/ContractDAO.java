package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IContractDAO;
import co.edu.udea.juridicapp.persistence.entity.Contract;
import java.util.ArrayList;
import java.util.List;

public class ContractDAO extends AbstractEntityDAO implements IContractDAO {

    public ContractDAO() {
        super();
    }

    @Override()
    public Contract deleteContract(Contract contract) {

        return ((Contract) super.delete(contract));
    }

    @Override()
    public List<Contract> findAllContracts() {

        return ((List<Contract>) super.findAll(Contract.class));
    }

    @Override()
    public List<Contract> findContractsByAttributes(Object... attributes) {

        return ((List<Contract>) super.findByAttributes(Contract.class,
                attributes));
    }

    @Override()
    public Contract findContract(String key) {

        return ((Contract) super.find(Contract.class, key));
    }

    @Override()
    public String saveContract(Contract contract) {

        return ((String) super.save(contract));
    }

    @Override()
    public Contract updateContract(Contract contract) {
        return ((Contract) super.update(contract));
    }

    @Override()
    public long countContracts() {
        return (super.count(Contract.class));
    }

    @Override()
    public List<Contract> executeNamedQueryForContracts(String namedQuery,
            String parameterName, Object parameterValue) {
        List<Contract> contractsFound = new ArrayList<>();

        for (Object o : super.executeNamedQuery(namedQuery, parameterName,
                parameterValue)) {
            contractsFound.add((Contract) o);
        }

        return (contractsFound);
    }
}