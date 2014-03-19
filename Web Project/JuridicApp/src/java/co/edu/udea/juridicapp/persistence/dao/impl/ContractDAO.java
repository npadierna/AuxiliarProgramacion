package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IContractDAO;
import co.edu.udea.juridicapp.persistence.entity.Contract;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@Repository()
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class ContractDAO extends AbstractEntityDAO implements IContractDAO {

    public ContractDAO() {
        super();
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Contract deleteContract(Contract contract) {

        return ((Contract) super.delete(contract));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Contract> findAllContracts() {

        return ((List<Contract>) super.findAll(Contract.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Contract> findContractsByAttributes(Object... attributes) {

        return ((List<Contract>) super.findByAttributes(Contract.class,
                attributes));
    }

    @Override()
    public Contract findContract(String key) {

        return ((Contract) super.find(Contract.class, key));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public String saveContract(Contract contract) {

        return ((String) super.save(contract));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Contract updateContract(Contract contract) {
        return ((Contract) super.update(contract));
    }

    @Override()
    public long countContracts() {
        return (super.count(Contract.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Contract> executeNamedQueryForContracts(String namedQuery,
            String parameterName, Object parameterValue) {

        return ((List<Contract>) super.executeNamedQuery(namedQuery,
                parameterName, parameterValue));
    }
}