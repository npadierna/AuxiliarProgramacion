package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IUserDAO;
import co.edu.udea.juridicapp.persistence.entity.User;
import co.edu.udea.juridicapp.persistence.entity.UserPK;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractEntityDAO implements IUserDAO {

    public UserDAO() {
        super();
    }

    @Override()
    public User deleteUser(User user) {

        return ((User) super.delete(user));
    }

    @Override()
    public List<User> findAllUsers() {

        return ((List<User>) super.findAll(User.class));
    }

    @Override()
    public List<User> findUsersByAttributes(Object... attributes) {

        return ((List<User>) super.findByAttributes(User.class,
                attributes));
    }

    @Override()
    public User findUser(UserPK key) {

        return ((User) super.find(User.class, key));
    }

    @Override()
    public UserPK saveUser(User user) {

        return ((UserPK) super.save(user));
    }

    @Override()
    public User updateUser(User user) {
        return ((User) super.update(user));
    }

    @Override()
    public long countUsers() {
        return (super.count(User.class));
    }

    @Override()
    public List<User> executeNamedQueryForUsers(String namedQuery,
            String parameterName, Object parameterValue) {
        List<User> usersFound = new ArrayList<>();

        for (Object o : super.executeNamedQuery(namedQuery, parameterName,
                parameterValue)) {
            usersFound.add((User) o);
        }

        return (usersFound);
    }
}