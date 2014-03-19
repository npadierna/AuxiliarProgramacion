package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IClientDAO;
import co.edu.udea.juridicapp.persistence.entity.PeoplePK;
import co.edu.udea.juridicapp.persistence.entity.Client;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository()
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class ClientDAO extends AbstractEntityDAO implements IClientDAO {

    public ClientDAO() {
        super();
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Client deleteClient(Client client) {

        return ((Client) super.delete(client));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Client> findAllClients() {

        return ((List<Client>) super.findAll(Client.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Client> findClientsByAttributes(Object... attributes) {

        return ((List<Client>) super.findByAttributes(Client.class,
                attributes));
    }

    @Override()
    public Client findClient(PeoplePK key) {

        return ((Client) super.find(Client.class, key));
    }

    @Override()
    public Client findClientByLogin(String userName, String password) {
        List<Client> clientsFound = this.findClientsByAttributes("userName",
                userName, "password", password);

        if ((clientsFound != null) && !(clientsFound.isEmpty())) {

            return (clientsFound.get(0));
        }

        return (null);
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public PeoplePK saveClient(Client client) {

        return ((PeoplePK) super.save(client));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Client updateClient(Client client) {
        return ((Client) super.update(client));
    }

    @Override()
    public long countClients() {
        return (super.count(Client.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Client> executeNamedQueryForClients(String namedQuery,
            String parameterName, Object parameterValue) {

        return ((List<Client>) super.executeNamedQuery(namedQuery, parameterName,
                parameterValue));
    }
}