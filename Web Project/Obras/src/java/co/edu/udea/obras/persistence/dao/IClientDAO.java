package co.edu.udea.obras.persistence.dao;

import co.edu.udea.obras.persistence.entity.PeoplePK;
import co.edu.udea.obras.persistence.entity.Client;
import java.util.List;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
public interface IClientDAO {

    public Client deleteClient(Client client);

    public List<Client> findAllClients();

    public List<Client> findClientsByAttributes(Object... attributes);

    public Client findClient(PeoplePK key);

    public Client findClientByLogin(String userName, String password);

    public PeoplePK saveClient(Client client);

    public Client updateClient(Client client);

    public long countClients();

    public List<Client> executeNamedQueryForClients(String namedQuery,
            String parameterName, Object parameterValue);
}