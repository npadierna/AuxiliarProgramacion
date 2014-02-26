package co.edu.udea.juridicapp.persistence.dao;

import co.edu.udea.juridicapp.persistence.entity.User;
import co.edu.udea.juridicapp.persistence.entity.UserPK;
import java.util.List;

public interface IUserDAO {

    public User deleteUser(User user);

    public List<User> findAllUsers();

    public List<User> findUsersByAttributes(Object... attributes);

    public User findUser(UserPK key);

    public User findUserByLogin(String userName, String password);

    public UserPK saveUser(User user);

    public User updateUser(User user);

    public long countUsers();

    public List<User> executeNamedQueryForUsers(String namedQuery,
            String parameterName, Object parameterValue);
}